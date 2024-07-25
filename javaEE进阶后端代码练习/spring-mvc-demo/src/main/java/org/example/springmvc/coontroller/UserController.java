package org.example.springmvc.coontroller;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/13 10:47
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public boolean login(String userName, String password, HttpSession session) {
        //参数校验
//        if(userName == null || userName.equals("") || password == null || password.equals("")){
//            return false;
//        }
//        if (StringUtils.hasLength(userName) && StringUtils.hasLength(password)) {
//            //校验账号密码是非正确
//            //当前还未学习数据库的操作,暂且采用 硬编码的方式
//            //假设账号:zhangsan, 密码:123456
//            if ("zhangsan".equals(userName) && "123456".equals(password)) {
//
//                return true;
//            }
//        }

        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return false;
        }
        //校验账号密码 假设账号 为 : zhangsan , 密码: 123456
        if ("zhangsan".equals(userName) && "123456".equals(password)) {
            //存储session
            session.setAttribute("userName", userName);
            return true;
        }
        return false;
    }

    @RequestMapping("/getUserInfo")
    public String getUserInfo(HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        System.out.println("登录用户:"+ userName);
        return userName == null ? "" : userName;
    }
}
