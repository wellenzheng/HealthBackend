package com.example.healthbackend.Service;

import com.example.healthbackend.Dao.UserMapper;
import com.example.healthbackend.Entity.User;
import com.example.healthbackend.Entity.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userMapper.selectByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("user not found");
        return user;
    }

    public boolean register(User user){
        User userEntity=userMapper.selectByUsername(user.getUsername());
        if(userEntity==null) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userMapper.insert(user);
            return true;
        }
        return false;
    }

    public boolean delete(User user){
        User userEntity=userMapper.selectByUsername(user.getUsername());
        if(userEntity!=null){
            userMapper.deleteByExample(user);
            return true;
        }
        return false;
    }

    public void updateByExample(User record, UserExample example){
        userMapper.updateByExample(record,example);
    }

    public void updateByExampleSelective(User record, UserExample example){
        userMapper.updateByExampleSelective(record,example);
    }

    public void update(User record, String username){
        userMapper.update(record,username);
    }

    public void changePassword(String username, String newPassword){
        userMapper.changePassword(username,newPassword);
    }

    public void changeName(String username, String name){
        userMapper.changeName(username,name);
    }

}
