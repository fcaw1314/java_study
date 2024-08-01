package com.bite.demo.controller;

import com.bite.demo.aspect.CostTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/test")
@RestController
public class TestController {
    @CostTime
    @RequestMapping("/t1")
    public String t1(){
        int[] arr = {1,2,3};
        return "t1";
    }
    @RequestMapping("/t2")
    public Integer t2(){
        return 10;
    }
    @RequestMapping("/t3")
    public Boolean t3(){
        String a = null;
        System.out.println(a.length());
        return true;
    }

}
