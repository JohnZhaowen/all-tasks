package com.john.alltasks.datasource.models;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:数据源持久化层实体类
 */
@Data
@ApiModel("数据源持久化层实体类")
public class DataSourcePO implements Serializable {

    private Long id;

    private String name;

    private String level;

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
