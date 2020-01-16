package com.john.alltasks.warning.controller;

import com.john.alltasks.common.models.ResponseData;
import com.john.alltasks.common.utils.ValidationUtil;
import com.john.alltasks.warning.models.Warning;
import com.john.alltasks.warning.service.WarnTriggerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * author: zhaowen.he
 * date: 2020/1/16
 * ticket:
 * description:
 */
@RestController
@RequestMapping("/warning/trigger")
@Slf4j
@Api(tags = "告警触发")
public class WarnTriggerController {

    @Autowired
    private WarnTriggerService warnTriggerService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("告警触发")
    @ApiImplicitParam(paramType = "path", name = "id", value = "告警编号", required = true, dataType = "long")
    public ResponseData<String> trigger(@Valid @RequestBody Warning warning, BindingResult bindingResult){

        if(!ValidationUtil.validParam(bindingResult)){
            return ResponseData.error(400, "入参错误");
        }

        warnTriggerService.trigger(warning);
        return ResponseData.success("告警触发成功");
    }


}
