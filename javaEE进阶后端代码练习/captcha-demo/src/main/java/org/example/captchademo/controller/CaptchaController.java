package org.example.captchademo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.captcha.LineCaptcha;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.captchademo.model.CaptchaProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/20 15:53
 */
@RequestMapping("/captcha")
@RestController
public class CaptchaController {
    @Autowired
    private CaptchaProperties captchaProperties;

    private static long VALID_TIME = 60 * 1000;

    @RequestMapping("/get")
    public void getCaptcha(HttpSession session, HttpServletResponse response) {
        ICaptcha captcha = CaptchaUtil.createLineCaptcha(captchaProperties.getWidth(), captchaProperties.getHeight());
        try {
            captcha.write(response.getOutputStream());
            //禁止缓存
            response.setHeader("Prama", "No-cache");
            //设置返回的格式
            response.setContentType("image/jpeg");
            //打印验证码
            System.out.println(captcha.getCode());
            //存储Session
            session.setAttribute(captchaProperties.getSession().getCode(), captcha.getCode());
            session.setAttribute(captchaProperties.getSession().getDate(), System.currentTimeMillis());
            //Servlet的OutputStream记得自行关闭哦！
            response.getOutputStream().close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @RequestMapping("/check")
    public Boolean check(String captchaCode, HttpSession session) {

        System.out.println("接收captchaCode:" + captchaCode);
        //参数校验
        //判断用户输入的验证码是否和session中存储的一致
        //是否在有效期内
        if (!StringUtils.hasLength(captchaCode)) {
            return false;
        }
        String sessionCode = (String) session.getAttribute(captchaProperties.getSession().getCode());
        Long sessionDate = (Long) session.getAttribute(captchaProperties.getSession().getDate());
        if (captchaCode.equalsIgnoreCase(sessionCode)
                && sessionDate != null
                && (System.currentTimeMillis() - sessionDate) < VALID_TIME) {
            return true;
        }
        return false;

    }
}