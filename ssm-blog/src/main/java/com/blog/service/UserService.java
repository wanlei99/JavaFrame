package com.blog.service;

import com.blog.domain.User;

/**
 * @author wanlei
 * @since 2022/11/18
 */
public interface UserService {
    void test();
    User userLogin(String userName, String password);
}
