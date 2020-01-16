package com.john.alltasks.warning.service;

import com.john.alltasks.warning.models.Warning;

import java.util.List;

public interface WarningManagementService {

    void addWarning(Warning warning);

    void delWarning(Long id);

    void modify(Warning warning);

    List<Warning> getWarningByTenant(String tenant);
}
