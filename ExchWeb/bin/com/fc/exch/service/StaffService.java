package com.fc.exch.service;

import com.fc.core.model.PagedList;
import com.fc.exch.model.Patient;
import com.fc.exch.model.UserEntity;

/**
 * 护士信息管理service
 */
public interface StaffService {

	//获取护士管理信息列表
	PagedList getStaffList(PagedList pagedList, UserEntity user);

	//获取护士管理的病人信息列表
	PagedList getPatientList(PagedList pagedList, String userSysId, String hosType, Patient patient);
	
	void saveStaff(UserEntity user);
	
	//根据用户ID获取用户信息
	UserEntity getUserByUserSysId(String userSysId);
	
	//判断当前登录用户是否交接人
	Boolean isHandoverUser(String userSysId);

	
	
	/*//获取科室信息列表
	List<Dept> getDeptList();*/
}
