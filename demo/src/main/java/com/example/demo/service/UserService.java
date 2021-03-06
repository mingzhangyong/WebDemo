package com.example.demo.service;


import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    public List<User> findByName(String name) {
        return userMapper.findUserByName(name);
    }
    public User insertUser(User user) {
        System.out.println(" \n  user" + user.getName()  + "\n \n \n");
        userMapper.insertUser(user);
        return user;
    }
    public List<User> ListUser(){
        return userMapper.ListUser();
    }
    public int Update(User user){
        return userMapper.Update(user);
    }

    public int delete(int id){
        return userMapper.delete(id);
    }
}
