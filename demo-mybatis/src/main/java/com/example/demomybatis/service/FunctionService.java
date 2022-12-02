package com.example.demomybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomybatis.domain.dto.FunctionTreeGroup;
import com.example.demomybatis.domain.entity.Function;

import java.util.List;

/**
 * @author wanlei
 * @since 2022/12/2
 */
public interface FunctionService extends IService<Function> {
    public List getFunctionTreeByProjectId(Long projectId,Long parentId);

    List<FunctionTreeGroup> buildFunctionTree(Long Id,Long parentId);
}
