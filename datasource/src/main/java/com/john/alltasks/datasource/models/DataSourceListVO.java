package com.john.alltasks.datasource.models;

import com.john.alltasks.datasource.enums.DataSourceTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:数据源配置列表展示实体类
 */
@Data
@ApiModel("数据源配置列表展示实体类")
public class DataSourceListVO implements Serializable {

    @ApiModelProperty(value = "数据源编号")
    private Long id;

    @ApiModelProperty(value = "数据源名称")
    private String name;

    @ApiModelProperty(value = "数据源类型分组")
    private String typeGroup;

    @ApiModelProperty(value = "数据源类型名称")
    private String typeName;

    @ApiModelProperty(value = "数据源url")
    private String url;

    @ApiModelProperty(value = "数据源用户名")
    private String username;

    @ApiModelProperty(value = "数据源密码")
    private String password;

    @ApiModelProperty(value = "租户")
    private String tenant;

    @ApiModelProperty(value = "所属人")
    private String owner;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime updateTime;

}