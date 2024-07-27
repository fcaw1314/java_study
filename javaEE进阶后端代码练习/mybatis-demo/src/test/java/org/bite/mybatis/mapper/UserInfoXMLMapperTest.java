package org.bite.mybatis.mapper;

import org.bite.mybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


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
        userInfo.setUsername("djx");
        userInfo.setPassword("djx");
        userInfo.setGender(0);
        userInfo.setAge(22);

        userInfoXMLMapper.insertByCondition(userInfo);
    }

    @Test
    void selectByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(22);
        userInfoXMLMapper.selectByCondition2(userInfo).forEach(System.out::println);
    }

    @Test
    void updateByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("你好");
        userInfo.setPassword("520");
        userInfo.setId(27);
//        userInfo.setAge(22);

        userInfoXMLMapper.updateByCondition(userInfo);
    }

    @Test
    void updateByCondition2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("1314");
        userInfo.setPassword("1314");
        userInfo.setId(27);
        userInfo.setAge(22);
        userInfoXMLMapper.updateByCondition2(userInfo);
    }

    @Test
    void batchDelete() {
        userInfoXMLMapper.BatchDelete(List.of(25,26,27));
    }
}