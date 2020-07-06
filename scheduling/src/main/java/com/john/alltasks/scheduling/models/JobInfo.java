package com.john.alltasks.scheduling.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 作业的元素据信息
 * @author 80854
 */
@Data
public class JobInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 自定义表的job编号
	 */
	private Long id;
	/**
	 * 作业名
	 */
	private String jobName;
	/**
	 * 作业组
	 */
	private String jobGroup;
	/**
	 * 如果用户使用界面形式填写作业周期
	 */
	private CronInfo cronInfo;
	/**
	 * 作业的执行cron表达式
	 */
	private String cronExpress;
	/**
	 * 该作业是否上线：
	 * 0-未上线
	 * 1-上线
	 */
	private String isOnline;
	/**
	 * 作业状态：0-暂停，1-正常
	 */
	private String jobStatus;
	/**
	 * 作业Owner
	 */
	private String owner;
	/**
	 * 作业描述
	 */
	private String description;
	/**
	 * 作业创建时间
	 */
	private Date createTime;
	/**
	 * 作业更新时间
	 */
	private Date updateTime;
	/**
	 * 操作员
	 */
	private String operator;
		

}

