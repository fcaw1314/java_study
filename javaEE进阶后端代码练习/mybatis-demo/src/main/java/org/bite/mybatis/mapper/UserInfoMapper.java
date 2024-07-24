package org.bite.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.bite.mybatis.model.UserInfo;

import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/24 10:23
 */

@Mapper
public interface UserInfoMapper {

    @Select("select * from userinfo where id = 1")
    List<UserInfo> queryUserInfos();

    @Select("select * from userinfo where id = #{value}")
    UserInfo queryUserInfo( Integer id);

    @Select("select * from userinfo where id = #{id} and username = #{name}")
    UserInfo queryUserInfoByIdAndName(Integer id , String name);

    @Select("select * from userinfo where id = #{param1} and username = #{param2}")
    UserInfo queryUserInfoByIdAndName2(@Param("id") Integer id , @Param("name") String name);

    @Insert("insert into userinfo (username, password, age, gender, phone, delete_flag)" +
            "values (#{username},#{password},#{age},#{gender},#{phone},#{deleteFlag})")
    Integer insert(UserInfo userInfo);
}
