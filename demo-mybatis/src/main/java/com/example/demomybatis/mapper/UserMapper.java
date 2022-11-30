package com.example.demomybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demomybatis.domain.dto.UserDto;
import com.example.demomybatis.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Wrapper;
import java.util.List;

/**
 * @author wanlei
 * @since 2022/11/29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
//    IPage<User> selectPage(IPage<User> page, @Param("ew")Wrapper queryWrapper);
}
