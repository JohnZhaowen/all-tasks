package com.john.alltasks.datasource.service;


import com.john.alltasks.datasource.models.DataSourceInsertVO;
import com.john.alltasks.datasource.models.DataSourceListVO;
import com.john.alltasks.datasource.models.DataSourceUpdateVO;

import java.util.List;

public interface DataSourceManagementService {

    void addDataSource(DataSourceInsertVO dataSource);

    void delDataSource(Long id);

    /**
     * 只允许修改名称，及数据源的三个链接配置信息
     * @param dataSource
     */
    void modify(DataSourceUpdateVO dataSource);

    List<DataSourceListVO> getDataSourceByTenant(String tenant);
}
