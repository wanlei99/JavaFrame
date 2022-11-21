package com.ssm.blog.service.impl;

import com.ssm.blog.BaseTest;
import com.ssm.blog.entity.User;
import com.ssm.blog.mapper.UserMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImplTest extends BaseTest {

    @Autowired
    UserMapper userService;
    @Test
    public void testQueryUserList() {
        List<User> userList = userService.queryUserList();
        if (userList.size() > 0) {
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }
}