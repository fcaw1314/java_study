package org.example.book.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.book.Model.*;
import org.example.book.Service.BookService;
import org.example.book.constant.Constants;
import org.example.book.enums.ResultCodeEnum;
import org.example.book.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/14 11:31
 */
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

//    @RequestMapping("/getList")
//    public List<BookInfo> getList() {
//        //没有数据,采用mock方式
//        // BookService bookService = new BookService();
//        List<BookInfo> bookInfos = bookService.getList();
//        return bookInfos;
//    }

    @RequestMapping("/getListByPage")
    public Result<PageResult<BookInfo>> getListByPage(RequestPage requestPage, HttpSession session) {
        log.info("getListByPage 接收参数: {}", requestPage);
        //1.参数校验，转换
        PageResult<BookInfo> result = bookService.getListByPage(requestPage);
        return Result.success(result);
    }

    @RequestMapping("/addBook")
    public Boolean addBook(BookInfo bookInfo) {
        log.info("BookController.addBook 接受参数: {}", bookInfo);
        //1.参数校验
        if (!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount() == null
                || bookInfo.getPrice() == null
                || !StringUtils.hasLength(bookInfo.getPublish())) {
            log.warn("参数不正确");
            return false;
        }
        Integer result = bookService.addBook(bookInfo);
        if (result == 0) {
            log.error("添加图书失败");
            return false;
        }
        return true;
    }

    /**
     * @description 根据id获取图书
     * spring-book
     * @date 2024/7/29 11:41:30
     */
    @RequestMapping("/getBookInfo")
    public BookInfo getBookInfo(Integer bookId) {
        log.info("getBookInfo, bookId: {}", bookId);
        //需要看接口约定,当图书信息不存在时,是返回null,还是返回空对象
        BookInfo bookInfo = bookService.getBookInfo(bookId);
        return bookInfo;
    }

    /**
     * @description 更新图书
     * spring-book
     * @date 2024/7/29 11:41:57
     */
    @RequestMapping("/updateBook")
    public Boolean updateBook(BookInfo bookInfo) {
        log.info("updateBook, bookInfo: {}", bookInfo);
        if (bookInfo.getId() == null) {
            log.warn("Id不能为空");
            return false;
        }
        if (bookInfo.getBookName() != null && "".equals(bookInfo.getBookName().trim())) {
            log.warn("图书名称不能为空");
            return false;
        }

        try {
            Integer result = bookService.updateBook(bookInfo);
            if (result > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("updateBook error, e: {}", e);
            return false;
        }
    }

    @RequestMapping("/deleteBook")
    public Boolean delete(Integer bookId) {
        log.info("deleteBook, id: " + bookId);
        try {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(bookId);
            bookInfo.setStatus(StatusEnum.DELETED.getCode());
            Integer result = bookService.updateBook(bookInfo);
            if (result > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("deleteBook error, e: {}", e);
            return false;
        }
    }

    @RequestMapping("/batchDelete")
    public Boolean batchDelete(@RequestParam List<Integer> ids) {
        log.info("batchDelete ids: {}", ids);
        if (ids == null || ids.size() == 0) {
            //没有任何删除的数据
            return true;
        }
        try {
            Integer result = bookService.batchDelete(ids);
            if (result > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("batchDelete error: ", e);
            return false;
        }

    }
}
