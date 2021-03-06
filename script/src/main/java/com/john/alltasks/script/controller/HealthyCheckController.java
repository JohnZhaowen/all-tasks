package com.john.alltasks.script.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:
 */
@RestController
@RequestMapping("/script")
@Slf4j
@Api(tags = "健康检查")
public class HealthyCheckController {

    @GetMapping(value = "/healthyCheck",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("健康检查")
    public String healthyCheck(){
        return "脚本管理项目健康检查成功!";
    }

}
