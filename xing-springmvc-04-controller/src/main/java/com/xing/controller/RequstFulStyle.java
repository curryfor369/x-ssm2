package com.xing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RequstFulStyle {

    @GetMapping("/aaa")
    public void a(HttpServletResponse response) throws IOException {
        response.sendRedirect("/jsp/xing.jsp");
    }

    @RequestMapping("/add/{username}/{password}")
    public String add(@PathVariable String username , @PathVariable String password, Model model){
        model.addAttribute("msg", "添加用户: " + username + "--" + password);
        return "test"; // WEB-INF/jsp/test.jsp
    }
}
