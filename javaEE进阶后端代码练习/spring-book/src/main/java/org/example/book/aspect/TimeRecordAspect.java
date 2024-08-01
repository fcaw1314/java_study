package org.example.book.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/31 14:15
 */
@Component
@Slf4j
@Aspect
public class TimeRecordAspect {

    @Around("execution(* org.example.book.Controller.*.*(..))")
    public Object timeRecord(ProceedingJoinPoint joinPoint) throws Throwable {
        //1. 记录开始时间
        //2. 执行目标方法
        //3. 记录结束时间
        //4. 记录耗时
        long start = System.currentTimeMillis();
        log.info("do Around 前");
        //执行目标方法
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("执行Around 方法发生异常");
            throw new RuntimeException(e);
        }
        log.info("do Around 后");
        log.info(joinPoint.getSignature()+ "耗时:" + (System.currentTimeMillis()-start) + "ms");
        return result;
    }

    @Before("execution(* org.example.book.Controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().toShortString());
        log.info("执行before方法...");
    }

    @After("execution(* org.example.book.Controller.*.*(..))")
    public void doAfter(){
        log.info("执行after方法...");
    }

    @AfterThrowing("execution(* org.example.book.Controller.*.*(..))")
    public void doAfterThrowing(){
        log.info("执行doAfterThrowing方法...");
    }

    @AfterReturning("execution(* org.example.book.Controller.*.*(..))")
    public void doAfterReturing(){
        log.info("执行doAfterReturing方法...");
    }
}
