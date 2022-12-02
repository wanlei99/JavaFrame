package com.example.demomybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demomybatis.domain.dto.UserAccountDto;
import com.example.demomybatis.domain.entity.Function;
import com.example.demomybatis.domain.entity.User;
import com.example.demomybatis.domain.entity.UserAccount;
import com.example.demomybatis.domain.entity.UserRole;
import com.example.demomybatis.mapper.UserAccountMapper;
import com.example.demomybatis.mapper.UserMapper;
import com.example.demomybatis.service.FunctionService;
import com.example.demomybatis.service.UserAccountService;
import com.example.demomybatis.service.UserRoleService;
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
    @Resource
    UserRoleService userRoleService;
    @Resource
    FunctionService functionService;
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
    @Test
    void lambda() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>().eq(User::getId,"1");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user.toString());
    }
    @Test
    void page() {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();

        Page<User> userPage = new Page<>(1,2);
        IPage<User> userIPage = userMapper.selectPage(userPage, queryWrapper);
        System.out.println("总页数："+userIPage.getPages());
        System.out.println("总记录数："+userIPage.getTotal());
        userIPage.getRecords().forEach(System.out::println);
    }
    @Test
    void selectRoleName() {
        UserRole userRole = userRoleService.selectUserRoleName(Long.valueOf(7));
        System.out.println(userRole.toString());
    }
    @Test
    void select() {
        QueryWrapper<Function> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", Long.valueOf(1001))
                .isNull("parent_id");
        List<Function> functionList = functionService.list(queryWrapper);
        System.out.println(functionList);
    }
    @Test
    void buildTree() {
        List treeList = functionService.getFunctionTreeByProjectId(Long.valueOf(1001));
        System.out.println(treeList);
    }
}
