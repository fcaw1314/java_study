package org.example.springbootdemo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/8 15:05
 */

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello Spring Boot~";
    }


    @RequestMapping("/hello111")
    public String hello2(){
//        int a= 4/0;
//        return 111;
        return "hello Spring Boot~杨晓波";
    }

    @RequestMapping("/sayHi")
    public String sayHi(){
        return "hello sayHi";
    }
}
