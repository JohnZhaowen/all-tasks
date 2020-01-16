package com.john.alltasks.warning.models;

import com.john.alltasks.warning.enums.WarningImpactEnum;
import com.john.alltasks.warning.enums.WarningMethodEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:告警基本信息
 */
@Data
@ApiModel("告警基本信息")
public class Warning implements Serializable {

    @ApiModelProperty(value = "告警编号")
    private Long id;

    @ApiModelProperty(value = "告警名称")
    @NotBlank(message = "告警名称不可为空")
    private String name;

    @ApiModelProperty(value = "告警等级，等级越大，越严重")
    @Min(value = 1, message = "告警等级必须大于0")
    @NotNull(message = "告警等级不可为空")
    private Integer level;

    @ApiModelProperty(value = "告警方式")
    @NotNull(message = "告警方式不可为空")
    private WarningMethodEnum warningMethod;

    @ApiModelProperty(value = "告警影响")
    @NotNull(message = "告警影响不可为空")
    private WarningImpactEnum warningImpact;

    @ApiModelProperty(value = "租户", hidden = true)
    private String tenant;

    @ApiModelProperty(value = "操作人", hidden = true)
    private String operator;

    @ApiModelProperty(value = "责任人")
    private List<User> handers;

    @ApiModelProperty(value = "状态， 0-已删除， 1-正常")
    private int status;

    @ApiModelProperty(value = "是否为默认告警配置, 0-不是， 1-是")
    private int defaultFlag;

    private String warnContent;
}
