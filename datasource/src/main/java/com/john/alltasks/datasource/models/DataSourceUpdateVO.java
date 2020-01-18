package com.john.alltasks.datasource.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:数据源配置更新实体类
 */
@Data
@ApiModel("数据源配置更新实体类")
public class DataSourceUpdateVO implements Serializable {

    @ApiModelProperty(value = "数据源编号")
    @NotNull(message = "数据源编号不可为空")
    private Long id;

    @ApiModelProperty(value = "数据源名称")
    @NotBlank(message = "数据源名称不可为空")
    private String name;

    @ApiModelProperty(value = "数据源URL")
    @NotNull(message = "数据源URL")
    private String url;

    @ApiModelProperty(value = "数据源用户名")
    private String username;

    @ApiModelProperty(value = "数据源密码")
    private String password;

}
