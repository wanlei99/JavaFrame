package com.fuzhu.dao;

import com.fuzhu.entity.User;

/**
 * Created by ${符柱成} on 2017/3/31.
 */
public interface UserDao {
    /**
     * 添加用户
     */
    Integer insertUser(User userInfo);
}
