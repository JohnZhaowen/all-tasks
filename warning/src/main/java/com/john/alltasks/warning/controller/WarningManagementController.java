package com.john.alltasks.warning.controller;

import com.john.alltasks.common.models.ResponseData;
import com.john.alltasks.common.utils.ValidationUtil;
import com.john.alltasks.warning.models.Warning;
import com.john.alltasks.warning.service.WarningManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * author: zhaowen.he
 * date: 2020/1/16
 * ticket:
 * description: 告警配置的增删改查 + 试跑
 */
@RestController
@RequestMapping("/warning/management")
@Slf4j
@Api(tags = "告警配置管理")
public class WarningManagementController {

    @Autowired
    private WarningManagementService warningManagementService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("告警配置新增")
    @ApiImplicitParam(paramType = "body", name = "warning", value = "告警配置", required = true, dataType = "Warning")
    public ResponseData<String> addWarning(@Valid @RequestBody Warning warning, BindingResult bindingResult){

        if(!ValidationUtil.validParam(bindingResult)){
            return ResponseData.error(400, "入参错误");
        }
        //TODO 填充租户用用户信息

        warningManagementService.addWarning(warning);
        return ResponseData.success("告警配置新增成功");
    }

    @DeleteMapping(value = "/{id}",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("告警配置删除")
    @ApiImplicitParam(paramType = "path", name = "id", value = "告警编号", required = true, dataType = "long")
    public ResponseData<String> delWarning(@PathVariable("id") Long id){
        warningManagementService.delWarning(id);
        return ResponseData.success("告警配置删除成功");
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("告警配置修改")
    @ApiImplicitParam(paramType = "body", name = "warning", value = "告警配置", required = true, dataType = "Warning")
    public ResponseData<String> modifyWarning(@Valid @RequestBody Warning warning, BindingResult bindingResult){

        if(!ValidationUtil.validParam(bindingResult) || warning.getId() == null){
            return ResponseData.error(400, "入参错误");
        }
        //TODO 填充租户信息和用户信息
        warningManagementService.modify(warning);
        return ResponseData.success("告警配置修改成功");
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("告警配置查询")
    public ResponseData<List<Warning>> getWarningByTenant(){

        //TODO 租户获取
        String tenant = "test.com";

        List<Warning> warnings = warningManagementService.getWarningByTenant(tenant);
        return ResponseData.success("告警配置修改成功", warnings);
    }

}






















