package com.xing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @RequestMapping("/addSession")
    public void addSession(HttpServletRequest request){
        request.getSession().setAttribute("username","admin");
    }

    @RequestMapping("/login/{username}")
    public String login(@PathVariable String username , HttpServletRequest request){
        request.getSession().setAttribute("username",username);
        return "hello";
    }
}
