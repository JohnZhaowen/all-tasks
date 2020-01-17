package com.john.alltasks.datasource.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * author: zhaowen.he
 * date: 2020/1/17
 * ticket:
 * description:
 */
@Data
@ApiModel("告警可选配置实体类")
@NoArgsConstructor
@AllArgsConstructor
public class WarningSelectableVO implements Serializable {

    @ApiModelProperty(value = "参数类型", allowableValues = "warningMethod, warningImpact")
    private String type;

    @ApiModelProperty("可选值列表")
    private List<String> selects;

}
