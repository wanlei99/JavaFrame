package com.example.demomybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demomybatis.domain.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wanlei
 * @since 2022/12/1
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
}
