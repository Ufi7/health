package com.fc.exch.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fc.core.dao.hibernate.genericdao.impl.HBaseDao;
import com.fc.core.model.PagedList;
import com.fc.exch.model.Patient;
import com.fc.exch.model.UserEntity;

import nst.report.jasper.util.DataDealUtil;

@Repository
public class StaffDao extends HBaseDao{

	public PagedList getNurseList(PagedList pagedList,UserEntity user) {
		StringBuilder sql = new StringBuilder();
		if(!DataDealUtil.stringIsEmpty(user.getStatus())){
			sql.append(" SELECT * from ( ");
		}
		sql.append(" SELECT a.userId,a.userName,a.sex,a.zwzg,a.deptId,a.deptName,a.flag,a.status FROM( ");
		sql.append(" SELECT u.C_USER_ID AS userId,u.C_USER_NAME AS userName,u.C_SEX AS sex,u.C_POSITION AS zwzg,u.C_DEPT_ID AS deptId,d.C_DEPT_NAME AS deptName ,u.C_FLAG AS flag, ");
		sql.append(" CASE WHEN TO_DAYS(ex.c_jbrq) = TO_DAYS(NOW()) THEN 1 ELSE 0 END AS status ");
		sql.append(" FROM t_user u  ");
		sql.append(" LEFT JOIN t_dept d ON d.C_DEPT_ID = u.C_DEPT_ID ");
		sql.append(" LEFT JOIN t_exchange ex ON ex.c_jbhsid = u.C_USER_ID ");
		sql.append(" WHERE u.C_HOS_TYPE ='"+ user.getHosType() +"' ORDER BY ex.c_jbrq DESC) a ");
		sql.append(" where 1=1 ");	
		if(!DataDealUtil.stringIsEmpty(user.getDeptId())){
			sql.append(" AND a.deptId = '"+ user.getDeptId() +"'");
		}
		if(!DataDealUtil.stringIsEmpty(user.getUserName())){
			sql.append(" AND a.userName LIKE '%"+ user.getUserName() +"%'");
		}
		
		if(!DataDealUtil.stringIsEmpty(user.getPosition())){
			sql.append(" AND a.zwzg = '"+ user.getPosition() +"'");
		}
		sql.append(" GROUP BY a.userId ");
		if(!DataDealUtil.stringIsEmpty(user.getStatus())){
			sql.append(" ) b where b.status= " + user.getStatus());
		}
		String queryCountStr = "select count(*) from ( "+sql+") c ";
		return this.getPagedListSql(queryCountStr, sql.toString(), pagedList);
	}
	
	public PagedList getPatientList(PagedList pagedList, String userSysId, String hosType, Patient patient) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM( ");
		sql.append(" SELECT t.c_ch,t.c_zyh as zyh,t.c_brxm,TIMESTAMPDIFF(YEAR,t.c_csrq,CURDATE()),t.c_xb,t.c_rysj,t.c_zyzd,t.c_brzt,d.c_bqdj,d.c_hldj,u1.C_USER_NAME as zbys,u2.C_USER_NAME as zbhs FROM t_patient t ");
		sql.append(" LEFT JOIN t_detail_info d ON d.c_zyh = t.c_zyh ");
		sql.append(" LEFT JOIN t_user u1 ON u1.C_USER_ID = t.c_zbysid ");
		sql.append(" LEFT JOIN t_user u2 ON u2.C_USER_ID = t.c_zbhsid ");
		sql.append(" where 1=1 ");	
		if("8".equals(hosType)){
			sql.append(" AND t.c_zgysid = '" + userSysId + "'");
		}else if("9".equals(hosType)){
			sql.append(" AND t.c_zghsid = '" + userSysId + "'");
		}
		if(!DataDealUtil.stringIsEmpty(patient.getBrxm())){
			sql.append(" AND t.c_brxm LIKE '%"+ patient.getBrxm()  +"%'");
		}
		if(!DataDealUtil.stringIsEmpty(patient.getZyzd())){
			sql.append(" AND t.c_zyzd LIKE '%"+ patient.getZyzd()  +"%'");
		}
		if(!DataDealUtil.stringIsEmpty(patient.getZbys())){
			sql.append(" AND t.c_zbys LIKE '%"+ patient.getZbys()  +"%'");
		}
		if(patient.getBqdj()!=null){
			sql.append(" AND d.c_bqdj = "+ patient.getBqdj() );
		}
		if(!DataDealUtil.stringIsEmpty(patient.getBrzt())){
			sql.append(" AND t.c_brzt = "+ patient.getBrzt() );
		}
		if(!DataDealUtil.stringIsEmpty(patient.getZyys())){
			sql.append(" AND t.c_zyys LIKE '%"+ patient.getZyys()  +"%'");
		}
		if(!DataDealUtil.stringIsEmpty(patient.getZbhs())){
			sql.append(" AND t.c_zbhs LIKE '%"+ patient.getZbhs()  +"%'");
		}
		if(patient.getHldj()!=null){
			sql.append(" AND d.c_hldj = "+ patient.getHldj() );
		}
		sql.append(" ORDER BY d.c_insert_time, t.c_rysj DESC ) a GROUP BY a.zyh ");
		String queryCountStr = "select count(*) from ( "+sql+") a ";
		return this.getPagedListSql(queryCountStr, sql.toString(), pagedList);
	}

	public Boolean isHandoverUser(String userSysId) {
		String sql = "select * from t_exchange where c_jbhsid = ? and TO_DAYS(c_jbrq) = TO_DAYS(NOW())";
		List list = this.querySql(sql, userSysId);
		return list.size() <= 0 ? false : true;
	}
	
	public UserEntity getUserByUserId(String userId) {
		String sql = "FROM UserEntity WHERE C_USER_ID = ?";
		List list = this.queryHql(sql, new Object[]{userId});
		if (list.size()>0)
			return (UserEntity) list.get(0) ;
		else
			return null;
	}
	
}
