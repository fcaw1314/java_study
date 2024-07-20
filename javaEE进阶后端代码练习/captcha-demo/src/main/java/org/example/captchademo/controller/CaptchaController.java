package org.example.captchademo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.captcha.LineCaptcha;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.captchademo.model.CaptchaProperties;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/getCaptcha")
    public void getCode(HttpSession session, HttpServletResponse response) {
        //定义图形验证码的⻓和宽
        LineCaptcha lineCaptcha =
                CaptchaUtil.createLineCaptcha(captchaProperties.getWidth(),
                        captchaProperties.getHeight());
        response.setContentType("image/jpeg");
        //禁⽌使⽤缓存
        response.setHeader("Pragma", "No-cache");
        try {
            // 输出到⻚⾯
            lineCaptcha.write(response.getOutputStream());
            //存储在Session中
            session.setAttribute(captchaProperties.getSession().getKey(),
                    lineCaptcha.getCode());
            session.setAttribute(captchaProperties.getSession().getDate(), new
                    Date());
            // 打印⽇志
            System.out.println("⽣成的验证码:" + lineCaptcha.getCode());
            // 关闭流
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
