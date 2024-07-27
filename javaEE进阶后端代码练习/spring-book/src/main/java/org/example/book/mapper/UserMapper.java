package org.example.book.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.book.Model.UserInfo;

@Mapper
public interface UserMapper {


    @Select("select * from user_info where delete_flag = 0 and user_name = #{userName}")
    UserInfo queryUserByName(String userName);
}
