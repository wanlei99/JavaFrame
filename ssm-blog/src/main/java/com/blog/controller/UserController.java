package com.blog.controller;

import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author wanlei
 * @since 2022/11/18
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录页面跳转
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        System.out.println("视图");
        return "login";
    }
    @PostMapping("/index")
    public String ValidUserLogin(Model model, HttpSession session) {

        return null;
    }
}
