package com.example.demo.controller;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user", method = { RequestMethod.GET, RequestMethod.POST })
public class IndexController {

    @Autowired
    private UserService userservice;

    @RequestMapping("/ListUser")
    @ResponseBody
    public List<User> ListUser(){
        return userservice.ListUser();
    }

    @RequestMapping("/ListUserByname")
    @ResponseBody
    public List<User> ListUserByname(String name){
        return userservice.findByName(name);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = userservice.delete(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(User user) {
        int result = userservice.Update(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public User insert(@RequestBody User user) {
        System.out.println(" \n  user" + user.getName()  + "\n \n \n");
        return userservice.insertUser(user);
    }
}
