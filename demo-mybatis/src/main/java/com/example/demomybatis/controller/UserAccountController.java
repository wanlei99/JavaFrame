package com.example.demomybatis.controller;

import com.example.demomybatis.service.UserAccountService;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wanlei
 * @since 2022/11/29
 */
@RestController
@RequestMapping("/account")
public class UserAccountController {

    @Resource
    private UserAccountService accountService;

    @PostMapping(value = "/login")
    public String login(@RequestParam("account") String account, @RequestParam("password") String password) {
        boolean loginResult = accountService.loginValid(account, password);
        if (loginResult) {
            return "登陆成功！";
        }
        return "登录失败！";
    }
    @GetMapping(value = "/test")
    public String test(Model model) {

        return null;
    }

}
