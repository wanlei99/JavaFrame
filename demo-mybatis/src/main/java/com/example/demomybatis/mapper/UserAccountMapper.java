package com.example.demomybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demomybatis.domain.dto.UserAccountDto;
import com.example.demomybatis.domain.entity.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wanlei
 * @since 2022/11/29
 */
@Mapper
public interface UserAccountMapper extends BaseMapper<UserAccount> {
    /**
     * 根据用户Id查询用户账号信息
     * @param userId
     * @return
     */
    @Select("SELECT account.*,user.`name` as userName FROM `user_account` as account\n" +
            "LEFT JOIN `user` as user ON user.id = account.user_id where user.id=${userId}")
    List<UserAccountDto> selectAccountByUserId(String userId);
}
