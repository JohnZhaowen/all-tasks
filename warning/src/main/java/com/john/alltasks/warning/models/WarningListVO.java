package com.john.alltasks.warning.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:告警配置列表展示实体类
 */
@Data
@ApiModel("告警配置列表展示实体类")
public class WarningListVO implements Serializable {

    @ApiModelProperty(value = "告警编号")
    private Long id;

    @ApiModelProperty(value = "告警名称")
    private String name;

    @ApiModelProperty(value = "告警等级，等级越大，越严重")
    private Integer level;

    @ApiModelProperty(value = "告警方式")
    private String warningMethod;

    @ApiModelProperty(value = "告警影响")
    private String warningImpact;

    @ApiModelProperty(value = "租户", hidden = true)
    private String tenant;

    @ApiModelProperty(value = "操作人", hidden = true)
    private String operator;

    @ApiModelProperty(value = "是否为默认告警配置, 0-不是， 1-是")
    private int defaultFlag;

    @ApiModelProperty(value = "所属人")
    private String owner;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime updateTime;

}