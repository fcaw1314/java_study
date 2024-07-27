package com.bite.mybatis.plus.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/27 13:26
 */
@TableName("userinfo")
@Data
public class Userinfo {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
