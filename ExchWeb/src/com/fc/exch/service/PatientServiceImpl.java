package com.fc.exch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fc.core.model.PagedList;
import com.fc.exch.dao.DetailInfoDao;
import com.fc.exch.dao.PatientDao;
import com.fc.exch.model.Patient;
import com.fc.sysmanager.login.bean.UserInfo;
import com.fc.sysmanager.model.Dept;

/**
 * 病人管理信息serviceImpl
 */
@Service
@Transactional
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDao patientDao;

	@Autowired
	private DetailInfoDao detailInfoDao;
	
	@Override
	public PagedList getPatientList(PagedList pagedList, Patient patient, UserInfo user) {
		return patientDao.getPatientList(pagedList, patient, user);
	}

	@Override
	public List<UserInfo> getUserListByHosType(String hosType) {
		return patientDao.getUserListByHosType(hosType);
	}

	@Override
	public Patient getPatientByZyh(String zyh) {
		return patientDao.getPatientByZyh(zyh);
	}

	@Override
	public List<Dept> getDeptList() {
		return patientDao.getDeptList();
	}

	@Override
	public void savePatient(Patient patient) {
		patientDao.saveEntity(patient);
	}
	
	@Override
	public void delPatient(Patient patient){
		patientDao.delete(patient);
		detailInfoDao.delDetailInfoByZyh(patient.getZyh());
	}
}
