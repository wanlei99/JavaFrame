package com.example.demomybatis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomybatis.domain.entity.User;
import com.example.demomybatis.mapper.UserMapper;
import com.example.demomybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 用户服务类
 * @author wanlei
 * @since 2022/11/29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 分页查询
     * @param pageParam 分页信息
     * @param sortString 数据查询条件
     * @return
     */
    public IPage<User> page(JSONObject pageParam, JSONObject sortString) {
        // 构建查询条件
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>();
        if (!sortString.isEmpty() && sortString != null) {
            String userName = sortString.getString("userName");
            if (userName != null) {
                queryWrapper.eq(User::getName, userName);
            }
        }
        Integer size = pageParam.getInteger("size");
        Integer current = pageParam.getInteger("current");
        if (size==null) {
            size = 1;
        }
        if (current == null) {
            current = 10;
        }
        // 构建分页数据
        Page<User> userPage = new Page<>(current,size);
        IPage<User> userIPage = userMapper.selectPage(userPage, queryWrapper);
        return userIPage;

    }

}
