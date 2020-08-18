package com.xing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hi")
    public String hi(Model model) {
        model.addAttribute("msg", "hi,spring-mvc");
//        返回视图，自动解析==> /WEB-INF/jsp/hello.jsp
        return "hello";
    }
}
