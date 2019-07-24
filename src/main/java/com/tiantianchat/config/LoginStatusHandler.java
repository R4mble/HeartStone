package com.tiantianchat.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wangyl
 * @date 2019/7/22
 */
public class LoginStatusHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}
