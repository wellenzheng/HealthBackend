package com.example.healthbackend.Config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@Component
public class LoginHandler implements AuthenticationSuccessHandler {

    public static Map<String,String> authorityMap;

    public LoginHandler(){
        authorityMap=new HashMap<>();
        authorityMap.put("ROLE_USER","/user");
        authorityMap.put("ROLE_DOCTOR","/doctor");
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
        String path=httpServletRequest.getContextPath();
        String basePath=httpServletRequest.getScheme()+"://"+httpServletRequest.getServerName()
                +":"+httpServletRequest.getServerPort()+path;
        for (GrantedAuthority authority:authorities){
            httpServletResponse.sendRedirect(basePath+authorityMap.get(authority.getAuthority())+"/home");
        }
//        if(role.contains("ROLE_USER")){
//            httpServletResponse.sendRedirect(basePath+"/user/home");
//            return;
//        } else if(role.contains("ROLE_DOCTOR")){
//            httpServletResponse.sendRedirect(basePath+"/doctor/home");
//            return;
//        }
    }
}
