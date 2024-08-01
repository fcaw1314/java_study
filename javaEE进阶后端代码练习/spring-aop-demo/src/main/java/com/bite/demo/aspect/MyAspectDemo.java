package com.bite.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(10)
//@Component
@Slf4j
@Aspect
public class MyAspectDemo {

    @Pointcut("execution(* com.bite.demo.controller.*.*(..))")
    public void pt(){};

    @Before("pt()")
    public void doBefore(JoinPoint joinPoint){
//        log.info(joinPoint.getSignature().toShortString());
        log.info("执行before方法...");
    }

    @After("pt()")
    public void doAfter(){
        log.info("执行after方法...");
    }

}
