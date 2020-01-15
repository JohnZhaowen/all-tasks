package com.john.alltasks.warning.enums;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description: 告警影响程度
 */
public enum WarningImpactEnum {
    /**
     * 对作业无影响
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
     * 当前及后续作业中止
     */
    CURRENT_AND_FUTURE_TASK_SUSPEND,
    /**
     * 当前作业回滚，后续作业中止
     */
    CURRENT_ROLLBACK_FUTURE_SUSPEND;
}
