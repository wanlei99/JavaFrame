package com.blog.dao;

import com.blog.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wanlei
 * @since 2022/11/18
 */
@Repository
public interface UserDao {
    @Select("Select * from user")
    public List<User> findUserAll();
}
