package com.blog.service.impl;

import com.blog.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wanlei
 * @since 2022/11/18
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Override
    public void test() {
        System.out.println("test");
    }
}
