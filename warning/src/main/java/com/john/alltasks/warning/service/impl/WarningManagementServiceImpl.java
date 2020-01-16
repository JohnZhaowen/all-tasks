package com.john.alltasks.warning.service.impl;

import com.john.alltasks.common.exceptions.bizException.BizException;
import com.john.alltasks.warning.mapper.WarningManagementMapper;
import com.john.alltasks.warning.models.Warning;
import com.john.alltasks.warning.service.WarningManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: zhaowen.he
 * date: 2020/1/16
 * ticket:
 * description:
 */
@Slf4j
@Service
public class WarningManagementServiceImpl implements WarningManagementService {

    @Autowired
    private WarningManagementMapper warningManagementMapper;

    @Override
    public void addWarning(Warning warning) {
        //查询唯一索引是否存在冲突
        Warning existed = warningManagementMapper.queryWarningByOwner(warning.getOwner(), warning.getName());
        if(existed != null && existed.getStatus() == 1){
            String content = String.format("用户[%s]下已经存在名称为[%s]的告警配置，请重新设置告警名称", warning.getOwner(), warning.getName());
            log.error(content);
            throw new BizException(400, content);
        }
        warningManagementMapper.saveWarning(warning);
    }

    @Override
    public void delWarning(Long id) {
        warningManagementMapper.removeWarning(id);
    }

    @Override
    public void modify(Warning warning) {
        warningManagementMapper.updateWarning(warning);
    }

    @Override
    public List<Warning> getWarningByTenant(String tenant) {
        return warningManagementMapper.queryWarningByTenant(tenant);
    }
}
