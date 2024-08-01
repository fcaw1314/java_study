package com.bite.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(4)
//@Component
@Slf4j
@Aspect
public class MyAspectDemo4 {

    @Before("com.bite.demo.aspect.MyAspectDemo.pt()")
    public void doBefore(JoinPoint joinPoint){
//        log.info(joinPoint.getSignature().toShortString());
        log.info("执行 MyAspectDemo4.before方法...");
    }

    @After("com.bite.demo.aspect.MyAspectDemo.pt()")
    public void doAfter(){
        log.info("执行 MyAspectDemo4.after方法...");
    }

}
