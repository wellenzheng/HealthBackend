package com.example.healthbackend.Service;


import com.example.healthbackend.Dao.DoctorMapper;
import com.example.healthbackend.Entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;

    public void insert(Doctor doctor){
        doctorMapper.insert(doctor);
    }

    public void updateMyDocument(Doctor doctor){
        doctorMapper.updateMyDocument(doctor);
    }

    public List<Doctor> selectByDept(String department){
        return doctorMapper.selectByDept(department);
    }
}
