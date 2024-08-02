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
    @Insert("insert into ")
    Integer insert(String name,String password);
}
