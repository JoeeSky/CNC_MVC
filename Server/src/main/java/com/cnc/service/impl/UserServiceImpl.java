package com.cnc.service.impl;

import com.cnc.model.entity.User;
import com.cnc.repository.UserRepository;
import com.cnc.service.UserService;
import com.cnc.utils.CommonUtils;
import com.cnc.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Joe on 2015/12/26.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * 获取用户信息
     * @param name
     * @return
     */
    @Override
    public User getUser(String name){
        User user = userRepository.findByName(name);
        if(user==null){
        }
        return user;
    }

    /**
     * 处理UserController提交过来的数据
     * @param json
     */
    @Override
    public void addUser(String json){
        Map<String,Object> data = JsonUtils.decode(json,Map.class);
        String nameTest = (String) data.get("name");
        String passwordTest = (String) data.get("password");
        if (CommonUtils.checkName(nameTest)
                && CommonUtils.checkPassword(passwordTest)){
            User user = userRepository.findByName(nameTest);
            if(user == null){
                User userTest = new User();
                userTest.setName(nameTest);
                userTest.setPassword(CommonUtils.md5(passwordTest));
                userRepository.save(userTest);
            }else {
                //throw
            }
        }else {
            //throw
        }

    }

    /**
     * 用户登录接口
     * @param json
     * @return
     */
    @Override
    public User login(String json){
        Map<String,Object> data = JsonUtils.decode(json,Map.class);
        String name = (String) data.get("name");
        String password = CommonUtils.md5((String) data.get("password"));
        User user = isUserValid(name,password);
        if(user != null){
            return user;
        }else{
            return null;
            //throw
        }
    }

    /**
     * 验证账号密码是否正确
      * @param name
     * @param password
     * @return
     */
    private User isUserValid(String name, String password){
        User user = userRepository.findByName(name);
        if(password.equals(user.getPassword())){
            return user;
        }else{
            return null;
        }

    }

}
