package com.train.dao;

import com.train.entity.User;

import java.util.List;

/**
 * Created by ${符柱成} on 2017/3/31.
 */
public interface UserDao {
    /**
     * 添加用户
     */
    Integer insertUser(User userInfo);

    List<User> selectUserList();
}