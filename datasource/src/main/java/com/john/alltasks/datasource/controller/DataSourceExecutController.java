package com.john.alltasks.datasource.controller;

import com.john.alltasks.common.models.ResponseData;
import com.john.alltasks.datasource.models.DataSourceInsertVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * author: zhaowen.he
 * date: 2020/1/20
 * ticket:
 * description: 数据源执行
 */
@RestController
@RequestMapping("/datasource/execute")
@Slf4j
@Api(tags = "数据源执行")
public class DataSourceExecutController {


    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("数据源试连")
    @ApiImplicitParam(paramType = "body", name = "dataSource", value = "数据源配置", required = true, dataType = "DataSourceInsertVO")
    public ResponseData<String> tryConnect(@Valid @RequestBody DataSourceInsertVO dataSource, BindingResult bindingResult){


        return null;
    }



    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("数据源查询语句执行")
    @ApiImplicitParam(paramType = "body", name = "dataSource", value = "数据源配置", required = true, dataType = "DataSourceInsertVO")
    public ResponseData<String> executeQuery(@Valid @RequestBody DataSourceInsertVO dataSource, BindingResult bindingResult){


        return null;
    }




    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("数据源DDL语句执行")
    @ApiImplicitParam(paramType = "body", name = "dataSource", value = "数据源配置", required = true, dataType = "DataSourceInsertVO")
    public ResponseData<String> executeDDL(@Valid @RequestBody DataSourceInsertVO dataSource, BindingResult bindingResult){
        //增删改

        return null;
    }









}
