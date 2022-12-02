package com.example.demomybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomybatis.domain.dto.FunctionTreeGroup;
import com.example.demomybatis.domain.entity.Function;
import com.example.demomybatis.mapper.FunctionMapper;
import com.example.demomybatis.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanlei
 * @since 2022/12/2
 */
@Service
public class FunctionServiceImpl extends ServiceImpl<FunctionMapper, Function> implements FunctionService {

    @Autowired
    private FunctionMapper functionMapper;


    /**
     * 根据项目id构建树结构
     * @param projectId
     * @return
     */
    @Override
    public List getFunctionTreeByProjectId(Long projectId,Long parentId) {
        // 构建查询条件
        QueryWrapper<Function> queryWrapper = new QueryWrapper<Function>().eq("project_id", projectId);
        if (parentId == null) {
            queryWrapper.isNull("parent_id");
        } else {
            queryWrapper.eq("parent_id", parentId);
        }
        List<Function> functionList = functionMapper.selectList(queryWrapper);
        List<FunctionTreeGroup> resultList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(functionList)) {
            functionList.forEach(function -> {
                FunctionTreeGroup treeGroup = new FunctionTreeGroup(function);
                resultList.add(treeGroup);
                List<FunctionTreeGroup> list = buildFunctionTree(function.getFunctionId(),projectId);
                if (CollectionUtils.isEmpty(list)) {
                    treeGroup.setHasChildNode(false);
                } else {
                    treeGroup.setHasChildNode(true);
                }
                treeGroup.setChildrenNode(list);
            });
        }
        return resultList;
    }

    /**
     * 根据parentId 查询子节点数并构建节点树
     * @param parentId
     * @return
     */
    @Override
    public List<FunctionTreeGroup> buildFunctionTree(Long parentId,Long projectId) {
        // 构建查询条件
        QueryWrapper<Function> queryWrapper = new QueryWrapper<>();
        List<FunctionTreeGroup> functionTreeGroups = new ArrayList<>();
        // 根据parentId查询数据信息
        if (parentId == null) {
            queryWrapper.isNull("parent_id");
        } else {
            queryWrapper.eq("parent_id", parentId);
        }
        queryWrapper.eq("project_id", projectId);
        List<Function> functionList = functionMapper.selectList(queryWrapper);
        if (!CollectionUtils.isEmpty(functionList)) {
            functionList.forEach(function -> {
                FunctionTreeGroup treeGroup = new FunctionTreeGroup(function);
                functionTreeGroups.add(treeGroup);
                List<FunctionTreeGroup> childrenTreeList = buildFunctionTree(treeGroup.getFunctionId(),projectId);
                if (CollectionUtils.isEmpty(childrenTreeList)) {
                    treeGroup.setHasChildNode(false);
                } else {
                    treeGroup.setHasChildNode(true);
                }
                treeGroup.setChildrenNode(childrenTreeList);
            });
        }
        return functionTreeGroups;
    }

}
