package com.example.demomybatis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author wanlei
 * @since 2022/11/29
 */
@Data
@EntityScan
@TableName("user_account")
public class UserAccount {
    /**
     * 账号标识
     */
    @TableId(value = "account_id", type = IdType.AUTO)
    private String accountId;
    /**
     * 登录账号
     */
    private String account;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 关联用户
     */
    private Long userId;

    /**
     * 逻辑删除标志
     */
    @TableLogic
    private Integer isDelete;
}
