package org.bite.mybatis.controller;

import org.bite.mybatis.model.UserInfo;
import org.bite.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/24 10:13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryUserInfos")
    public List<UserInfo> queryUserInfos(){
        return userService.queryUserInfos();
    }

}
