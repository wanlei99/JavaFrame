package com.train.service.impl;

import com.train.dao.UserDao;
import com.train.entity.User;
import com.train.service.UserService;

/**
 * @author wanlei
 * @since 2022/11/18
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Integer insertUser(User user) {
        Integer insertResult = userDao.insertUser(user);
        return insertResult;
    }
}
