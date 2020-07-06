package com.john.alltasks.scheduling.util;

import org.apache.commons.lang3.text.StrBuilder;
import org.quartz.JobExecutionContext;

import java.util.UUID;

public class DataMapUtil {

    private static final String EXECUTE_URL = "executeurl";
    private static final String JOB_NAME = "jobName";
    private static final String JOB_GROUP = "jobGroup";

    public static String getExecuteUrl(JobExecutionContext jobExecutionContext){
        return jobExecutionContext.getJobDetail().getJobDataMap().get(EXECUTE_URL).toString();
    }

    public static String getJobName(JobExecutionContext jobExecutionContext){
        return jobExecutionContext.getJobDetail().getJobDataMap().get(JOB_NAME).toString();
    }

    public static String getJobGroup(JobExecutionContext jobExecutionContext){
        return jobExecutionContext.getJobDetail().getJobDataMap().get(JOB_GROUP).toString();
    }

    public static String genarateExecuteCode(String jobName, String jobGroup){
        return new StrBuilder(UUID.randomUUID().toString().replace("-", ""))
                .append("-").append(jobName).append("-").append(jobGroup).toString();
    }

}
