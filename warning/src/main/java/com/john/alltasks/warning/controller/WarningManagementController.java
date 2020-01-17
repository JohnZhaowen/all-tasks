package com.john.alltasks.warning.controller;

import com.john.alltasks.common.models.ResponseData;
import com.john.alltasks.common.security.AuthUtil;
import com.john.alltasks.common.utils.ValidationUtil;
import com.john.alltasks.warning.enums.WarningImpactEnum;
import com.john.alltasks.warning.enums.WarningMethodEnum;
import com.john.alltasks.warning.models.WarningInsertVO;
import com.john.alltasks.warning.models.WarningListVO;
import com.john.alltasks.warning.models.WarningUpdateVO;
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
    @ApiImplicitParam(paramType = "body", name = "warning", value = "告警配置", required = true, dataType = "WarningInsertVO")
    public ResponseData<String> addWarning(@Valid @RequestBody WarningInsertVO warning, BindingResult bindingResult){

        if(!ValidationUtil.validParam(bindingResult)){
            return ResponseData.error(400, "入参错误");
        }
        if(!checkWarningMethod(warning.getWarningMethod())){
            return ResponseData.error(400, "告警方式配置错误");
        }
        if(!checkWarningImpact(warning.getWarningImpact())){
            return ResponseData.error(400, "告警影响配置错误");
        }
        warningManagementService.addWarning(warning);
        return ResponseData.success("告警配置新增成功");
    }

    private boolean checkWarningMethod(String warningMethods){
        String[] warningMethodArray = warningMethods.split(",");
        for(String warningMehtod : warningMethodArray){
            if(!WarningMethodEnum.isExist(warningMehtod)){
                log.error("告警方式配置错误");
                return false;
            }
        }
        return true;
    }

    private boolean checkWarningImpact(String warningImpacts){
        String[] warningImpactArray = warningImpacts.split(",");
        for(String warningImpact : warningImpactArray){
            if(!WarningImpactEnum.isExist(warningImpact)){
                log.error("告警影响配置错误");
                return false;
            }
        }
        return true;
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
    @ApiImplicitParam(paramType = "body", name = "warning", value = "告警配置", required = true, dataType = "WarningUpdateVO")
    public ResponseData<String> modifyWarning(@Valid @RequestBody WarningUpdateVO warning, BindingResult bindingResult){

        if(!ValidationUtil.validParam(bindingResult) || warning.getId() == null){
            return ResponseData.error(400, "入参错误");
        }
        if(!checkWarningMethod(warning.getWarningMethod())){
            return ResponseData.error(400, "告警方式配置错误");
        }
        if(!checkWarningImpact(warning.getWarningImpact())){
            return ResponseData.error(400, "告警影响配置错误");
        }
        warningManagementService.modify(warning);
        return ResponseData.success("告警配置修改成功");
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("告警配置查询")
    public ResponseData<List<WarningListVO>> getWarningByTenant(){
        List<WarningListVO> warnings = warningManagementService.getWarningByTenant(AuthUtil.getTenant());
        return ResponseData.success("告警配置查询成功", warnings);
    }

}
