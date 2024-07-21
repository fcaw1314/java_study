package org.example.configdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/21 10:21
 */

@RequestMapping("/prop")
@RestController
public class PropertiesController {

    @Value("${font.size}")
    private String fontSize;

    @RequestMapping("/readValue")
    public String readValue() {
        return "fontSize:" + fontSize;
    }


}
