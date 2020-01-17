package com.john.alltasks.datasource.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description: 告警影响程度
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

    private String type;

}
