package org.bite.mybatis.mapper;

import org.bite.mybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserInfoXMLMapperTest {

    @Autowired
    private UserInfoXMLMapper userInfoXMLMapper;

    @Test
    void queryUserInfos() {
        userInfoXMLMapper.queryUserInfos().forEach(System.out::println);
    }

    @Test
    void queryUserInfos2() {
        userInfoXMLMapper.queryUserInfos2().forEach(System.out::println);
    }

    @Test
    void insertUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("杨晓波");
        userInfo.setPassword("yxb");
        userInfo.setGender(0);
        userInfo.setAge(22);

        userInfoXMLMapper.insertUserInfo(userInfo);
    }

    @Test
    void updateUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPhone("888");
        userInfo.setId(12);
        userInfoXMLMapper.updateUserInfo(userInfo);
    }

    @Test
    void deleteUser() {
        userInfoXMLMapper.deleteUser(12);
    }

    @Test
    void insertByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("djx22");
        userInfo.setPassword("djx22");
        userInfo.setGender(0);
//        userInfo.setAge(22);
        userInfo.setPhone("1111111111111");
        userInfoXMLMapper.insertByCondition(userInfo);
    }
}