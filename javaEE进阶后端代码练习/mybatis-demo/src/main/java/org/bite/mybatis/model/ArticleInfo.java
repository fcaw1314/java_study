package org.bite.mybatis.model;

import lombok.Data;

import java.util.Date;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/24 10:19
 */
@Data
public class ArticleInfo {
    private Integer id;
    private String title;
    private String content;
    private Integer uid;

    private String username;
    private Integer age;

    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
