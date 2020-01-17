package com.john.alltasks.datasource.models;

import com.john.alltasks.warning.enums.WarningImpactEnum;
import com.john.alltasks.warning.enums.WarningMethodEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:告警触发业务实体类
 */
@Data
@ApiModel("告警触发业务实体类")
public class WarningTriggerBO implements Serializable {

    @ApiModelProperty(value = "告警方式")
    @NotEmpty(message = "告警方式不可为空")
    private List<WarningMethodEnum> warningMethods;

    @ApiModelProperty(value = "告警影响")
    @NotEmpty(message = "告警影响不可为空")
    private List<WarningImpactEnum> warningImpacts;

    @ApiModelProperty(value = "责任人")
    @NotEmpty(message = "告警影响不可为空")
    private List<User> handers;

    @ApiModelProperty(value = "告警内容")
    @NotBlank(message = "告警内容不可为空")
    private String warnContent;

}
