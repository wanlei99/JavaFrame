package com.example.demomybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demomybatis.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wanlei
 * @since 2022/11/29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
