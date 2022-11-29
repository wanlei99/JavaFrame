package com.example.demomybatis.domain.dto;

import com.example.demomybatis.domain.entity.User;
import lombok.Data;

/**
 * @author wanlei
 * @since 2022/11/29
 */
@Data
public class UserDto extends User {
    String account;
}
