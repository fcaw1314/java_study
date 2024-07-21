package org.example.configdemo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.captcha.LineCaptcha;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CaptchaController {
    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpServletResponse response){
        //定义图形验证码的长和宽
//        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
//        lineCaptcha.write("d:/line.png");
//        //输出code
//        System.out.println(lineCaptcha.getCode());


        ICaptcha captcha = CaptchaUtil.createLineCaptcha(200, 100);
        try {
            captcha.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
