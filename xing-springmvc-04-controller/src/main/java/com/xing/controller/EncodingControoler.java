package com.xing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EncodingControoler {
    /**
     *
     * @PostMappeing 只接收post请求
     * @RequestParam("username") 传过来的参数名必须是 username
     * return "test" 会在视图解析器拼接 /WEB-INF/jsp/test.jsp
     */
    @PostMapping("/select")
    public String test1(@RequestParam("username") String name, Model model){
        model.addAttribute("msg",name);
        return "test";
    }
}
