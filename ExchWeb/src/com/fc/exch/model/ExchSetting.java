package com.fc.exch.model;
/**
 * ���Ӱ�����
 * @author 98408
 *
 */
public class ExchSetting {

	/**
	 * ֵ��ʱ����24Сʱ
	 */
	private int exchSpace = 24;
	
	/**
	 * Ĭ��8�㿪ʼ
	 */
	private String beginTime = "8:00";
	
	//Ĭ������Ժ������ʾ����Σ���أ�������������2����ʾ
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
