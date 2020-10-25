package com.fc.exch.dao;

import org.springframework.stereotype.Repository;

import com.fc.core.dao.hibernate.genericdao.impl.HBaseDao;
import com.fc.core.model.PagedList;
import com.fc.exch.model.ExchangeEntity;

import nst.report.jasper.util.DataDealUtil;

@Repository
public class HandoverDao extends HBaseDao{
	
	public PagedList getHandoverList(PagedList pagedList,ExchangeEntity exchange, String userId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT t.c_exch_id, t.c_jbrq, t.c_jbhs,t.c_jbhs2,CONCAT_WS('/',t.c_yybrs,t.c_xybrs),t.c_swbrs, ");
		sql.append(" CONCAT_WS('/',t.c_bwrs,t.c_bzrs),t.c_yjhl,CONCAT_WS('/',t.c_ssbr,t.c_nssbr),t.c_qfyj,t.c_zdtt, ");
		sql.append(" t.c_gcjlgj,CONCAT_WS('/',t.c_tsjc,t.c_tszl),t.c_fyc,t.c_sjmzg,t.c_wjzbg,t.c_dcnyx,t.c_blsj,t.c_status,t.c_dept_code  ");
		sql.append(" FROM t_exchange t ");
		sql.append(" where 1=1 AND (t.c_jbhsid = '"+userId+"' OR t.c_jbhsid2 = '" + userId + "') " );	
		if(!DataDealUtil.stringIsEmpty(exchange.getStatus())){
			sql.append(" AND t.c_status = '"+ exchange.getStatus()  +"'");
		}
		if(!DataDealUtil.stringIsEmpty(exchange.getJbrqBegin())){
			sql.append(" AND t.c_jbrq >= '"+ exchange.getJbrqBegin()  +"'");
		}
		if(!DataDealUtil.stringIsEmpty(exchange.getJbrqEnd())){
			sql.append(" AND t.c_jbrq <= '"+ exchange.getJbrqEnd()  +"'");
		}
		if(!DataDealUtil.stringIsEmpty(exchange.getDeptCode())){
			sql.append(" AND t.c_dept_code = '"+ exchange.getDeptCode() +"'");
		}
		if(!DataDealUtil.stringIsEmpty(exchange.getJbhs())){
			sql.append(" AND t.c_jbhs like '%"+ exchange.getJbhs() + "%'" );
		}
		if(!DataDealUtil.stringIsEmpty(exchange.getJbhs2())){
			sql.append(" AND t.c_jbhs2 LIKE '%"+ exchange.getJbhs2()  +"%'");
		}
		String queryCountStr = "select count(*) from ( "+sql+") a ";
		return this.getPagedListSql(queryCountStr, sql.toString(), pagedList);
	}
}
