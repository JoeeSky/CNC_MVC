package com.cnc.service;

import com.cnc.model.entity.User;

/**
 * Created by Joe on 2015/12/26.
 */
public interface UserService {
    void addUser(String json);
    User getUser(String json);
    User login(String json);
}
