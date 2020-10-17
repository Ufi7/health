package com.fc.exch.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fc.core.model.PagedList;
import com.fc.exch.model.Exchange;
import com.fc.exch.model.ExchangeDetail;
import com.fc.exch.model.Patient;

public interface ExchangeService {
	
	public PagedList getExchangeList(PagedList pl, String dept_sys_code);
	
	public Exchange getExchangeById(String exchangeId);
	
	public List getExchangeTargetList(String dept_code);
	
	public List getExchangeTeamplateList(String exchangeTargetUserId);
	
	public Exchange newExchange(Date date, String jbhs1, String jbhsid1,  String jbhsid2,  String deptCode, String templatedId);
	
	public PagedList getSelectablePatientList(PagedList pl, String dept_code, String exchangeId);
	
	public List getExchangeDetailListByExchangeId(String exchangeId);
	
	public ExchangeDetail getExchangeDetailListByExchangeDetailId(String exchangeDetailId);
	
	public Object updateExchangeDetailItem(String exchangeId, String exchangeDetailId, String[] field, String[] value);
	
	public Patient getPatienByZYH(String c_zyh);
	
	public ExchangeDetail newExchangeDetail(String exchangeId, Patient p, String c_dept_code);
	
	public Object updateStatis(String exchangeId);
	
	public Object exStatusUpdate(String exchangeId, String targetStatus, String comment, String userId) throws Exception;
	
	public ExchangeDetail saveExchangeDetailItem(ExchangeDetail ed);
	
	public Map getPatientHistory(String patientId);
}
