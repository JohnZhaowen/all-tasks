package com.john.alltasks.scheduling.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CronInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * cronInfo编号
	 */
	private Long id;
	/**
	 * 作业编号
	 */
	private Long jobId;
	/**
	 * 解析后得到的cron表达式
	 */
	private String cronExpress;
	/**
	 * 作业实例生成方式：
	 * 0-T+1日生成
	 * 1-发布后即时生成
	 */
	private String instanceCreationMethod;
	/**
	 * 生效日期（yyyy-MM-dd）
	 */
	private Date effectiveDate;
	/**
	 * 失效日期（yyyy-MM-dd）
	 */
	private Date expirationDate;
	/**
	 * 调度周期：
	 * 0-分钟
	 * 1-小时
	 * 2-日
	 * 3-周
	 * 4-月
	 */
	private String triggerPeriod;
	/**
	 * 调度开始时间（HH:mm）：
	 * 分钟：需要指定
	 * 时：需要指定
	 * 日：需要指定
	 * 周：需要指定
	 * 月：需要指定
	 */
	private Date startTime;
	/**
	 * 调度结束时间（HH:mm）：
	 * 分钟：需要指定
	 * 时：需要指定
	 * 日：null
	 * 周：null
	 * 月：null
	 * 
	 */
	private Date endTime;
	/**
	 * 是否指定执行小时
	 * 0-非指定
	 * 1-指定
	 */
	private String specifyHourFlg;
	/**
	 * 调度间隔时间：
	 * 调度周期为分钟时，间隔时间单位为分钟；调度周期为小时时，间隔时间单位为小时；其他调度周期没有该参数
	 */
	private Integer intervalTime;
	/**
	 * 指定指定时间：
	 * 小时：0-24
	 * 周：周一-周日
	 * 月：1-31
	 */
	private List<String> specifyTime;

}
