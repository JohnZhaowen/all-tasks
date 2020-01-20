package com.john.alltasks.datasource.enums;

import com.john.alltasks.datasource.models.DataSourceTypeSelectableVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description: 数据源类型可选值
 * @author zhaowen.he
 */
@Getter
@AllArgsConstructor
public enum DataSourceTypeGroupEnum {
    FILE, RDB;
}
