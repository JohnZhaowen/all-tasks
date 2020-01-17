package com.john.alltasks.warning.service;

import com.john.alltasks.warning.models.WarningInsertVO;
import com.john.alltasks.warning.models.WarningListVO;
import com.john.alltasks.warning.models.WarningUpdateVO;

import java.util.List;

public interface WarningManagementService {

    void addWarning(WarningInsertVO warningInsertVO);

    void delWarning(Long id);

    void modify(WarningUpdateVO warningUpdateVO);

    List<WarningListVO> getWarningByTenant(String tenant);
}
