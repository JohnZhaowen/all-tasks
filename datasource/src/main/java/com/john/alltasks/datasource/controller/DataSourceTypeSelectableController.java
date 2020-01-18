package com.john.alltasks.datasource.controller;

import com.john.alltasks.common.models.ResponseData;
import com.john.alltasks.datasource.models.DataSourceTypeSelectableVO;
import com.john.alltasks.datasource.service.DataSourceTypeSelectableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author: zhaowen.he
 * date: 2020/1/17
 * ticket:
 * description:
 */
@RestController
@RequestMapping("/datasource/selectable")
@Slf4j
@Api(tags = "数据源类型可选值")
public class DataSourceTypeSelectableController {

    @Autowired
    private DataSourceTypeSelectableService dataSourceTypeSelectableService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("数据源类型可选值查询")
    public ResponseData<List<DataSourceTypeSelectableVO>> warning(){
        return ResponseData.success("数据源类型可选值查询成功", dataSourceTypeSelectableService.getDataSourceTypeSeletable());
    }
}
