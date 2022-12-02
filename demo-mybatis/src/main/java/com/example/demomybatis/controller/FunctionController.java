package com.example.demomybatis.controller;

import com.example.demomybatis.service.FunctionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wanlei
 * @since 2022/12/2
 */
@RestController
@RequestMapping("/function")
public class FunctionController {
    @Autowired
    private FunctionService functionService;

    @PostMapping("/tree")
    public List buildTree(@Param("projectId") Long projectId) {
        return functionService.getFunctionTreeByProjectId(projectId);
    }
    @PostMapping("/treeById")
    public List buildTreeById(@Param("projectId") Long projectId) {
        return functionService.buildFunctionTree(projectId);
    }
}
