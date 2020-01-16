package com.john.alltasks.warning.service.impl;

import com.john.alltasks.warning.enums.WarningMethodEnum;
import com.john.alltasks.warning.models.Warning;
import com.john.alltasks.warning.service.WarnTriggerService;
import com.john.alltasks.warning.warningMethod.EmailWarning;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: zhaowen.he
 * date: 2020/1/16
 * ticket:
 * description:
 */
@Service
@Slf4j
public class WarnTriggerServiceImpl implements WarnTriggerService {

    @Autowired
    private EmailWarning emailWarning;

    @Override
    public void trigger(Warning warning) {

        //提醒方式
        if(warning.getWarningMethod() == WarningMethodEnum.EMAIL){
            emailWarning.emailWarn("zhaowen.he@datayes.com", "告警提醒", "您有新的告警信息：" + warning);
        }

        //TODO 告警影响处理，这里需要调用作业服务

    }
}
