package com.example.demomybatis.domain.dto;

import com.example.demomybatis.domain.entity.Function;
import lombok.Data;

import java.util.List;

/**
 * function树实体类
 * @author wanlei
 * @since 2022/12/2
 */
@Data
public class FunctionTreeGroup{
    private Long functionId;
    private String functionName;
    private Integer level;
    private Long parentId;
    private Long projectId;
    private boolean hasChildNode;
    private List<FunctionTreeGroup> childrenNode;

    public FunctionTreeGroup(Function function) {
        this.functionId = function.getFunctionId();
        this.functionName = function.getFunctionName();
        this.level = function.getLevel();
        this.projectId = function.getProjectId();
        if (function.getParentId() != null) {
            this.parentId = function.getParentId();
        }
    }
}
