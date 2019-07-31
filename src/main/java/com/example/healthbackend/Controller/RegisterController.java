package com.example.healthbackend.Controller;


import com.example.healthbackend.Dao.DoctorMapper;
import com.example.healthbackend.Entity.Doctor;
import com.example.healthbackend.Entity.Patient;
import com.example.healthbackend.Entity.User;
import com.example.healthbackend.Service.DoctorService;
import com.example.healthbackend.Service.PatientService;
import com.example.healthbackend.Service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/register")
    public String register(@Param("user") User user){
        userService.register(user);
        if(user.getRole().equals("ROLE_USER")){
            Patient patient=new Patient();
            patient.setUsername(user.getUsername());
            patient.setName(user.getName());
            patientService.insert(patient);
        } else if(user.getRole().equals("ROLE_DOCTOR")){
            Doctor doctor=new Doctor();
            doctor.setUsername(user.getUsername());
            doctor.setName(user.getName());
            doctorService.insert(doctor);
        }
        return "register";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }
}
