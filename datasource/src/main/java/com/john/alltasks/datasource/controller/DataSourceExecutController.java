package com.john.alltasks.datasource.controller;

import com.john.alltasks.common.models.ResponseData;
import com.john.alltasks.common.utils.ValidationUtil;
import com.john.alltasks.datasource.enums.DataSourceTypeEnum;
import com.john.alltasks.datasource.enums.DataSourceTypeGroupEnum;
import com.john.alltasks.datasource.models.DataSourceConnectVO;
import com.john.alltasks.datasource.models.DataSourceExecuteVO;
import com.john.alltasks.datasource.service.DataSourceExecutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
 * date: 2020/1/20
 * ticket:
 * description: 数据源执行
 */
@RestController
@RequestMapping("/datasource/execute")
@Slf4j
@Api(tags = "数据源执行")
public class DataSourceExecutController {

    @Autowired
    private DataSourceExecutService dataSourceExecutService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("数据源试连")
    @ApiImplicitParam(paramType = "body", name = "d", value = "数据源配置", required = true, dataType = "DataSourceConnectVO")
    public ResponseData<Boolean> tryConnect(@Valid @RequestBody DataSourceConnectVO d, BindingResult bindingResult){

        if(!ValidationUtil.validParam(bindingResult)) {
            return ResponseData.error(400, "入参错误");
        }
        if(!DataSourceTypeEnum.existed(d.getTypeGroup(), d.getTypeName())){
            log.error("数据源类型分组与数据源类型名称不匹配");
            return ResponseData.error(400, "数据源类型分组与数据源类型名称不匹配");
        }
        if(!DataSourceTypeGroupEnum.RDB.name().equals(d.getTypeGroup()) && (StringUtils.isBlank(d.getUsername()) || StringUtils.isBlank(d.getPassword()))){
            log.error("数据库配置中用户名或密码为空");
            return ResponseData.error(400, "数据库配置中用户名或密码为空");
        }
        return ResponseData.success("数据源试连操作成功", dataSourceExecutService.tryConnect(d));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("数据源查询语句执行")
    @ApiImplicitParam(paramType = "body", name = "d", value = "数据源配置", required = true, dataType = "DataSourceConnectVO")
    public <T> ResponseData<T> executeQuery(@Valid @RequestBody DataSourceExecuteVO d, BindingResult bindingResult){

        if(!ValidationUtil.validParam(bindingResult)) {
            return ResponseData.error(400, "入参错误");
        }
        if(!DataSourceTypeEnum.existed(d.getTypeGroup(), d.getTypeName())) {
            log.error("数据源类型分组与数据源类型名称不匹配");
            return ResponseData.error(400, "数据源类型分组与数据源类型名称不匹配");
        }
        if(!DataSourceTypeGroupEnum.RDB.name().equals(d.getTypeGroup()) && (StringUtils.isBlank(d.getUsername()) || StringUtils.isBlank(d.getPassword()))) {
            log.error("数据库配置中用户名或密码为空");
            return ResponseData.error(400, "数据库配置中用户名或密码为空");
        }
        return ResponseData.success("数据源查询语句执行成功", dataSourceExecutService.query(d));
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("数据源DML语句执行")
    @ApiImplicitParam(paramType = "body", name = "d", value = "数据源配置", required = true, dataType = "DataSourceConnectVO")
    public ResponseData<String> executeDML(@Valid @RequestBody DataSourceExecuteVO d, BindingResult bindingResult){
        //增删改
        if(!ValidationUtil.validParam(bindingResult)) {
            return ResponseData.error(400, "入参错误");
        }
        if(!DataSourceTypeEnum.existed(d.getTypeGroup(), d.getTypeName())){
            log.error("数据源类型分组与数据源类型名称不匹配");
            return ResponseData.error(400, "数据源类型分组与数据源类型名称不匹配");
        }
        if(!DataSourceTypeGroupEnum.RDB.name().equals(d.getTypeGroup()) && (StringUtils.isBlank(d.getUsername()) || StringUtils.isBlank(d.getPassword()))){
            log.error("数据库配置中用户名或密码为空");
            return ResponseData.error(400, "数据库配置中用户名或密码为空");
        }
        dataSourceExecutService.dml(d);
        return ResponseData.success("数据源DML语句执行成功");
    }

}
