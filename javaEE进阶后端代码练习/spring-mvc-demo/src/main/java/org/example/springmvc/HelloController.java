package org.example.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/9 9:42
 */

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello spring mvc";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String demo1(){
        return "hello spring mvc";
    }

}
