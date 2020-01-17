package com.john.alltasks.warning.warningMethod.processor;

import com.john.alltasks.warning.models.WarningTriggerBO;

public interface WarnProcessor {

    String getCode();

    void process(WarningTriggerBO warning);
}
