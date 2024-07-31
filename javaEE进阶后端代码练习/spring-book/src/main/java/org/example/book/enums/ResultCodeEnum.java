package org.example.book.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/29 14:03
 */
@AllArgsConstructor
public enum ResultCodeEnum {
    //成功 200
    //未登录  -1
    //后端发生异常  数据库异常   -2   参数异常   -3

    SUCCESS(200, "成功"),
    NOLOGIN(-1, "未登录"),
    FAIL(-2, "其他错误"),
    ;
    @Getter
    private int code;

    @Getter
    private String name;


}
