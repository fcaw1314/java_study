package org.example.book.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
        //1.记录开始时间
        //2.执行目标方法
        //3.记录结束时间
        //4.记录耗时
        long start = System.currentTimeMillis();
        //2.执行目标方法
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + "耗时" + (end - start) + "ms");
        return result;
    }
}
