package com.example.demomybatis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author wanlei
 * @since 2022/12/1
 */
@Data
@TableName("user_role")
@EntityScan
public class UserRole {
    @TableId(value = "role_id", type = IdType.AUTO)
    /**
     * 角色Id
     */
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 父id
     */
    private Long parentId;
}
