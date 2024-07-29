package org.example.book.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.book.Model.BookInfo;

import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/26 16:44
 */
@Mapper
public interface BookMapper {

    @Insert("insert into book_info (book_name, author, count, price, publish, `status`) " +
            "values (#{bookName},#{author}, #{count}, #{price}, #{publish}, #{status})")
    Integer insertBook(BookInfo bookInfo);

    @Select("select count(1) from book_info where status !=0 ")
    Integer count();


    @Select("select * from book_info where status!=0 order by id desc limit #{offset}, #{limit}")
    List<BookInfo> getListByPage(Integer offset, Integer limit);

    @Select("select * from book_info where id = #{bookId}")
    BookInfo getBookInfo(Integer bookId);

    Integer updateBook(BookInfo bookInfo);

    Integer batchDelete(List<Integer> ids);
}
