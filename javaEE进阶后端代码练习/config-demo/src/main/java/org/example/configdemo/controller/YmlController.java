package org.example.configdemo.controller;

import jakarta.annotation.PostConstruct;
import org.example.configdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YmlController {
    @Value("${myKey}")
    private String myKey;

    @Value("${server.port}")
    private Integer serverPort;

    @Value("${server.reactive.session.cookie.domain}")
    private String cookieDomain;

    @Value("${string.str1}")
    private String str1;
    @Value("${string.str2}")
    private String str2;
    @Value("${string.str3}")
    private String str3;

    @Autowired
    private Student student;


    @PostConstruct
    public void readValue(){
        System.out.println("================================");
//        System.out.println(myKey);
//        System.out.println(serverPort);
//        System.out.println(cookieDomain);
//
//        System.out.println(str1);
//        System.out.println(str2);
//        System.out.println(str3);
        System.out.println(student);
    }
}
