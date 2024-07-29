package org.example.book.Service;

import org.example.book.Model.BookInfo;
import org.example.book.Model.PageResult;
import org.example.book.Model.RequestPage;
import org.example.book.enums.StatusEnum;
import org.example.book.mapper.BookMapper;
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
//@RequestMapping("/getList")
//public List<BookInfo> getList() {
//    //BookDao bookDao = new BookDao();
//    //没有数据,采用mock方式
//    List<BookInfo> bookInfos = bookDao.mockData();
//    for (BookInfo bookInfo : bookInfos) {
//        if (bookInfo.getStatus() == 1) {
//            bookInfo.setStateCN("可借阅");
//        } else {
//            bookInfo.setStateCN("不可借阅");
//        }
//    }
//    return bookInfos;
//}


@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public Integer addBook(BookInfo bookInfo) {
        return bookMapper.insertBook(bookInfo);
    }

    public PageResult<BookInfo> getListByPage(RequestPage requestPage) {
        //1.count
        Integer count = bookMapper.count();
        List<BookInfo> bookInfos = bookMapper.getListByPage(requestPage.getOffset(),requestPage.getPageSize());

        for(BookInfo bookInfo : bookInfos){
            bookInfo.setStateCN(StatusEnum.getNameByCode(bookInfo.getStatus()).getName());
        }
        return new PageResult<>(bookInfos,count,requestPage);

//        PageResult<BookInfo> result = new PageResult<>();
//        result.setItems(bookInfos);
//        result.setCount(count);
//        return result;
    }

    public BookInfo getBookInfo(Integer bookId) {
        return bookMapper.getBookInfo(bookId);
    }

    public Integer updateBook(BookInfo bookInfo) {
        return bookMapper.updateBook(bookInfo);
    }

    public Integer batchDelete(List<Integer> ids) {
        return bookMapper.batchDelete(ids);
    }
}
