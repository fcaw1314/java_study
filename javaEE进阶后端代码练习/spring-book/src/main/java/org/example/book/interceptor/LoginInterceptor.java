package org.example.book.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yxb
 * @version 1.0
 * @description:登录拦截器
 * @date 2024/7/29 15:11
 */

public class LoginInterceptor implements HandlerInterceptor {


    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * @description true ---- 放行
     * spring-book       
     * @date 2024/7/29 15:17:15
     */
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("目标方法前执行的代码");
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
