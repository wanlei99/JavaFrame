package com.example.demomybatis.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author wanlei
 * @since 2022/12/2
 */
@Data
@EntityScan
@TableName(value = "`function`")
public class Function{
    @TableId(value = "id", type = IdType.AUTO)
    private Long functionId;
    @TableField(value = "`function`")
    private String functionName;
    private Long parentId;
    @TableLogic
    private String isDelete;
    private Long projectId;
    private Integer level;
}
