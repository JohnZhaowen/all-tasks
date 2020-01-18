package com.john.alltasks.datasource.models;

import com.john.alltasks.datasource.enums.DataSourceTypeEnum;
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

    private String typeGroup;

    private String typeName;

    private String url;

    private String username;

    private String password;

    private int status;

    private String tenant;

    private String owner;

    private String operator;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
