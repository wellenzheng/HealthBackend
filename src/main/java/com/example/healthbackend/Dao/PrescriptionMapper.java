package com.example.healthbackend.Dao;

import com.example.healthbackend.Entity.Prescription;
import com.example.healthbackend.Entity.PrescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrescriptionMapper {

    int countByExample(PrescriptionExample example);

    int deleteByExample(PrescriptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Prescription record);

    int insertSelective(Prescription record);

    List<Prescription> selectByExampleWithBLOBs(PrescriptionExample example);

    List<Prescription> selectByExample(PrescriptionExample example);

    Prescription selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByExampleWithBLOBs(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByExample(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByPrimaryKeySelective(Prescription record);

    int updateByPrimaryKeyWithBLOBs(Prescription record);

    int updateByPrimaryKey(Prescription record);
}