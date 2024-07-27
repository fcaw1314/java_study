package org.example.book.Model;

import lombok.Data;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/26 15:25
 */
@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private Integer deleteFlag;
    private Data createTime;
    private Data updateTime;

}
