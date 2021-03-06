package com.john.alltasks.datasource.controller;

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
@RequestMapping("/datasource")
@Slf4j
@Api(tags = "首页")
public class IndexController {

    @GetMapping(value = {"", "/index"},  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("首页")
    public String index(){
        return "hello， this is datasource system!";
    }

}
