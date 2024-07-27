package org.example.book.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/26 17:01
 */
@AllArgsConstructor
public enum StatusEnum {
    DELETED(0,"无效"),
    NORMAL(1,"可借阅"),
    FORBIDDEN(2,"不可借阅");

    @Getter
    private int code;
    @Getter
    private String name;

    public static StatusEnum getNameByCode(int code){
//        switch (code){
//            case 0: return DELETED;
//            case 1: return NORMAL;
//            case 2: return FORBIDDEN;
//        }
//        return null;

//        Arrays.stream(StatusEnum.values()).forEach();

        for(StatusEnum statusEnum: StatusEnum.values()){
            if(statusEnum.getCode() == code){
                return statusEnum;
            }
        }
        return null;
    }
}
