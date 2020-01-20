package com.john.alltasks.datasource.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:数据源Sql执行实体类
 */
@Data
@ApiModel("数据源Sql执行实体类")
public class DataSourceExecuteVO implements Serializable {

    @ApiModelProperty(value = "数据源类型分组")
    @NotBlank(message = "数据源类型分组不可为空")
    private String typeGroup;

    @ApiModelProperty(value = "数据源类型名称")
    @NotBlank(message = "数据源类型名称不可为空")
    private String typeName;

    @ApiModelProperty(value = "数据源URL")
    @NotNull(message = "数据源URL不可为空")
    private String url;

    @ApiModelProperty(value = "数据源用户名")
    private String username;

    @ApiModelProperty(value = "数据源密码")
    private String password;

    @ApiModelProperty(value = "sql语句")
    @NotNull(message = "sql语句不可为空")
    private String sql;
}
