package com.john.alltasks.datasource.service;

import com.john.alltasks.datasource.models.DataSourceConnectVO;
import com.john.alltasks.datasource.models.DataSourceExecuteVO;

public interface DataSourceExecutService {

    boolean tryConnect(DataSourceConnectVO dataSourceConnect);

    <T> T query(DataSourceExecuteVO dataSourceExecute);

    void dml(DataSourceExecuteVO dataSourceExecute);
}
