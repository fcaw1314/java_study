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

    @Test
    void insert2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setAge(14);
        userInfo.setGender(1);
        userInfo.setDeleteFlag(1);
        userInfo.setPassword("zhaoliu");
        userInfo.setPhone("18556455214");
        Integer result = userInfoMapper.insert2(userInfo);
        System.out.println("添加数据: " + result + ",自增id: " + userInfo.getId());
    }

    @Test
    void delete() {
        System.out.println(userInfoMapper.delete(11));
    }

    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(10);
        userInfo.setPassword("123456");
        System.out.println(userInfoMapper.update(userInfo));
    }

    @Test
    void queryUserInfo3() {
        userInfoMapper.queryUserInfo3().forEach(System.out::println);
    }

    @Test
    void insertByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("djx22");
        userInfo.setPassword("djx22");
        userInfo.setGender(0);
//        userInfo.setAge(22);
        userInfo.setPhone("1111111111111");
        userInfoMapper.insertByCondition(userInfo);
    }
}