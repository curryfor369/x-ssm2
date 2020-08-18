package com.xing.controller;

import com.xing.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @RequestMapping("/getUserList")
    public List<User> getUserList(){
        System.out.println("ji纳入了");
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"a",11));
        users.add(new User(2,"b",22));
        users.add(new User(3,"c",33));
        return users;
    }
}
