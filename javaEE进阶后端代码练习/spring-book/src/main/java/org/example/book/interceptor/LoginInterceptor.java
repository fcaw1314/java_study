package org.example.book.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.book.Model.Result;
import org.example.book.Model.UserInfo;
import org.example.book.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yxb
 * @version 1.0
 * @description:登录拦截器
 * @date 2024/7/29 15:11
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * @description true ---- 放行
     * spring-book
     * @date 2024/7/29 15:17:15
     */

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("校验用户是否登录");
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.USER_SESSION_KEY);
        if (userInfo == null) {
            log.info("用户未登录");
            //用户未登录
            response.setStatus(401);
            response.setContentType("application/json;charset=utf-8");
            Result result = Result.fail("用户未登录");
            response.getOutputStream().write(objectMapper.writeValueAsString(result).getBytes());
            return false;
        }
        log.info("用户登录校验通过");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("目标方法后执行的代码");
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        log.info("试图渲染完成后执行的代码");
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
}
