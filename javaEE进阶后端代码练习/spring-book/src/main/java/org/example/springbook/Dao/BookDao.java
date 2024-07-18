package org.example.springbook.Dao;

import org.example.springbook.Model.BookInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/16 15:32
 */
@Repository
public class BookDao {

    public List<BookInfo> mockData() {
        List<BookInfo> bookInfos = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setBookId(i);
            bookInfo.setBookName("图书" + i);
            bookInfo.setAuthor("作者" + i);
            bookInfo.setNum(15 * i + 1);
            bookInfo.setPrice(new BigDecimal(22 * i + 5 - 0.5 * i));
            bookInfo.setPublishName("出版社" + i);
            bookInfo.setState(i % 5 == 0 ? 2 : 1);
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
