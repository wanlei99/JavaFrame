package com.ssm.blog.mapper;

import com.ssm.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wanlei
 * @since 2022/11/18
 */
@Mapper
public interface UserMapper {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> queryUserList();
}
