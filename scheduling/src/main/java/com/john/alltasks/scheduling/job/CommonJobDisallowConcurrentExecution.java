package com.john.alltasks.scheduling.job;

import com.john.alltasks.common.models.ResponseData;
import com.john.alltasks.scheduling.config.SpringContextUtil;
import com.john.alltasks.scheduling.util.DataMapUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.web.client.RestTemplate;

@DisallowConcurrentExecution
@Slf4j
public class CommonJobDisallowConcurrentExecution implements Job {

    @Override
    public void execute(JobExecutionContext context) {

        RestTemplate restTemplate = SpringContextUtil.getBean(RestTemplate.class);

        //给对方传一个本次执行任务的唯一标识码，以方便回调调度系统通知已完成
        ResponseData triggerResult = restTemplate.getForObject(
                DataMapUtil.getExecuteUrl(context),
                ResponseData.class,
                DataMapUtil.genarateExecuteCode(DataMapUtil.getJobName(context), DataMapUtil.getJobGroup(context)));

        if(triggerResult.isSuccess()){
            log.info("任务名称[{}]，任务分组[{}]，触发任务成功", DataMapUtil.getJobName(context), DataMapUtil.getJobGroup(context));
        } else {
            log.info("任务名称[{}]，任务分组[{}]，触发任务失败[{}]", DataMapUtil.getJobName(context), DataMapUtil.getJobGroup(context), triggerResult.getMessage());
        }
    }
}
