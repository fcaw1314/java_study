package org.example.book.Model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/14 11:30
 */
@Data
public class BookInfo {

    private Integer id;
    private String bookName;
    private String author;
    private Integer count;

    private BigDecimal price;
    private String publish;
    private Integer status;//1.可借阅   2.不可借阅
    private String stateCN;

    private Date createTime;
    private Date updateTime;

}
