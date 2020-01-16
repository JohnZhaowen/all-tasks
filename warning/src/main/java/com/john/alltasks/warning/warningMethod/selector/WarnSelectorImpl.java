package com.john.alltasks.warning.warningMethod.selector;

import com.john.alltasks.warning.warningMethod.processor.WarnProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * author: zhaowen.he
 * date: 2020/1/16
 * ticket:
 * description:
 */
@Service
@Slf4j
public class WarnSelectorImpl implements WarnSelector, BeanPostProcessor {

    private Map<String, WarnProcessor> processorMap = new HashMap<>();

    @Override
    public WarnProcessor getProcessor(String code) {
        return processorMap.get(code);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof WarnProcessor){
            WarnProcessor targetBean = (WarnProcessor)bean;
            processorMap.put(targetBean.getCode(), targetBean);
        }
        return bean;
    }


}
