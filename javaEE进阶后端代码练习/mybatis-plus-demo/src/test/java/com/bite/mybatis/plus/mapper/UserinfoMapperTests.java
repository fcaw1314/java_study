package com.bite.mybatis.plus.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/27 13:42
 */

@SpringBootTest
public class UserinfoMapperTests {
    @Autowired
    private UserinfoMapper userinfoMapper;

    @Test
    void select(){
        userinfoMapper.selectList(null).forEach(System.out::println);
    }
}
