package org.example.book.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.book.Model.UserInfo;
import org.example.book.Service.UserService;
import org.example.book.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/14 11:31
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(String userName, String password, HttpSession session) {
        log.info("用户登录 username: {}, password: {}",userName,password);
        //1.参数校验
        //2.验证用户名和密码
        //3.存session
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return "用户名或密码不能为空";
        }

        //根据用户名,查询用户信息,判断密码是否为空
        UserInfo userInfo = userService.queryUserByName(userName);
        if (userInfo == null || userInfo.getId() < 0) {
            return "用户不存在";
        }
        if(!password.equals(userInfo.getPassword())){
            return "账号或者密码错误";
        }
        //存储session
        userInfo.setPassword("");
        session.setAttribute(Constants.USER_SESSION_KEY, userInfo);
        return "";
    }
}
