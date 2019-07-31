package com.example.healthbackend.Dao;

import com.example.healthbackend.Entity.Patient;
import com.example.healthbackend.Entity.PatientExample;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;


@Mapper
@Component
@EnableAsync
public interface PatientMapper {
    int countByExample(PatientExample example);

    int deleteByExample(PatientExample example);

    int deleteByPrimaryKey(String username);

    @Insert("insert into patient(username,name) values(#{record.username},#{record.name})")
    int insert(@Param("record") Patient record);

    int insertSelective(Patient record);

    List<Patient> selectByExample(PatientExample example);

    Patient selectByPrimaryKey(String username);

    @Async
    @Update("update patient " +
            "set name=#{name}, sex=#{sex}, birthday=#{birthday} " +
            "where username=#{username}")
    void updateMyDocument(@Param("username") String username,
                          @Param("name") String name,
                          @Param("sex") String sex,
                          @Param("birthday") String birthday);

    int updateByExampleSelective(@Param("record") Patient record, @Param("example") PatientExample example);

    int updateByExample(@Param("record") Patient record, @Param("example") PatientExample example);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);
}