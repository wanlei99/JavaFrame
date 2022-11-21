package com.ssm.blog.service.impl;

import com.ssm.blog.entity.User;
import com.ssm.blog.mapper.UserMapper;
import com.ssm.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wanlei
 * @since 2022/11/18
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public List<User> queryUserList() {
        return userDao.queryUserList();
    }
}
