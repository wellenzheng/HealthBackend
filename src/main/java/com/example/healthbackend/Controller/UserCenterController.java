package com.example.healthbackend.Controller;


import com.example.healthbackend.Config.LoginHandler;
import com.example.healthbackend.Entity.User;
import com.example.healthbackend.Service.DoctorService;
import com.example.healthbackend.Service.PatientService;
import com.example.healthbackend.Service.UserService;
import com.example.healthbackend.Utils.InfoHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class UserCenterController {

    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/user/myCenter",method = RequestMethod.GET)
    public String gotoMyCenter(@AuthenticationPrincipal Principal principal, Model model){
        User user=(User)userService.loadUserByUsername(principal.getName());
        model.addAttribute("username",user.getUsername());
        model.addAttribute("name",user.getName());
        model.addAttribute("role",user.getRole());
        model.addAttribute("phone",user.getPhone());
        return "user/myCenter";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    public String gotoChangePassword(){
        return "changePassword";
    }

    @RequestMapping(value = "/changePassword",method = RequestMethod.POST)
    public String changePassword(@AuthenticationPrincipal Principal principal,
                                 @Param("oldPassword") String oldPassword,
                                 @Param("newPassword") String newPassword){
        User user=(User)userService.loadUserByUsername(principal.getName());
        if(user.getPassword().equals(new BCryptPasswordEncoder().encode(oldPassword)))
            userService.changePassword(user.getUsername(),newPassword);
        return "changePassword";
    }

    @RequestMapping(value = "/changePhone",method = RequestMethod.GET)
    public String gotoChangePhone(){
        return "changePhone";
    }

    @RequestMapping(value = "/user/setting",method = RequestMethod.GET)
    public String gotoSetting(){
        return "user/setting";
    }

    @RequestMapping(value = "/user/myDocument",method = RequestMethod.GET)
    public String gotoMyDocument(){
        return "user/myDocument";
    }

    @RequestMapping(value = "/user/myDocument",method = RequestMethod.POST)
    public String saveMyDocument(@AuthenticationPrincipal Principal principal,
                                 @Param("name") String name,
                                 @Param("sex") String sex,
                                 @Param("birthday") String birthday){
        patientService.updateMyDocument(principal.getName(),name,sex,birthday);
        return "user/myDocument";
    }

}
