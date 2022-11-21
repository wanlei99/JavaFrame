package com.ssm.blog.service;

import com.ssm.blog.entity.User;

import java.util.List;

/**
 * @author wanlei
 * @since 2022/11/18
 */
public interface UserService {
    /**
     * 获取用户数据信息
     * @return
     */
    List<User> queryUserList();
}
