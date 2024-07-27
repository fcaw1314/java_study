package org.example.book.Service;

import org.example.book.Model.UserInfo;
import org.example.book.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/26 15:29
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserInfo queryUserByName(String userName) {
        return userMapper.queryUserByName(userName);
    }
}
