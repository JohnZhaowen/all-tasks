package com.john.alltasks.warning.models;

import lombok.Data;

import java.io.Serializable;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:告警基本信息
 */
@Data
public class WarningPO implements Serializable {

    private Long id;

    private String name;

    private Integer level;

    private String warningMethod;

    private String warningImpact;

    private String tenant;

    private String operator;

    private int status;

    private int defaultFlag;

    private String warnContent;

    private String owner;
}
