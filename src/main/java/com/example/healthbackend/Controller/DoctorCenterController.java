package com.example.healthbackend.Controller;


import com.example.healthbackend.Entity.Doctor;
import com.example.healthbackend.Entity.User;
import com.example.healthbackend.Service.DoctorService;
import com.example.healthbackend.Service.UserService;
import com.example.healthbackend.Utils.InfoHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.*;
import java.security.Principal;

@Controller
public class DoctorCenterController {

    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/doctor/myCenter",method = RequestMethod.GET)
    public String gotoMyCenter(@AuthenticationPrincipal Principal principal, Model model){
        User user=(User)userService.loadUserByUsername(principal.getName());
        model.addAttribute("username",user.getUsername());
        model.addAttribute("name",user.getName());
        model.addAttribute("role",user.getRole());
        model.addAttribute("phone",user.getPhone());
        return "doctor/myCenter";
    }

    @RequestMapping(value = "/doctor/myDocument",method = RequestMethod.GET)
    public String gotoMyDocument(){
        return "doctor/myDocument";
    }

    @RequestMapping(value = "/doctor/myDocument",method = RequestMethod.POST)
    public String saveMyDocument(@AuthenticationPrincipal Principal principal,
                                 @Param("name") String name,
                                 @Param("location") String location,
                                 @Param("hospital") String hospital,
                                 @Param("department") String department,
                                 @Param("description") String description,
                                 @Param("edu_background") String edu_background,
                                 @Param("award") String award) {
        Doctor doctor=new Doctor();
        doctor.setUsername(principal.getName());
        doctor.setName(name);
        doctor.setLocation(location);
        doctor.setHospital(hospital);
        doctor.setDepartment(department);
        doctor.setDescription(description);
        doctor.setEdu_background(edu_background);
        doctor.setAward(award);
        doctorService.updateMyDocument(doctor);
        return "doctor/myDocument";
    }


}
