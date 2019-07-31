package com.example.healthbackend.Service;


import com.example.healthbackend.Dao.PatientMapper;
import com.example.healthbackend.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class PatientService{

    @Autowired
    private PatientMapper patientMapper;

    public void insert(Patient patient){
        patientMapper.insert(patient);
    }

    public void updateMyDocument(String username, String name, String sex, String birthday){
        patientMapper.updateMyDocument(username,name,sex,birthday);
    }
}
