package com.john.alltasks.warning.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description: 告警方式
 */
public enum WarningMethodEnum {
    /**
     * 邮件提醒
     */
    EMAIL,
    /**
     * 短信提醒
     */
    SMS,
    /**
     * 微信提醒
     */
    WECHAT,
    /**
     * 电话提醒
     */
    PHONE;

    public static boolean isExist(String name){
        WarningMethodEnum targetWarningMethod = Arrays.stream(WarningMethodEnum.values()).filter(e -> StringUtils.equals(e.name(), name)).findFirst().orElse(null);
        return targetWarningMethod != null;
    }

    public static List<String> getNames(){
        return Arrays.stream(WarningMethodEnum.values()).map(w -> w.name()).collect(Collectors.toList());
    }
}
