package org.example.book.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.book.Model.UserInfo;
import org.example.book.Service.UserService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/14 11:31
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("login")
    public String login(String userName, String password, HttpSession session) {
        //1.参数校验
        //2.验证用户名和密码
        //3.存session
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return "用户名或密码不能为空";
        }
        //未学习数据库操作,暂时硬编码
        //写死 userName = zhangsan , password = 123456
//        if(!"zhangsan".equals(userName) || !"123456".equals(password)) {
//            return "账号或密码错误";
//        }


        //存储session

        //根据用户名,查询用户信息,判断密码是否为空
        UserInfo userInfo = userService.queryUserByName(userName);
        if (userInfo == null || userInfo.getId() < 0) {
            return "用户不存在";
        }
        session.setAttribute("userName", userName);
        return "";
    }
}
