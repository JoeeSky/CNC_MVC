package com.cnc.controller;

import com.cnc.exception.BadRequestException;
import com.cnc.exception.NotFoundException;
import com.cnc.model.entity.User;
import com.cnc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Joe on 2015/12/26.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @RequestMapping("/hello")
    String home() {
        return "Hello World!";
    }

    /**
     * 获取用户信息
     * @param name
     * @return
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getUser(@PathVariable String name) throws NotFoundException{

        return userService.getUser(name);
    }

    /**
     * 用户注册接口
     * @param json
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody String json) throws BadRequestException{
        userService.addUser(json);
        return json;
    }

    /**
     * 用户登录接口
     * @param json
     //* @param httpSession
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public void login(@RequestBody String json,HttpSession httpSession) throws BadRequestException{
        User user = userService.login(json);
        httpSession.setAttribute("id",user.getId());
    }

    /**
     * 用户注销接口
     * @param httpSession
     */
    @RequestMapping(value = "/login",method = RequestMethod.DELETE)
    @ResponseBody
    public void logout(HttpSession httpSession) throws BadRequestException{
        httpSession.invalidate();
    }
}
