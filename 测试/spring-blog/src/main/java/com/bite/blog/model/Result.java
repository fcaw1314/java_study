package com.bite.blog.model;

import com.bite.blog.enmus.ResultCodeEnum;
import lombok.Data;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/8/3 16:39
 */

@Data
public class Result<T> {
    private int code;
    private String errMsg;
    private T data;

    public static <T> Result success(T data){
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setData(data);
        return result;
    }

    public static <T> Result fail(String errMsg){
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setData(errMsg);
        return result;
    }

    public static <T> Result fail(String errMsg,T data){
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setData(errMsg);
        return result;
    }
}
