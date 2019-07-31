package com.example.healthbackend.Dao;

import com.example.healthbackend.Entity.Doctor;
import com.example.healthbackend.Entity.DoctorExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;


@Mapper
@Component
@EnableAsync
public interface DoctorMapper {

    int countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    @Async
    @Insert("insert into doctor(username,name) " +
            "values(#{record.username},#{record.name})")
    int insert(@Param("record") Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorExample example);

    @Async
    @Select("select name,hospital,description " +
            "from doctor " +
            "where department=#{department}")
    List<Doctor> selectByDept(@Param("department") String department);

    @Async
    @Update("update doctor " +
            "set location=#{doctor.location}, hospital=#{doctor.hospital}, department=#{doctor.department}, " +
            "description=#{doctor.description}, edu_background=#{doctor.edu_background}, award=#{doctor.award} " +
            "where username=#{doctor.username}")
    void updateMyDocument(@Param("doctor") Doctor doctor);

    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);
}