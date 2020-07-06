package com.john.alltasks.scheduling.models;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Scheduling implements Serializable {

    private static final long serialVersionUID = -6924586290750490024L;

    private String jobGroup;

    private String jobName;

    private String executeurl;

    private Boolean disallowConcurrentExecution;

    private String cronExpress;

    private String tenant;

    private String operator;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
