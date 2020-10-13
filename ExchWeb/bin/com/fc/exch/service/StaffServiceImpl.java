package com.fc.exch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fc.core.dao.hibernate.genericdao.impl.JdbcCommonDao;
import com.fc.core.model.PagedList;
import com.fc.exch.dao.StaffDao;
import com.fc.exch.model.Patient;
import com.fc.exch.model.UserEntity;

/**
 * 护士管理信息serviceImpl
 */
@Service
@Transactional
public class StaffServiceImpl implements StaffService{

	@Autowired
	private JdbcCommonDao commonDao;

	@Autowired
	private StaffDao staffDao;
	
	@Override
	public PagedList getStaffList(PagedList pagedList, UserEntity user) {
		return staffDao.getNurseList(pagedList, user);
	}

	@Override
	public void saveStaff(UserEntity user) {
		staffDao.saveEntity(user);
	}

	@Override
	public UserEntity getUserByUserSysId(String userId) {
		/*String sql = "select * from t_user where C_USER_ID = ?";
		String[] paras = new String[]{userSysId};
		List<Object> list = null;
		try {
			list = this.commonDao.querySql2TypeOrArray(sql, paras, UserEntity.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list.size() <= 0 ? null : (UserEntity) list.get(0);*/
		return staffDao.getUserByUserId(userId);
	}

	@Override
	public PagedList getPatientList(PagedList pagedList, String userSysId, String hosType, Patient patient) {
		return staffDao.getPatientList(pagedList, userSysId, hosType, patient);
	}

	@Override
	public Boolean isHandoverUser(String userSysId) {
		return staffDao.isHandoverUser(userSysId);
	}
	
}
