package com.bite.blog.enmus;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/8/3 16:40
 */
@AllArgsConstructor
public enum ResultCodeEnum {
    SUCCESS(200),
    NO_LOGIN(-1),
    FAIL(-2);

    @Getter
    int code;

}
