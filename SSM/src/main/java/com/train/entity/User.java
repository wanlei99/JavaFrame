package com.train.entity;

import lombok.Data;

/**
 * Created by ${符柱成} on 2017/3/31.
 */
@Data
public class User {
    /**
     * 用户Id
     */
    private Integer userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户性别
     */
    private String userGender;
    /**
     * 登录账号
     */
    private String userLoginId;
    /**
     * 登录密码
     */
    private String userLoginPassword;
}
