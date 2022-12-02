package com.example.demomybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demomybatis.domain.entity.Function;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wanlei
 * @since 2022/12/2
 */
@Mapper
public interface FunctionMapper extends BaseMapper<Function> {
}
