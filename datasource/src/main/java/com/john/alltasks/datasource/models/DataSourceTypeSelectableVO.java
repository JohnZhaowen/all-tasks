package com.john.alltasks.datasource.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * author: zhaowen.he
 * date: 2020/1/18
 * ticket:
 * description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceTypeSelectableVO implements Serializable {

    private static final long serialVersionUID = 4592274745444286856L;

    @ApiModelProperty(value = "数据源类型分组", allowableValues = "FILE, RDB")
    private String typeGroup;

    @ApiModelProperty("可选值列表")
    private List<String> type;

}
