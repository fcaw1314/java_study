package com.bite.demo.controller;

import com.bite.demo.aspect.CostTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/u1")
    public String u1(){
        int[] arr = {1,2,3};
        return "u1";
    }
    @CostTime
    @RequestMapping("/u2")
    public Integer u2(){
        return 10;
    }
}
