package com.john.alltasks.datasource.service;

import com.john.alltasks.warning.models.WarningTriggerBO;

public interface WarnTriggerService {

    void trigger(WarningTriggerBO warning);
}
