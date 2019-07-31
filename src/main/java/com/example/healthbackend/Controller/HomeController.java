package com.example.healthbackend.Controller;


import com.example.healthbackend.Entity.User;
import com.example.healthbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/home")
    public String gotoUserHome(){
        return "user/home";
    }

    @RequestMapping("/doctor/home")
    public String gotoDoctorHome(){return "doctor/home";}

    @RequestMapping(value = "/user/searchByDept",method = RequestMethod.GET)
    public String gotoSearchByDept(){
        return "user/searchByDept";
    }
}
