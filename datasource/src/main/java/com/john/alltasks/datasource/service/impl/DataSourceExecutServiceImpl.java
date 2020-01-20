package com.john.alltasks.datasource.service.impl;

import com.john.alltasks.datasource.models.DataSourceConnectVO;
import com.john.alltasks.datasource.models.DataSourceExecuteVO;
import com.john.alltasks.datasource.service.DataSourceExecutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * author: zhaowen.he
 * date: 2020/1/20
 * ticket:
 * description:
 */
@Service
@Slf4j
public class DataSourceExecutServiceImpl implements DataSourceExecutService {

    @Override
    public boolean tryConnect(DataSourceConnectVO dataSourceConnect) {
        return false;
    }

    @Override
    public <T> T query(DataSourceExecuteVO dataSourceExecute) {
        return null;
    }

    @Override
    public void dml(DataSourceExecuteVO dataSourceExecute) {

    }
}
