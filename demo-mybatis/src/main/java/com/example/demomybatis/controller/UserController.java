package com.example.demomybatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demomybatis.domain.entity.User;
import com.example.demomybatis.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(value = "/page")
    public IPage<User> page() {
        JSONObject sortString = new JSONObject();
        JSONObject pageParam = new JSONObject();
        pageParam.put("size",2);
        pageParam.put("current", 1);
//        sortString.put("userName", "");
        IPage<User> result = userService.page(pageParam,sortString);
        return result;
    }
}
