package com.example.healthbackend.Controller;


import com.example.healthbackend.Config.LoginHandler;
import com.example.healthbackend.Entity.User;
import com.example.healthbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Collection;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/user/home",method = RequestMethod.GET)
    public String userLogin(){
        return "user/home";
    }

    @RequestMapping(value = "/doctor/home",method = RequestMethod.GET)
    public String doctorLogin(){
        return "doctor/home";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerPage(){
        return "register";
    }

}
