package com.fc.exch.dao;

import org.springframework.stereotype.Repository;

import com.fc.core.dao.hibernate.genericdao.impl.HBaseDao;

@Repository
public class DetailInfoDao extends HBaseDao{

	public void delDetailInfoByZyh(String zyh) {
		String sql = "delete from t_detail_info WHERE c_zyh = ?";
		this.executeSql(sql, zyh);
	}
	
}
