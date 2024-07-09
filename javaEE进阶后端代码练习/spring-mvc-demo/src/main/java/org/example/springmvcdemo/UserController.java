package org.example.springmvcdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/9 9:42
 */

@RestController
public class UserController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello spring mvc";
    }
}
