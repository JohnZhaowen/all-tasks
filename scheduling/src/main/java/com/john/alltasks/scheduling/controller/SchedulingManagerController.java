package com.john.alltasks.scheduling.controller;

import com.john.alltasks.common.models.ResponseData;
import com.john.alltasks.scheduling.models.Scheduling;
import com.john.alltasks.scheduling.service.SchedulingManagerService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scheduling")
public class SchedulingManagerController {

    @Autowired
    private SchedulingManagerService schedulingManagerService;

    @PostMapping("/addCronJob")
    public ResponseData addCronJob(@RequestBody Scheduling scheduling){
        schedulingManagerService.addCronJob(scheduling);
        return new ResponseData(true, 200, "定时任务添加成功");
    }

    @GetMapping("/pauseJob")
    public ResponseData pauseJob(String jobName, String jobGroup) {

        schedulingManagerService.pauseJob(jobName, jobGroup);
        return new ResponseData(true, 200, "定时任务暂停成功");
    }

    @GetMapping("/resumeJob")
    public ResponseData resumeJob(String jobName, String jobGroup){
        schedulingManagerService.resumeJob(jobName, jobGroup);
        return new ResponseData(true, 200, "恢复任务成功");
    }

    @DeleteMapping("/deleteJob")
    public ResponseData deleteJob(String jobName, String jobGroup){
        schedulingManagerService.deleteJob(jobName, jobGroup);
        return new ResponseData(true, 200, "定时任务删除成功");
    }



}
