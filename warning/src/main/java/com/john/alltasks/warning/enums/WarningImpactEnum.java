package com.john.alltasks.warning.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description: 告警影响程度
 */
public enum WarningImpactEnum {
    /**
     * 作业不影响
     */
    NO_IMPACT,
    /**
     * 当前作业中止
     */
    CURRENT_TASK_SUSPEND,
    /**
     * 当前作业回滚
     */
    CURRENT_TASK_ROLLBACK,
    /**
     * 后续作业不触发
     */
    FUTURE_TASK_UNTRIGGER;

    public static boolean isExist(String name){
        WarningImpactEnum targetWarningImpact = Arrays.stream(WarningImpactEnum.values()).filter(e -> StringUtils.equals(e.name(), name)).findFirst().orElse(null);
        return targetWarningImpact != null;
    }

    public static List<String> getNames(){
        return Arrays.stream(WarningImpactEnum.values()).map(w -> w.name()).collect(Collectors.toList());
    }
}
