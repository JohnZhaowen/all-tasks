package com.john.alltasks.warning.models;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:告警配置持久化层实体类
 */
@Data
@ApiModel("告警配置持久化层实体类")
public class WarningPO implements Serializable {

    private Long id;

    private String name;

    private Integer level;

    private String warningMethod;

    private String warningImpact;

    private String tenant;

    private String operator;

    private int status;

    private int defaultFlag;

    private String owner;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
