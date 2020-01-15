package com.john.alltasks.warning.models;

import com.john.alltasks.warning.enums.WarningImpactEnum;
import com.john.alltasks.warning.enums.WarningMethodEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:告警基本信息
 */
@Data
@ApiModel("告警基本信息")
public class Warning implements Serializable {

    @ApiModelProperty("告警编号")
    private int id;

    @ApiModelProperty("告警名称")
    private String name;

    @ApiModelProperty("告警等级，等级越小，越严重")
    private int level;

    @ApiModelProperty("告警方式")
    private WarningMethodEnum warningMethod;

    @ApiModelProperty("告警影响")
    private WarningImpactEnum warningImpact;

}
