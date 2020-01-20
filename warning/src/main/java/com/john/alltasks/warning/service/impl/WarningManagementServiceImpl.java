package com.john.alltasks.warning.service.impl;

import com.john.alltasks.common.exceptions.bizException.BizException;
import com.john.alltasks.common.security.AuthUtil;
import com.john.alltasks.warning.mapper.WarningManagementMapper;
import com.john.alltasks.warning.models.*;
import com.john.alltasks.warning.service.WarningManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
    public void addWarning(WarningInsertVO warningInsertVO) {
        WarningPO warning = of(warningInsertVO);

        //查询唯一索引是否存在冲突
        WarningPO existed = warningManagementMapper.queryWarningByOwner(warning.getOwner(), warning.getName());
        if(existed != null && existed.getStatus() == 1){
            String content = String.format("用户[%s]下已经存在名称为[%s]的告警配置，请重新设置告警名称", warning.getOwner(), warning.getName());
            log.error(content);
            throw new BizException(400, content);
        }
        warningManagementMapper.saveWarning(warning);
    }

    private WarningPO of(WarningInsertVO warningInsertVO) {
        WarningPO warningPO = new WarningPO();
        warningPO.setName(warningInsertVO.getName());
        warningPO.setLevel(warningInsertVO.getLevel());
        warningPO.setWarningImpact(warningInsertVO.getWarningImpact());
        warningPO.setWarningMethod(warningInsertVO.getWarningMethod());
        warningPO.setTenant(AuthUtil.getTenant());
        warningPO.setOwner(AuthUtil.getUserId());
        warningPO.setOperator(AuthUtil.getUserId());
        warningPO.setDefaultFlag(0);
        warningPO.setStatus(1);

        return warningPO;
    }

    @Override
    public void delWarning(Long id) {
        warningManagementMapper.removeWarning(id, AuthUtil.getUserId());
    }

    @Override
    public void modify(WarningUpdateVO warningUpdateVO) {
        WarningPO warning = of(warningUpdateVO);
        String content = String.format("存在名称为[%s]的告警配置，更新失败", warning.getName());
        try {
            warningManagementMapper.updateWarning(warning);
        } catch (DuplicateKeyException e) {
            log.error(content + " [{}]", e);
            throw new BizException(400, content);
        }
    }

    private WarningPO of(WarningUpdateVO warningUpdateVO) {
        WarningPO warningPO = new WarningPO();
        warningPO.setId(warningUpdateVO.getId());
        warningPO.setName(warningUpdateVO.getName());
        warningPO.setLevel(warningUpdateVO.getLevel());
        warningPO.setWarningImpact(warningUpdateVO.getWarningImpact());
        warningPO.setWarningMethod(warningUpdateVO.getWarningMethod());
        warningPO.setOperator(AuthUtil.getUserId());
        return warningPO;
    }

    @Override
    public List<WarningListVO> getWarningByTenant(String tenant) {
        return warningManagementMapper.queryWarningByTenant(tenant);
    }
}
