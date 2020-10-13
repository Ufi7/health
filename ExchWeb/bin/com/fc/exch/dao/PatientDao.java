package com.fc.exch.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fc.core.dao.hibernate.genericdao.impl.HBaseDao;
import com.fc.core.model.PagedList;
import com.fc.exch.model.Patient;
import com.fc.sysmanager.login.bean.UserInfo;
import com.fc.sysmanager.model.Dept;

import nst.report.jasper.util.DataDealUtil;

@Repository
public class PatientDao extends HBaseDao{

	public PagedList getPatientList(PagedList pagedList,Patient patient,UserInfo user) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM( ");
		sql.append(" SELECT t.c_ch,t.c_zyh as zyh,t.c_brxm,TIMESTAMPDIFF(YEAR,t.c_csrq,CURDATE()),t.c_xb,t.c_rysj,t.c_zyzd,t.c_brzt,d.c_bqdj,d.c_hldj,u1.C_USER_NAME as zbys,u2.C_USER_NAME as zbhs FROM t_patient t ");
		sql.append(" LEFT JOIN t_detail_info d ON d.c_zyh = t.c_zyh ");
		sql.append(" LEFT JOIN t_user u1 ON u1.C_USER_ID = t.c_zbysid ");
		sql.append(" LEFT JOIN t_user u2 ON u2.C_USER_ID = t.c_zbhsid ");
		sql.append(" where 1=1 ");	
		/*if("8".equals(user.getHosType())){
			sql.append(" t.c_zbysid = '" + user.getUserSysId() + "'");
		}else if("9".equals(user.getHosType())){
			sql.append(" t.c_zbhsid = '" + user.getUserSysId() + "'");
		}*/
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
		sql.append(" ORDER BY d.c_insert_time DESC ) a GROUP BY a.zyh ");
		String queryCountStr = "select count(*) from ( "+sql+") a ";
		return this.getPagedListSql(queryCountStr, sql.toString(), pagedList);
	}
	
	public List<UserInfo> getUserListByHosType(String hosType){
		String sql = "SELECT * FROM t_user WHERE C_HOS_TYPE = ? AND C_FLAG = 1";
		return this.querySql(sql, hosType);
	}
	
	public Patient getPatientByZyh(String zyh){
		String sql = "FROM Patient WHERE c_zyh = ?";
		List list = this.queryHql(sql, new Object[]{zyh});
		if (list.size()>0)
			return (Patient) list.get(0) ;
		else
			return null;
	}
	
	public List<Dept> getDeptList(){
		String sql = "SELECT * FROM t_dept WHERE LENGTH(C_SYS_CODE)>4 ";
		return this.querySql(sql);
	}
}
