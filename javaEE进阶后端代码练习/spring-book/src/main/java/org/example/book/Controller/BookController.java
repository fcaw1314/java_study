package org.example.book.Controller;

import org.example.book.Model.BookInfo;
import org.example.book.Model.PageResult;
import org.example.book.Model.RequestPage;
import org.example.book.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/14 11:31
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @RequestMapping("/getList")
    public List<BookInfo> getList() {
        //没有数据,采用mock方式
       // BookService bookService = new BookService();
        List<BookInfo> bookInfos = bookService.getList();
        return bookInfos;
    }

//    @RequestMapping("/getListPage")
//    public PageResult<BookInfo> getListPage(RequestPage requestPage){
//
//    }
}
