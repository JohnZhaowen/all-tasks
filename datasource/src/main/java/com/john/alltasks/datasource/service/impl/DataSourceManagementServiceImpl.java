package com.john.alltasks.datasource.service.impl;

import com.john.alltasks.common.exceptions.bizException.BizException;
import com.john.alltasks.common.security.AuthUtil;
import com.john.alltasks.datasource.mapper.DataSourceManagementMapper;
import com.john.alltasks.datasource.models.DataSourceInsertVO;
import com.john.alltasks.datasource.models.DataSourceListVO;
import com.john.alltasks.datasource.models.DataSourcePO;
import com.john.alltasks.datasource.models.DataSourceUpdateVO;
import com.john.alltasks.datasource.service.DataSourceManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: zhaowen.he
 * date: 2020/1/18
 * ticket:
 * description:
 */
@Slf4j
@Service
public class DataSourceManagementServiceImpl implements DataSourceManagementService {

    @Autowired
    private DataSourceManagementMapper dataSourceManagementMapper;

    @Override
    public void addDataSource(DataSourceInsertVO dataSourceInsertVO) {
        DataSourcePO dataSource = of(dataSourceInsertVO);

        //查询唯一索引是否存在冲突
        DataSourcePO existed = dataSourceManagementMapper.queryDataSourceByOwner(dataSource.getOwner(), dataSource.getName());
        if(existed != null && existed.getStatus() == 1){
            String content = String.format("用户[%s]下已经存在名称为[%s]的数据源配置，请重新设置数据源名称", dataSource.getOwner(), dataSource.getName());
            log.error(content);
            throw new BizException(400, content);
        }
        dataSourceManagementMapper.saveDataSource(dataSource);
    }

    private DataSourcePO of(DataSourceInsertVO dataSourceInsertVO) {
        DataSourcePO dataSource = new DataSourcePO();
        dataSource.setName(dataSourceInsertVO.getName());
        dataSource.setTypeGroup(dataSourceInsertVO.getTypeGroup());
        dataSource.setTypeName(dataSourceInsertVO.getTypeName());
        dataSource.setUrl(dataSourceInsertVO.getUrl());
        dataSource.setUsername(dataSourceInsertVO.getUsername());
        dataSource.setPassword(dataSourceInsertVO.getPassword());
        dataSource.setStatus(1);
        dataSource.setTenant(AuthUtil.getTenant());
        dataSource.setOperator(AuthUtil.getUserId());
        dataSource.setOwner(AuthUtil.getUserId());

        return dataSource;
    }

    @Override
    public void delDataSource(Long id) {
        dataSourceManagementMapper.removeDataSource(id, AuthUtil.getUserId());
    }

    @Override
    public void modify(DataSourceUpdateVO dataSourceUpdateVO) {
        DataSourcePO dataSource = of(dataSourceUpdateVO);
        String content = String.format("存在名称为[%s]的数据源配置，更新失败", dataSource.getName());
        try {
            dataSourceManagementMapper.updateDataSource(dataSource);
        } catch (DuplicateKeyException e) {
            log.error(content + " [{}]", e);
            throw new BizException(400, content);
        }
    }

    private DataSourcePO of(DataSourceUpdateVO dataSourceUpdateVO) {
        DataSourcePO dataSourcePO = new DataSourcePO();
        dataSourcePO.setId(dataSourceUpdateVO.getId());
        dataSourcePO.setName(dataSourceUpdateVO.getName());
        dataSourcePO.setTypeGroup(dataSourceUpdateVO.getTypeGroup());
        dataSourcePO.setTypeName(dataSourceUpdateVO.getTypeName());
        dataSourcePO.setUrl(dataSourceUpdateVO.getUrl());
        dataSourcePO.setUsername(dataSourceUpdateVO.getUsername());
        dataSourcePO.setPassword(dataSourceUpdateVO.getPassword());
        dataSourcePO.setOperator(AuthUtil.getUserId());
        return dataSourcePO;
    }

    @Override
    public List<DataSourceListVO> getDataSourceByTenant(String tenant) {
        return dataSourceManagementMapper.queryDataSourceByTenant(tenant);
    }
}
