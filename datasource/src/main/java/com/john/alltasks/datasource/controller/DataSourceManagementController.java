package com.john.alltasks.datasource.controller;

import com.john.alltasks.common.models.ResponseData;
import com.john.alltasks.common.security.AuthUtil;
import com.john.alltasks.common.utils.ValidationUtil;
import com.john.alltasks.datasource.enums.DataSourceTypeEnum;
import com.john.alltasks.datasource.enums.DataSourceTypeGroupEnum;
import com.john.alltasks.datasource.models.DataSourceInsertVO;
import com.john.alltasks.datasource.models.DataSourceListVO;
import com.john.alltasks.datasource.models.DataSourceUpdateVO;
import com.john.alltasks.datasource.service.DataSourceManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
 * description: 数据源配置的增删改查 + 试跑
 */
@RestController
@RequestMapping("/datasource/management")
@Slf4j
@Api(tags = "数据源配置管理")
public class DataSourceManagementController {

    @Autowired
    private DataSourceManagementService dataSourceManagementService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("数据源配置新增")
    @ApiImplicitParam(paramType = "body", name = "dataSource", value = "数据源配置", required = true, dataType = "DataSourceInsertVO")
    public ResponseData<String> addWarning(@Valid @RequestBody DataSourceInsertVO dataSource, BindingResult bindingResult){

        if(!ValidationUtil.validParam(bindingResult)) {
            return ResponseData.error(400, "入参错误");
        }
        if(!checkTypeGroupAndName(dataSource.getTypeGroup(), dataSource.getTypeName())){
            log.error("数据源类型分组与数据源类型名称不匹配");
            return ResponseData.error(400, "数据源类型分组与数据源类型名称不匹配");
        }
        if(!checkRdbConfig(dataSource.getTypeGroup(), dataSource.getUsername(), dataSource.getPassword())){
            log.error("数据库配置中用户名或密码为空");
            return ResponseData.error(400, "数据库配置中用户名或密码为空");
        }

        dataSourceManagementService.addDataSource(dataSource);
        return ResponseData.success("数据源配置新增成功");
    }

    private boolean checkTypeGroupAndName(String group, String name){
        return DataSourceTypeEnum.existed(group, name);
    }

    private boolean checkRdbConfig(String typeGroup, String username, String password){
        if(DataSourceTypeGroupEnum.RDB.name().equals(typeGroup) && (StringUtils.isBlank(username) || StringUtils.isBlank(password))){
            return false;
        }
        return true;
    }

    @DeleteMapping(value = "/{id}",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("数据源配置删除")
    @ApiImplicitParam(paramType = "path", name = "id", value = "数据源编号", required = true, dataType = "long")
    public ResponseData<String> delWarning(@PathVariable("id") Long id){
        dataSourceManagementService.delDataSource(id);
        return ResponseData.success("数据源配置删除成功");
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("数据源配置修改")
    @ApiImplicitParam(paramType = "body", name = "dataSource", value = "数据源配置", required = true, dataType = "DataSourceUpdateVO")
    public ResponseData<String> modifyWarning(@Valid @RequestBody DataSourceUpdateVO dataSource, BindingResult bindingResult){

        if(!ValidationUtil.validParam(bindingResult)){
            return ResponseData.error(400, "入参错误");
        }
        if(!checkTypeGroupAndName(dataSource.getTypeGroup(), dataSource.getTypeName())){
            log.error("数据源类型分组与数据源类型名称不匹配");
            return ResponseData.error(400, "数据源类型分组与数据源类型名称不匹配");
        }
        if(!checkRdbConfig(dataSource.getTypeGroup(), dataSource.getUsername(), dataSource.getPassword())){
            log.error("数据库配置中用户名或密码为空");
            return ResponseData.error(400, "数据库配置中用户名或密码为空");
        }

        dataSourceManagementService.modify(dataSource);
        return ResponseData.success("数据源配置修改成功");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("数据源配置查询")
    public ResponseData<List<DataSourceListVO>> getWarningByTenant(){
        List<DataSourceListVO> dataSources = dataSourceManagementService.getDataSourceByTenant(AuthUtil.getTenant());
        return ResponseData.success("数据源配置查询成功", dataSources);
    }

}
