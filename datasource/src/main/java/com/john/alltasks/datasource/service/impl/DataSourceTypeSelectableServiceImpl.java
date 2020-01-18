package com.john.alltasks.datasource.service.impl;

import com.john.alltasks.datasource.enums.DataSourceTypeEnum;
import com.john.alltasks.datasource.models.DataSourceTypeSelectableVO;
import com.john.alltasks.datasource.service.DataSourceTypeSelectableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: zhaowen.he
 * date: 2020/1/18
 * ticket:
 * description:
 */
@Service
@Slf4j
public class DataSourceTypeSelectableServiceImpl implements DataSourceTypeSelectableService {

    @Override
    public List<DataSourceTypeSelectableVO> getDataSourceTypeSeletable() {
        return DataSourceTypeEnum.groupBy();
    }
}
