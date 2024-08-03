package com.bite.trans.model;

import lombok.Data;

import java.util.Date;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/8/2 16:33
 */
@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private Date createTime;
    private Date updateTime;
}
