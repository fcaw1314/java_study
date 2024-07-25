package org.example.springmvc.coontroller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/12 9:27
 */

@RestController
@RequestMapping("/Request")
public class RequestController {
    @RequestMapping("/getCookie")
    public String getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        System.out.println("获取cookie信息:");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            }
        }
        return "获取cookie成功";
    }

    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request) {
        //参数为true  如果session不存在
        HttpSession session = request.getSession(true);
        session.setAttribute("name","zhangsan");
        session.setAttribute("studentID","100256");
        return "设置session成功";
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request) {
        //参数为true  如果session不存在
        HttpSession session = request.getSession(false);
        if(session!=null){
            System.out.println(session.getAttribute("name"));
            System.out.println(session.getAttribute("studentID"));
        }
        return "获取session成功";
    }
}
