package com.example.demomybatis.domain.dto;

import com.example.demomybatis.domain.entity.UserAccount;
import lombok.Data;

/**
 * @author wanlei
 * @since 2022/11/29
 */
@Data
public class UserAccountDto extends UserAccount {
    private String userName;
}
