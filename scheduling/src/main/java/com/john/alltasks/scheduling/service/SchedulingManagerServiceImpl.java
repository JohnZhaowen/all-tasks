package com.john.alltasks.scheduling.service;

import com.john.alltasks.scheduling.job.CommonJobDisallowConcurrentExecution;
import com.john.alltasks.scheduling.job.CommonJobExecution;
import com.john.alltasks.scheduling.models.Scheduling;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
@Slf4j
public class SchedulingManagerServiceImpl implements SchedulingManagerService {
	
	@Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

	@Autowired
    private RestTemplate restTemplate;

    /**
     * 创建一个定时任务
     * @throws SchedulerException
     */
    @Override
    public void addCronJob(Scheduling scheduling) {
        try {
            String jobName = scheduling.getJobName();
            String jobGroup = scheduling.getJobGroup();
            String executeurl = scheduling.getExecuteurl();

            Job job = scheduling.getDisallowConcurrentExecution() ?
                    new CommonJobDisallowConcurrentExecution() :
                    new CommonJobExecution();

            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            //StdScheduler
            JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);


            if (jobDetail != null) {
                log.info("job: [{}] 已存在", jobName);
                this.resumeJob(jobName, jobGroup);
            } else {

                //构建job信息
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("jobName", jobName);
                dataMap.put("jobGroup", jobGroup);
                dataMap.put("executeurl", executeurl);

                jobDetail = JobBuilder.newJob(job.getClass()).setJobData(new JobDataMap(dataMap)).withIdentity(jobName, jobGroup).build();
                //用JopDataMap来传递数据
                //jobDetail.getJobDataMap().put("taskData", "hzb-cron-001");

                //表达式调度构建器(即	任务执行的时间,每5秒执行一次)
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduling.getCronExpress());

                //按新的cronExpression表达式构建一个新的trigger
                CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName + "_trigger", jobGroup + "_trigger")
                        .withSchedule(scheduleBuilder).build();

                scheduler.scheduleJob(jobDetail, trigger);
                scheduler.start();

            }

        } catch (Exception ex) {
            log.error("任务启动失败[{}]", ex);
        }
    }
    
    /**
     * 暂停任务
     */
    @Override
    public void pauseJob(String jobName, String jobGroup) {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName + "_trigger", jobGroup + "_trigger");

            scheduler.pauseTrigger(triggerKey);
            log.info("=========================pause job:" + jobName + " success========================");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 恢复任务
     *
     */
    @Override
    public void resumeJob(String jobName, String jobGroup) {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName + "_trigger", jobGroup + "_trigger");
            scheduler.resumeTrigger(triggerKey);
            log.info("=========================resume job:" + jobName + " success========================");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 删除任务
     */
    @Override
    public void deleteJob(String jobName, String jobGroup) {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            JobKey jobKey = JobKey.jobKey(jobName,jobGroup);
            scheduler.deleteJob(jobKey);
            log.info("=========================delete job:" + jobName + " success========================");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

}
