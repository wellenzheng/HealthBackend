package com.example.healthbackend.Controller;


import com.example.healthbackend.Entity.Doctor;
import com.example.healthbackend.Service.DoctorService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private DoctorService doctorService;


    @RequestMapping(value = "/user/doctorList",method = RequestMethod.GET)
    @ResponseBody
    public List<Doctor> selectByDept(@Param("department") String department){
        return doctorService.selectByDept(department);
    }
}
