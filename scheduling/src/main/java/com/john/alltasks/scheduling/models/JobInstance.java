package com.john.alltasks.scheduling.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class JobInstance implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 作业实例编号
	 */
	private Long id;
	/**
	 * 作业编号
	 */
	private Long jobId;	
	/**
	 * 触发时间
	 */
	private Date triggerTime;
	/**
	 * 作业实例结束时间
	 */
	private Date finishTime;
	/**
	 * 执行任务的服务器
	 */
	private String runServer;
	/**
	 * 作业实例当前状态：
	 * 0-未触发
	 * 1-触发，但被阻塞
	 * 2-执行中
	 * 3-执行被中断
	 * 4-执行完成
	 */
	private String status;
	/**
	 * 作业实例执行结果：只有执行完成后有结果
	 * 0-执行失败
	 * 1-执行成功
	 */
	private String result;
	/**
	 * 作业实例完成进度
	 */
	private Double finishRatio;

}
