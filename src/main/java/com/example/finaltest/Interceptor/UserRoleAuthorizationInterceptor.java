package com.example.finaltest.Interceptor;

import com.example.finaltest.utils.Jwt;
import org.apache.ibatis.plugin.Intercepts;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRoleAuthorizationInterceptor extends HandlerInterceptorAdapter {
    // 字符串数组，用来存放用户角色信息
    private String authorizedRoles;
    public final void setAuthorizedRoles(String authorizedRoles){
        this.authorizedRoles = authorizedRoles;
    }
    public final boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException, IOException{
        try {


        System.out.println(request.getHeader("Authorization"));
        setAuthorizedRoles(request.getHeader("Authorization").substring(7));
        if (this.authorizedRoles != null) {
            if(Jwt.verify(this.authorizedRoles)){
                return true;
            }else{
                handleNotAuthorized(request, response, handler);
                return false;
            }
        }
        handleNotAuthorized(request, response, handler);
        System.out.println("ddd");
        return false;}catch (Exception e){
            handleNotAuthorized(request, response, handler);
            System.out.println("ddd");
            return false;
        }
    }
    protected void handleNotAuthorized(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException, IOException{
        // 403表示资源不可用。服务器理解用户的请求，但是拒绝处理它，通常是由于权限的问题
        response.setStatus(401);
//        response.sendRedirect("/admin");
    }
}
