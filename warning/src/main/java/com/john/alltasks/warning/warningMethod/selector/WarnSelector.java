package com.john.alltasks.warning.warningMethod.selector;

import com.john.alltasks.warning.warningMethod.processor.WarnProcessor;

/**
 * author: zhaowen.he
 * date: 2020/1/16
 * ticket:
 * description:
 */
public interface WarnSelector {

    WarnProcessor getProcessor(String code);
}
