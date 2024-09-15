package com.user_auth_v1.interceptors;

import com.user_auth_v1.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AppInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("IN PRE-HANDLE INTERCEPTOR METHOD");

        if(request.getRequestURI().startsWith("/app")){
            // GET SESSION OBJECT:
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if(user == null){
                response.sendRedirect("/sign-in");
                return false;
            }// END OF CHECK FOR USER OBJECT IN SESSION IF BLOCK.

        }// END OF GET REQUEST URI IF BLOCK.

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("IN POST-HANDLE INTERCEPTOR METHOD");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("IN AFTER COMPLETION INTERCEPTOR METHOD");
    }
}// END OF APP INTERCEPTOR CLASS.
