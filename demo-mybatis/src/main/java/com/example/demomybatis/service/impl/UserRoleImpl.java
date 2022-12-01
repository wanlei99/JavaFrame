package com.example.demomybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomybatis.domain.entity.UserRole;
import com.example.demomybatis.mapper.UserRoleMapper;
import com.example.demomybatis.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wanlei
 * @since 2022/12/1
 */
@Service
public class UserRoleImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;


    /**
     * 根据角色id获取角色名称以及父级角色名称
     * @param roleId
     * @return
     */
    @Override
    public UserRole selectUserRoleName(Long roleId) {
        // 构建查询条件
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",roleId);
        // 根据id查询角色
        UserRole userRole = userRoleMapper.selectOne(queryWrapper);
        // 判断是否含有父角色
        if (userRole.getParentId() != null) {
            String roleName = getUserRoleNameByParentId(userRole.getParentId());
            userRole.setRoleName(roleName + "\\" + userRole.getRoleName());
        }
        return userRole;
    }

    /**
     * 根据父id获取角色的名称，并拼接在一起
     * @param parentId
     * @return
     */
    public String getUserRoleNameByParentId(Long parentId) {
        // 构建查询条件
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<UserRole>().eq(UserRole::getRoleId, parentId);
        // 查询
        UserRole userRole = userRoleMapper.selectOne(queryWrapper);
        String roleName = userRole.getRoleName();
        String roleNameParent = "";
        if (userRole.getParentId() != null) {
            roleNameParent = getUserRoleNameByParentId(userRole.getParentId()) + "\\" + roleName;
            return roleNameParent;
        } else {
            return roleName;
        }
    }
}
