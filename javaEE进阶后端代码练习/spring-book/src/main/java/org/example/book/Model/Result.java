package org.example.book.Model;

import lombok.Data;
import org.example.book.enums.ResultCodeEnum;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/29 14:02
 */
@Data
public class Result<T> {
    private ResultCodeEnum code;
    private String errMsg;
    private T data;

    public static <T> Result<T> nologin(){
        //用户未登录
        Result result = new Result<>();
        result.setCode(ResultCodeEnum.NOLOGIN);
        result.setErrMsg("用户未登录");
        return result;
    }

    public static <T> Result<T> success(T data){
        //用户未登录
        Result result = new Result<>();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(String errMsg){
        //失败异常
        Result result = new Result();
        result.setErrMsg(errMsg);
        result.setCode(ResultCodeEnum.FAIL);
        result.setData(null);
        return result;
    }
}
