package com.example.demomybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomybatis.domain.entity.UserRole;

/**
 * @author wanlei
 * @since 2022/12/1
 */
public interface UserRoleService extends IService<UserRole> {
    /**
     * 根据角色id获取角色名称以及父级角色名称
     * @param roleId
     * @return
     */
    UserRole selectUserRoleName(Long roleId);
}
