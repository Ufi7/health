package com.fc.exch.model;
/**
 * 交接班设置
 * @author 98408
 *
 */
public class ExchSetting {

	/**
	 * 值班时间间隔24小时
	 */
	private int exchSpace = 24;
	
	/**
	 * 默认8点开始
	 */
	private String beginTime = "8:00";
	
	//默认新入院病人显示，病危病重，手术病人术后2天显示
	private String showConditons = "xry;bw;bz;ssbr=2";

	public int getExchSpace() {
		return exchSpace;
	}

	public void setExchSpace(int exchSpace) {
		this.exchSpace = exchSpace;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getShowConditons() {
		return showConditons;
	}

	public void setShowConditons(String showConditons) {
		this.showConditons = showConditons;
	}
	
	
	
}
