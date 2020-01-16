package com.john.alltasks.warning.service.impl;

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
