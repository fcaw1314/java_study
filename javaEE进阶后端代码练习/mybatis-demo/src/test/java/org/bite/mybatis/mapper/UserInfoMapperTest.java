package org.bite.mybatis.mapper;

import org.bite.mybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void queryUserInfos() {
        userInfoMapper.queryUserInfos().forEach(System.out::println);
    }

    @Test
    void queryUserInfo() {
        System.out.println(userInfoMapper.queryUserInfo(1));
    }

    @Test
    void queryUserInfoByIdAndName() {
        System.out.println(userInfoMapper.queryUserInfoByIdAndName(1, "admin"));
    }


    @Test
    void queryUserInfoByIdAndName2() {
        System.out.println(userInfoMapper.queryUserInfoByIdAndName2(1, "admin"));
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setAge(14);
        userInfo.setGender(1);
        userInfo.setDeleteFlag(1);
        userInfo.setPassword("zhaoliu");
        userInfo.setPhone("18556455214");
        Integer result = userInfoMapper.insert(userInfo);
        System.out.println("添加数据: " + result);
    }
}