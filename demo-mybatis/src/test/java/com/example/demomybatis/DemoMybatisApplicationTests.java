package com.example.demomybatis;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demomybatis.domain.dto.UserAccountDto;
import com.example.demomybatis.domain.entity.User;
import com.example.demomybatis.domain.entity.UserAccount;
import com.example.demomybatis.mapper.UserAccountMapper;
import com.example.demomybatis.mapper.UserMapper;
import com.example.demomybatis.service.UserAccountService;
import com.example.demomybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DemoMybatisApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserAccountMapper accountMapper;
    @Resource
    UserAccountService userAccountService;
    @Resource
    UserService userService;

    @Test
    void contextLoads() {
    }
    @Test
    void testMapper() {
        QueryWrapper deleteWrapper = new QueryWrapper();
        deleteWrapper.eq("id", 1);
        userService.remove(deleteWrapper);
    }
    @Test
    void testService() {
        User user = new User();
        user.setAge(30);
        user.setName("张三");
        user.setEmail("xxxx@qq.com");
        Integer result = userMapper.insert(user);
        System.out.println(result);
    }
    @Test
    void testAddAccount() {
        UserAccount account = new UserAccount();
        account.setAccount("admin1");
        account.setUserId(Long.valueOf(1));
        account.setPassword("22222");
        Boolean result = false;
        if (userAccountService.selectByAccount(account) != null) {
            System.out.println("用户已存在，执行修改！");
            UpdateWrapper<UserAccount> updateWrapper = new UpdateWrapper<>();
            updateWrapper.set("account", account.getAccount())
                    .set("password", account.getPassword())
                    .set("user_id", account.getUserId());
            result = userAccountService.update(updateWrapper);
        } else {
            result = accountMapper.insert(account)==1 ? true : false;
        }
        System.out.println(result);
    }

    @Test
    void delete() {
        QueryWrapper<UserAccount> accountQueryWrapper = new QueryWrapper<>();
        accountQueryWrapper.eq("account", "admin1");
        userAccountService.remove(accountQueryWrapper);
    }
    @Test
    void testSelect() {
        List<UserAccountDto> userList = accountMapper.selectAccountByUserId("1");
        for (UserAccountDto user : userList) {
            System.out.println(user.toString());
        }
    }
}
