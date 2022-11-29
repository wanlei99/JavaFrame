package com.blog.service.impl;

import com.blog.dao.UserDao;
import com.blog.domain.User;
import com.blog.service.UserService;
import com.mysql.jdbc.StringUtils;
import com.sun.deploy.nativesandbox.comm.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wanlei
 * @since 2022/11/18
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void test() {
        System.out.println("test");
    }

    @Override
    public User userLogin(String userName, String password) {
        if (StringUtils.isNullOrEmpty(userName) || StringUtils.isNullOrEmpty(password)) {

        }
        User loginResult = userDao.userLogin(userName, password);
        return null;
    }
}
