package com.example.healthbackend.Dao;

import com.example.healthbackend.Entity.User;
import com.example.healthbackend.Entity.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Mapper
@Component
@EnableAsync
public interface UserMapper {

    @Async
    @Select("select * from user where username=#{username}")
    User selectByUsername(@Param("username") String username);

    int countByExample(UserExample example);

    @Async
    @Delete("delete from user where username=#{username}")
    int deleteByExample(User example);

    @Async
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user(id,username,password,name,phone,role) values(#{id},#{username},#{password},#{name},#{phone},#{role})")
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @Async
    @Update("update user" +
            "set name=#{record.name}, password=#{record.password}, phone=#{record.phone}" +
            "where username=#{username}")
    void update(@Param("record") User record, @Param("username") String username);

    @Async
    @Update("update user " +
            "set password=#{newPassword} " +
            "where username=#{username}")
    void changePassword(@Param("username") String username, @Param("newPassword") String newPassword);

    @Async
    @Update("update user set name=#{name} where username=#{username}")
    void changeName(@Param("username") String username, @Param("name") String name);



    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}