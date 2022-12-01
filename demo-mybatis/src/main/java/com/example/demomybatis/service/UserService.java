package com.example.demomybatis.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomybatis.domain.entity.User;

/**
 * @author wanlei
 * @since 2022/11/29
 */
public interface UserService extends IService<User> {
    /**
     * 分页查询
     * @param pageParam
     * @param sortString
     * @return
     */
    IPage<User> page(JSONObject pageParam, JSONObject sortString);
}
