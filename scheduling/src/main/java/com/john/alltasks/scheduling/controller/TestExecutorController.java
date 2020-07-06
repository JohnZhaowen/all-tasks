package com.john.alltasks.scheduling.controller;

import com.john.alltasks.common.models.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/scheduling/execute")
public class TestExecutorController {

    @GetMapping("")
    public ResponseData execute(String executorCode) throws Exception{
        TimeUnit.SECONDS.sleep(3);
        return new ResponseData(true, 200, "任务触发成功");

    }


}
