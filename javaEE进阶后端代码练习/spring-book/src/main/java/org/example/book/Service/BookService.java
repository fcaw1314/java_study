package org.example.book.Service;

import org.example.book.Dao.BookDao;
import org.example.book.Model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/16 15:31
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;
    @RequestMapping("/getList")
    public List<BookInfo> getList() {
        //BookDao bookDao = new BookDao();
        //没有数据,采用mock方式
        List<BookInfo> bookInfos = bookDao.mockData();
        for (BookInfo bookInfo : bookInfos) {
            if (bookInfo.getState() == 1) {
                bookInfo.setStateCN("可借阅");
            } else {
                bookInfo.setStateCN("不可借阅");
            }
        }
        return bookInfos;
    }

    public Integer addBook(BookInfo bookInfo){

    }
}
