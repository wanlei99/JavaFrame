package com.example.demomybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomybatis.domain.entity.User;
import com.example.demomybatis.mapper.UserMapper;
import com.example.demomybatis.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户服务类
 * @author wanlei
 * @since 2022/11/29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
