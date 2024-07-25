package org.bite.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bite.mybatis.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoXMLMapper {

    List<UserInfo> queryUserInfos();

    List<UserInfo> queryUserInfos2();

    Integer insertUserInfo(UserInfo userInfo);

    Integer updateUserInfo(UserInfo userInfo);

    Integer deleteUser(Integer id);

    Integer insertByCondition(UserInfo userInfo);
}
