package com.bite.blog.model;

import lombok.Data;

import java.util.Date;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/8/3 16:29
 */

@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private String githubUrl;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

}
