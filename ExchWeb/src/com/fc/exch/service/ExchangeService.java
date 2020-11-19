package com.fc.exch.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fc.core.model.PagedList;
import com.fc.exch.model.Department;
import com.fc.exch.model.Exchange;
import com.fc.exch.model.ExchangeDetail;
import com.fc.exch.model.Patient0;


public interface ExchangeService {
	
	public PagedList getExchangeList(PagedList pl, String dept_sys_code);
	
	public Exchange getExchangeById(String exchangeId);
	
	public List getExchangeTargetList(String dept_code);
	
	public List getUserList(String dept_code, String type_code, String excludeId);
	
	public List getExchangeTeamplateList(String exchangeTargetUserId);
	
	public Exchange newExchange(Date date, String jbhs1, String jbhsid1,  String jbhsid2,  String deptCode,String exchangeOwenrDoctorUserId, String exchangeDoctorUserId,String templatedId);
	
	public PagedList getSelectablePatientList(PagedList pl, String dept_code, String exchangeId);
	
	public List getExchangeDetailListByExchangeId(String exchangeId);
	
	public ExchangeDetail getExchangeDetailListByExchangeDetailId(String exchangeDetailId);
	
	public Object updateExchangeDetailItem(String exchangeId, String exchangeDetailId, String[] field, String[] value);
	
	public Patient0 getPatienByZYH(String c_zyh);
	
	public ExchangeDetail newExchangeDetail(String exchangeId, Patient0 p, String c_dept_code);
	
	public Object updateStatis(String exchangeId);
	
	public Object exStatusUpdate(String exchangeId, String targetStatus, String comment, String userId) throws Exception;
	
	public ExchangeDetail saveExchangeDetailItem(ExchangeDetail ed);
	
	public Map getPatientHistory(String patientId);
	
	public int addPatientByChList(String dept_code, String listStr, String exchangeId);
	
	public Integer updateExchangeDate(String exchangeId, String dateStr);
	
	public Integer updateExchangeRelatedUser(String exchangeId, String roleid, String userId)throws Exception;
	
	public Integer remvoeExchagneDetail(String exchangeId, String exchangeDetailId);
	
	public List<Exchange> getRecentDraftExchangeByUser(String userId)throws ParseException;
	
	public List<Department> getOtherDeptList(String dept_code);
	
	public Integer deleteDraftExchangeByCreator(String exchangeId, String userId)throws Exception ;
}
