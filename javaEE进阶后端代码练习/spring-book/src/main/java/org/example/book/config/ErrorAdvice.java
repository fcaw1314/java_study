package org.example.book.config;

import lombok.extern.slf4j.Slf4j;
import org.example.book.Model.Result;
import org.example.book.enums.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/31 10:00
 */
@Slf4j
//@ResponseBody
//@ControllerAdvice
@RestControllerAdvice
public class ErrorAdvice {
    @ExceptionHandler
    public Result handler(Exception e) {
        log.error("发生异常, e: ", e);
        return Result.fail("发生异常" + e.getMessage());
    }

    @ExceptionHandler
    public Result handler(NullPointerException e) {
        log.error("发生NullPointerException异常, e: ", e);
        return Result.fail("发生空指针异常" + e.getMessage());
    }

    @ExceptionHandler
    public Result handler(ArithmeticException e) {
        log.error("发生ArithmeticException异常, e: ", e);
        return Result.fail("发生算术异常" + e.getMessage());
    }

}
