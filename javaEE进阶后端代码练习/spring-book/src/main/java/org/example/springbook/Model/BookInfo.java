package org.example.springbook.Model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/14 11:30
 */
@Data
public class BookInfo {

    private Integer bookId;
    private String bookName;
    private String author;
    private Integer num;
    private BigDecimal price;
    private String publishName;
    private Integer state;//1.可借阅   2.不可借阅
    private String stateCN;

    public BookInfo() {

    }
}
