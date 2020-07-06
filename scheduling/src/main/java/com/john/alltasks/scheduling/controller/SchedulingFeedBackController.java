package com.john.alltasks.scheduling.controller;


import com.john.alltasks.common.models.ResponseData;
import com.john.alltasks.scheduling.models.ExecutorFeedBack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scheduling/executor")
@Slf4j
public class SchedulingFeedBackController {

    @GetMapping("/feedBack")
    public ResponseData feedBack(ExecutorFeedBack executorFeedBack) {

        String executeCode = executorFeedBack.getExecuteCode();

        if(executorFeedBack.getSuccess()){
            log.info("任务[{}]执行成功", executeCode);

        } else {
            log.info("任务[{}]执行失败", executeCode);
        }
        //TODO 更新任务状态

        return new ResponseData(true, 200, "反馈处理成功");

    }


}
