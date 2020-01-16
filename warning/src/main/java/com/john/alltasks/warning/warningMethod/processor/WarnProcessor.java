package com.john.alltasks.warning.warningMethod.processor;

import com.john.alltasks.warning.models.Warning;

public interface WarnProcessor {

    String getCode();

    void process(Warning warning);
}
