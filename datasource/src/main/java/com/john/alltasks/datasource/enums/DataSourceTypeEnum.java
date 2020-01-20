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
public enum DataSourceTypeEnum {

    EXCEL("FILE", "EXCEL"),
    CSV("FILE", "CSV"),
    MDB("FILE", "MDB"),
    TXT("FILE", "TXT"),

    MYSQL("RDB", "MYSQL"),
    ORACLE("RDB", "ORACLE"),
    SQLSERVER("RDB", "SQLSERVER");

    private String group;

    private String name;

    public static List<DataSourceTypeSelectableVO> groupBy(){

        DataSourceTypeEnum[] dataSourceTypeEnums = DataSourceTypeEnum.values();

        List<String> groups = Arrays.stream(dataSourceTypeEnums).map(e -> e.getGroup()).distinct().collect(Collectors.toList());
        List<DataSourceTypeSelectableVO> dataSourceTypeSelectableVOS = new ArrayList<>(groups.size());


        groups.forEach(g -> {
            List<String> types = Arrays.stream(dataSourceTypeEnums).filter(d -> StringUtils.equals(d.getGroup(), g)).map(e -> e.getName()).collect(Collectors.toList());
            DataSourceTypeSelectableVO v = new DataSourceTypeSelectableVO(g, types);
            dataSourceTypeSelectableVOS.add(v);
        });

       return dataSourceTypeSelectableVOS;
    }

    public static boolean existed(String group, String name){
        DataSourceTypeEnum target = Arrays.stream(DataSourceTypeEnum.values()).filter(e -> StringUtils.equals(group, e.group) && StringUtils.equals(name, e.name)).findFirst().orElse(null);
        return target != null;
    }

}
