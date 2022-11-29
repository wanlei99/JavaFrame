package com.example.demomybatis.controller;

import com.example.demomybatis.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wanlei
 * @since 2022/11/29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    public String userLogin(@PathVariable String account, @PathVariable String password, Model model) {

        return null;
    }
}
