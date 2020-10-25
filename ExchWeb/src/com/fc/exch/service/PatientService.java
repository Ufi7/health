package com.fc.exch.service;

import java.util.List;

import com.fc.core.model.PagedList;
import com.fc.exch.model.Patient;
import com.fc.sysmanager.login.bean.UserInfo;
import com.fc.sysmanager.model.Dept;

/**
 * 病人信息管理service
 */
public interface PatientService {

	//获取病人管理信息列表
	PagedList getPatientList(PagedList pagedList, Patient patient, UserInfo user);

	//根据角色类型获取用户信息
	List<UserInfo> getUserListByHosType(String hosType);

	//根据住院号获取病人
	Patient getPatientByZyh(String zyh);
	
	//获取科室信息列表
	List<Dept> getDeptList();
	
	void savePatient(Patient patient);
	
	void delPatient(Patient patient);
	
}
