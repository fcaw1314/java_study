package org.example.configdemo.controller;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/log")
@RestController
public class LogController {
    private static Logger logger = LoggerFactory.getLogger(LogController.class);

    @PostConstruct
    public void print(){
        System.out.println("打印日志");
        logger.trace("我是trace日志");
        logger.debug("我是debug日志");
        logger.info("我是info日志");
        logger.warn("我是warn日志");
        logger.error("我是Error日志");
    }
}
