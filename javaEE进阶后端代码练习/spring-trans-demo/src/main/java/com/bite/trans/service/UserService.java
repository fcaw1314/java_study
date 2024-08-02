package com.bite.trans.service;

import com.bite.trans.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/8/2 15:40
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Integer insertUser(String name, String password) {
        return userMapper.insert(name,password);
    }
}
