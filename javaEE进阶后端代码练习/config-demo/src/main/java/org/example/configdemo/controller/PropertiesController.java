package org.example.configdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/prop")
@RestController
public class PropertiesController {
    @Value("${font.size}")
    private String fontSize;

    @Value("${spring.datasource.url}")
    private String mysqlUrl;

    @RequestMapping("/readValue")
    public String readValue(){
        System.out.println(mysqlUrl);
        return "fontSize:"+ fontSize;
    }
}
