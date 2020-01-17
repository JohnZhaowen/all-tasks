package com.john.alltasks.warning.controller;

import com.john.alltasks.common.models.ResponseData;
import com.john.alltasks.warning.models.WarningSelectableVO;
import com.john.alltasks.warning.service.WarningSelectableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: zhaowen.he
 * date: 2020/1/17
 * ticket:
 * description:
 */
@RestController
@RequestMapping("/warning/selectable")
@Slf4j
@Api(tags = "告警配置可选值")
public class WarningSelectableController {

    @Autowired
    private WarningSelectableService warningSelectableService;

    @GetMapping(value = "/warningMethod", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("可选告警方式查询")
    @ApiImplicitParam(paramType = "body", name = "warning", value = "告警配置", required = true, dataType = "WarningInsertVO")
    public ResponseData<WarningSelectableVO> warningMethod(){
        return ResponseData.success("可选告警方式查询成功", warningSelectableService.getWarningMethodSelectables());
    }

    @GetMapping(value = "/warningImpact", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("可选告警影响查询")
    @ApiImplicitParam(paramType = "body", name = "warning", value = "告警配置", required = true, dataType = "WarningInsertVO")
    public ResponseData<WarningSelectableVO> warningImpact(){
        return ResponseData.success("可选告警影响查询成功", warningSelectableService.getWarningImpactSelectables());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("可选告警方式/影响查询")
    @ApiImplicitParam(paramType = "body", name = "warning", value = "告警配置", required = true, dataType = "WarningInsertVO")
    public ResponseData<WarningSelectableVO> warning(){
        return ResponseData.success("可选告警方式及影响查询成功", warningSelectableService.getSelectables());
    }
}
