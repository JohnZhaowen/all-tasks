package com.john.alltasks.warning.service;

import com.john.alltasks.warning.models.WarningTriggerBO;

public interface WarnTriggerService {

    void trigger(WarningTriggerBO warning);
}
