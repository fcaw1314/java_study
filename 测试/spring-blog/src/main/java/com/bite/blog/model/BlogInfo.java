package com.bite.blog.model;

import lombok.Data;

import java.util.Date;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/8/3 16:30
 */
@Data
public class BlogInfo {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
