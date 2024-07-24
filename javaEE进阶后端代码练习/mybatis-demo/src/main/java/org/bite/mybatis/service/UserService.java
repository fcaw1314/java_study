package org.bite.mybatis.service;

import org.bite.mybatis.mapper.UserInfoMapper;
import org.bite.mybatis.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/24 10:22
 */

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> queryUserInfos(){
        return userInfoMapper.queryUserInfos();
    }
}
