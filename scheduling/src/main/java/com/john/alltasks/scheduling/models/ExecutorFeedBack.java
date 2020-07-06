package com.john.alltasks.scheduling.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExecutorFeedBack implements Serializable {

    private static final long serialVersionUID = 7022045544156334712L;

    private Boolean success;

    private String msg;

    private Integer code;

    //任务的执行代码
    private String executeCode;
}
