package com.example.demomybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomybatis.domain.entity.UserAccount;
import com.example.demomybatis.mapper.UserAccountMapper;
import com.example.demomybatis.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wanlei
 * @since 2022/11/29
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {
    @Autowired
    private UserAccountMapper accountMapper;
    @Override
    public Boolean loginValid(String account, String password) {
        // 构建查询条件
        QueryWrapper<UserAccount> loginWrapper = new QueryWrapper<>();
        // 拼接查询条件
        loginWrapper.eq("account", account)
                .eq("is_delete", 0);
        // 查询用户信息
        UserAccount userAccount = accountMapper.selectOne(loginWrapper);
        if (userAccount != null) {
            // 验证密码
            loginWrapper.eq("password",password);
            UserAccount user = accountMapper.selectOne(loginWrapper);
            if (user != null) {
                System.out.println("登录成功！");
                return true;
            } else {
                System.out.println("登录失败！");
                return false;
            }
        } else {
            System.out.println("暂无用户信息！");
            return false;
        }
    }

    /**
     * 根据用户登录账号查询数据信息
     * @param userAccount
     * @return
     */
    @Override
    public UserAccount selectByAccount(UserAccount userAccount) {
        // 构建查询条件
        QueryWrapper<UserAccount> addWrapper = new QueryWrapper<>();
        if (userAccount.getAccount() != null) {
            addWrapper.eq("account", userAccount.getAccount())
                    .eq("is_delete", 0);
            UserAccount account = accountMapper.selectOne(addWrapper);
            return account;
        } else {
            System.out.println("没有该用户信息！");
            return null;
        }
    }


}
