package com.example.healthbackend.Utils;


import com.example.healthbackend.Entity.User;
import com.example.healthbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.security.Principal;

public class InfoHelper {

    @Autowired
    private UserService userService;


    public void showInfo(@AuthenticationPrincipal Principal principal, Model model){
        User user=(User)userService.loadUserByUsername(principal.getName());
        model.addAttribute("username",user.getUsername());
        model.addAttribute("name",user.getName());
        model.addAttribute("role",user.getRole());
        model.addAttribute("phone",user.getPhone());
    }
}
