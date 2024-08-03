package com.bite.trans.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/8/2 15:40
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user_info(`user_name`,`password`)values(#{name},#{password})")
    Integer insert(String name,String password);
}
