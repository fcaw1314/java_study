package org.bite.mybatis.mapper;

import org.apache.ibatis.annotations.*;
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

    @Options(useGeneratedKeys = true , keyProperty = "id")
    @Insert("insert into userinfo (username, password, age, gender, phone, delete_flag)" +
            "values (#{userInfo.username},#{userInfo.password}," +
            "#{userInfo.age},#{userInfo.gender},#{userInfo.phone},#{userInfo.deleteFlag})")
    Integer insert2(@Param("userInfo") UserInfo userInfo);

    @Delete("delete from userinfo where id = #{id}")
    Integer delete(Integer id);

    @Update("update userinfo set password = #{password} where id = #{id}")
    Integer update(UserInfo userInfo);

    //注解方式(定义结果映射)
    @Results({
            @Result(column = "delete_flag",property = "deleteFlag"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime"),
    })
    @Select("select * from userinfo")
    List<UserInfo> queryUserInfo3();

    //不推荐
    @Insert("<script>insert into userinfo (username, password," +
            "<if test='age != null'> age,</if> " +
            "gender, phone) " +
            "values (#{username}, #{password}, " +
            "<if test='age != null'> #{age},</if> " +
            "#{gender}, #{phone}) " +
            "</script>")
    Integer insertByCondition(UserInfo userInfo);
}
