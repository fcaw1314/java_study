package com.bite.trans.controller;

import com.bite.trans.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/8/2 15:38
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/registry")
    public Boolean registry(String name, String password){
        Integer result = userService.insertUser(name,password);
        log.info("数据影响行数：" + result);
        return true;
    }
}
