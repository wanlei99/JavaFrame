package com.example.demomybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomybatis.domain.entity.UserAccount;

/**
 * @author wanlei
 * @since 2022/11/29
 */
public interface UserAccountService extends IService<UserAccount> {
    /**
     * 验证用户登录
     * @param account
     * @param password
     * @return
     */
    Boolean loginValid(String account, String password);

    /**
     * 添加账号
     * @param userAccount
     * @return
     */
    UserAccount selectByAccount(UserAccount userAccount);
}
