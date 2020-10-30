package com.fc.exch.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fc.core.dao.hibernate.genericdao.impl.HCommonDao;
import com.fc.core.model.PagedList;
import com.fc.exch.model.ExConstants;
import com.fc.exch.model.Exchange;
import com.fc.exch.model.ExchangeDetail;
import com.fc.exch.model.Patient0;

import bsh.org.objectweb.asm.Constants;
@Service
@Transactional
public class ExchangeServiceImpl implements ExchangeService {
	
	@Autowired
	private HCommonDao hdao;

	@Override
	public PagedList getExchangeList(PagedList pl, String dept_sys_code) {
		
		String sql = "SELECT t_exchange.c_exch_id, t_exchange.c_jbrq, t_exchange.c_jbhs,t_exchange.c_jbhs2, concat(t_exchange.c_yybrs, '/', t_exchange.c_xybrs), t_exchange.c_swbrs,  concat(t_exchange.c_bwrs, '/', t_exchange.c_bzrs), t_exchange.c_yjhl, concat(t_exchange.c_ssbr, '/', t_exchange.c_nssbr), t_exchange.c_qfyj,  t_exchange.c_zdtt, t_exchange.c_gcjlgj, concat(t_exchange.c_tsjc,'/',t_exchange.c_tszl), t_exchange.c_fyc, t_exchange.c_sjmzg, t_exchange.c_wjzbg, t_exchange.c_dcnyx, t_exchange.c_blsj,t_exchange.c_status, t_exchange.c_jbhsid, t_exchange.c_jbhsid2 FROM t_exchange where c_dept_code in (select c_dept_id from t_dept where INSTR ( c_sys_code , '"+dept_sys_code+"') > 0) ORDER BY t_exchange.c_jbrq DESC";
		String csql = "SELECT count(*) FROM t_exchange where c_dept_code in (select c_dept_id from t_dept where INSTR ( c_sys_code , '"+dept_sys_code+"') > 0)";
		return hdao.getPagedListSql(csql, sql, pl);
	}

	@Override
	public Exchange getExchangeById(String exchangeId) {
		return hdao.getEntity(Exchange.class, exchangeId);
	}

	@Override
	public List getExchangeTargetList(String dept_code) {
		String queryStr = "select c_user_id, c_user_name from t_user where C_dept_id = '"+dept_code+"'";
		return hdao.querySql(queryStr);
	}

	@Override
	public List getExchangeTeamplateList(String exchangeTargetUserId) {
		String queryStr = "select exch.c_exch_id, exch.c_jbrq, dept.C_DEPT_NAME  from t_exchange exch, t_dept dept where exch.c_dept_code = dept.c_dept_id and exch.c_status='11' and exch.c_jbhsid2='"+exchangeTargetUserId+"' order by exch.c_jbrq DESC limit 10";
		return hdao.querySql(queryStr);
	}
	
	public final static String GET_USERNAME_BY_USERID_SQL = "select c_user_name from t_user where c_user_id = ?";

	@Override
	public Exchange newExchange(Date date, String jbhs1, String jbhsid1,  String jbhsid2, String deptCode, String templatedId) {
		// TODO Auto-generated method stub
		
		List usernameList = hdao.querySql(GET_USERNAME_BY_USERID_SQL, jbhsid2);
		String jbhs2 = (String)usernameList.get(0);
		
		Exchange ex;
		List<ExchangeDetail> newList = new ArrayList();
		
		if(StringUtils.isNotBlank(templatedId)){
			//TODO: 复制exchange logic
			Exchange oldEx = hdao.getEntity(Exchange.class, templatedId);
			ex = (Exchange)oldEx.clone();
			String newId = UUID.randomUUID().toString();
			ex.setExchangeId(newId);
			
			List<ExchangeDetail> exDtList = getExchangeDetailListByExchangeId(templatedId);
			for(ExchangeDetail exd:exDtList){
				if(exd.getC_sw()>0 || exd.getC_cy()>0 ||exd.getC_zc()>0){
					//can be ignore...
					continue;
				}
				ExchangeDetail newexd = (ExchangeDetail)exd.clone();
				newexd.setC_insert_time(new Date());
				if(newexd.getC_zr()>0){
					newexd.setC_zr(0);
				}
				if(newexd.getC_xry()>0){
					newexd.setC_xry(0);
				}
				newexd.setC_exch_id(newId);
				newexd.setExchangeDetailId(UUID.randomUUID().toString());
				newList.add(newexd);
			}
		}else{
			ex = new Exchange();
			ex.setC_yjsbzt("");
			ex.setExchangeId(UUID.randomUUID().toString());
		}
		ex.setC_jbrq(date);
		ex.setC_jbhsid(jbhsid1);
		ex.setC_jbhs(jbhs1);
		ex.setC_jbhsid2(jbhsid2);
		ex.setC_jbhs2(jbhs2);
		ex.setC_dept_code(deptCode);
		ex.setC_status("00");
		
		hdao.saveEntity(ex);
		for(ExchangeDetail exd:newList){
			hdao.saveEntity(exd);
		}
		
		return ex;
	}

	@Override
	public PagedList getSelectablePatientList(PagedList pl, String dept_code, String exchangeId) {
		// TODO Auto-generated method stub
		String sql = "select p.c_zyh, p.c_ch, p.c_zyh, p.c_brxm, p.c_xb, p.c_brzt, p.c_ybmid from t_patient p where p.c_gbbz = 0 and p.c_bmid='"+ dept_code +"' and p.c_zyh not in (select c_zyh from t_detail_info where c_exch_id = '"+ exchangeId +"') ORDER BY p.c_ch ASC";
		String csql = "SELECT count(*) from t_patient p where p.c_gbbz = 0 and p.c_bmid='"+ dept_code+"' and p.c_zyh not in (select c_zyh from t_detail_info where c_exch_id = '"+ exchangeId +"')";
		return hdao.getPagedListSql(csql, sql, pl);
	}

	@Override
	public List getExchangeDetailListByExchangeId(String exchangeId) {
		String hql = "From ExchangeDetail ed where ed.c_exch_id = ? ORDER BY ed.patient.c_ch ASC";
		return hdao.queryHql(hql, exchangeId);
	}

	@Override
	public Object updateExchangeDetailItem(String exchangeId, String exchangeDetailId, String[] fields, String[] values) {
		String sql = "update t_detail_info set";
		for(int i=0;i<fields.length;i++){
			sql = sql + " "+ fields[i] + "='"+values[i]+"',";
		}
		sql = sql.substring(0, sql.length()-1);
		sql = sql + "where detail_info_id='"+exchangeDetailId + "' and c_exch_id='"+ exchangeId+"'";
		return hdao.executeSql(sql);
	}

	@Override
	public Patient0 getPatienByZYH(String c_zyh) {
		String hql = "From Patient0 p where p.c_zyh = ?";
		List list =  hdao.queryHql(hql, c_zyh);
		if(list.size()==0){
			return null;
		}else{
			return (Patient0)list.get(0);
		}
		
	}

	@Override
	public ExchangeDetail newExchangeDetail(String exchangeId, Patient0 p, String c_dept_code) {
		ExchangeDetail ed = new ExchangeDetail();
		ed.setC_insert_time(new Date());
		ed.setPatient(p);
		if(StringUtils.isNotEmpty(p.getC_ybmid())){
			ed.setC_zr(1);
		}else{
			ed.setC_xry(1);
		}
		ed.setC_exch_id(exchangeId);
		ed.setExchangeDetailId(UUID.randomUUID().toString());
		ed.setC_dept_code(c_dept_code);
		ed.setC_status("");
		return (ExchangeDetail)hdao.saveEntity(ed);
	}

	@Override
	public Object updateStatis(String exchangeId) {
		String sql = "update t_exchange ex "+
				"Cross Join "+
				"(select count(*) - count(if(c_cy>0,1, null)) - count(if(c_zc>0,1, null)) - count(if(c_sw>0,1, null)) as  c1,  "+
				"count(*) - count(if(c_xry>0,1, null)) - count(if(c_zr>0,1, null)) as c2,  "+
				"count(if(c_xry>0,1, null)) as c_xry,  "+
				"count(if(c_zr>0,1, null)) as c_zr,  "+
				"count(if(c_cy>0,1, null)) as c_cy,  "+
				"count(if(c_zc>0,1, null)) as c_zc,  "+
				"count(if(c_sw>0,1, null)) as c_sw,  "+
				"count(if(c_bqdj=2,1, null)) as c_bqdj2,  "+
				"count(if(c_bqdj=1,1, null)) as c_bqdj1,  "+
				"count(if(c_hldj=1,1,null)) as c_hldj1,  "+
				"count(if(c_ssbr>0,1,null)) as c_ssbr,  "+
				"count(if(c_nssbr>0,1,null)) as c_nssbr,  "+
				"count(if(c_qfyj>0,1,null)) as c_qfyj,  "+
				"count(if(c_zdtt>0,1,null)) as c_zdtt,  "+
				"count(if(c_gcjlgj>0,1,null)) as c_gcjlgj,  "+
				"count(if(c_tsjc>0,1,null)) as c_tsjc,  "+
				"count(if(c_tszl>0,1,null)) as c_tszl,  "+
				"count(if(c_fyc>0,1,null)) as c_fyc ,  "+
				"count(if(c_fdt>0,1,null)) as c_fdt,  "+
				"count(if(c_sjmzg>0,1,null)) as c_sjmzg,  "+
				"count(if(c_wjzbg>0,1,null)) as c_wjzbg,  "+
				"count(if(c_dcnyx>0,1,null)) as c_dcnyx,  "+
				"count(if(c_blsj>0,1,null)) as c_blsj "+
				"from t_detail_info where c_exch_id =?) as statis "+
				"set ex.c_xybrs=statis. c1, "+
				"ex.c_yybrs=statis.c2, "+
				"ex.c_xrybr=statis.c_xry, "+
				"ex.c_zrbr=statis.c_zr, "+
				"ex.c_cybr=statis.c_cy, "+
				"ex.c_zcbr=statis.c_zc, "+
				"ex.c_swbrs=statis.c_sw, "+
				"ex.c_bwrs=statis.c_bqdj2, "+
				"ex.c_bzrs=statis.c_bqdj1, "+
				"ex.c_yjhl=statis.c_hldj1, "+
				"ex.c_ssbr=statis.c_ssbr, "+
				"ex.c_nssbr=statis.c_nssbr, "+
				"ex.c_qfyj=statis.c_qfyj, "+
				"ex.c_zdtt=statis.c_zdtt, "+
				"ex.c_gcjlgj=statis.c_gcjlgj, "+
				"ex.c_tsjc=statis.c_tsjc, "+
				"ex.c_tszl=statis.c_tszl, "+
				"ex.c_fyc=statis.c_fyc , "+
				"ex.c_fdt=statis.c_fdt, "+
				"ex.c_sjmzg=statis.c_sjmzg, "+
				"ex.c_wjzbg=statis.c_wjzbg, "+
				"ex.c_dcnyx=statis.c_dcnyx, "+
				"ex.c_blsj=statis.c_blsj "+
				"where c_exch_id=?; ";
		return hdao.executeSql(sql, exchangeId, exchangeId);
	}
	
	
	private final static String SQL_EXCHANGE_STATUS_UPDATE_SQL_1 = "UPDATE t_exchange set c_status = ? where c_status in (?, ?) and c_jbhsid = ? and c_exch_id = ?";
	private final static String SQL_EXCHANGE_STATUS_UPDATE_SQL_2 = "UPDATE t_exchange set c_status = ? where c_status = ? and (c_jbhsid =? or c_jbhsid2 = ?)  and c_exch_id = ?";
	private final static String SQL_EXCHANGE_STATUS_UPDATE_SQL_3 = "UPDATE t_exchange set c_status = ? where c_status = ? and c_jbhsid2 = ?  and c_exch_id = ?";
	private final static String SQL_EXCHANGE_STATUS_UPDATE_SQL_4 = "UPDATE t_exchange set c_status = ? where c_status != ?  and c_exch_id = ?";
	
	@Override
	public Object exStatusUpdate(String exchangeId, String targetStatus, String comment, String operatorUserId) throws Exception {
		Exchange ex = hdao.getEntity(Exchange.class, exchangeId);
		Object retObj = null;
		if( (ExConstants.EXCHANGE_STATUS_DRAFT_00.equals(ex.getC_status()) || ExConstants.EXCHANGE_STATUS_DRAWBACK_01.equals(ex.getC_status())) && ExConstants.EXCHANGE_STATUS_SUBMITTED_10.equals(targetStatus) && ex.getC_jbhsid().equals(operatorUserId) ){
			//for submit case
			//ex.setC_status(ExConstants.EXCHANGE_STATUS_SUBMITTED_10);
			retObj = hdao.executeSql(SQL_EXCHANGE_STATUS_UPDATE_SQL_1, ExConstants.EXCHANGE_STATUS_SUBMITTED_10, ExConstants.EXCHANGE_STATUS_DRAFT_00, ExConstants.EXCHANGE_STATUS_DRAWBACK_01, operatorUserId, exchangeId);
			
		}else if(ExConstants.EXCHANGE_STATUS_SUBMITTED_10.equals(ex.getC_status()) && ExConstants.EXCHANGE_STATUS_DRAWBACK_01.equals(targetStatus) && (ex.getC_jbhsid().equals(operatorUserId) ||ex.getC_jbhsid2().equals(operatorUserId))){
			//for drawback case
			//ex.setC_status(ExConstants.EXCHANGE_STATUS_DRAWBACK_01);
			retObj = hdao.executeSql(SQL_EXCHANGE_STATUS_UPDATE_SQL_2, ExConstants.EXCHANGE_STATUS_DRAWBACK_01, ExConstants.EXCHANGE_STATUS_SUBMITTED_10, operatorUserId, operatorUserId, exchangeId);
			//TODO: handle comments
			
		}else if(ExConstants.EXCHANGE_STATUS_SUBMITTED_10.equals(ex.getC_status()) && ExConstants.EXCHANGE_STATUS_FINALIZED_11.equals(targetStatus)  && ex.getC_jbhsid2().equals(operatorUserId)){
			//for accept case
			//ex.setC_status(ExConstants.EXCHANGE_STATUS_FINALIZED_11);
			retObj = hdao.executeSql(SQL_EXCHANGE_STATUS_UPDATE_SQL_3, ExConstants.EXCHANGE_STATUS_FINALIZED_11, ExConstants.EXCHANGE_STATUS_SUBMITTED_10, operatorUserId, exchangeId);
			//TODO: update patient status。。。。
			
		}else if(!ExConstants.EXCHANGE_STATUS_FINALIZED_11.equals(ex.getC_status()) && ExConstants.EXCHANGE_STATUS_INVALID_90.equals(targetStatus)){
			//for system to invalid expired ex case
			//ex.setC_status(ExConstants.EXCHANGE_STATUS_INVALID_90);
			retObj = hdao.executeSql(SQL_EXCHANGE_STATUS_UPDATE_SQL_4, ExConstants.EXCHANGE_STATUS_INVALID_90, ExConstants.EXCHANGE_STATUS_FINALIZED_11, operatorUserId, exchangeId);
		}else{
			throw new Exception("Invalid Operation...无效操作...validation fail");
		}
		
		Integer i = (Integer) retObj;
		if(i==0){
			throw new Exception("Invalid Operation...无效操作...对应交班信息状态或以改变，请尝试刷新后重新操作！");
		}
		
		if(ExConstants.EXCHANGE_STATUS_FINALIZED_11.equals(targetStatus) ){
			List<ExchangeDetail> edList = getExchangeDetailListByExchangeId(exchangeId);
			for(ExchangeDetail ed:edList){
				ed.setC_status(ExConstants.EXCHANGE_STATUS_SUBMITTED_10);
				Patient0 p = ed.getPatient();
				if(ed.getC_sw()>0 || ed.getC_cy()>0){
					//死亡 或 出院 关闭状态
					p.setC_gbbz(1);
				}else{
					p.setC_zbhsid(operatorUserId);
					List usernameList = hdao.querySql(GET_USERNAME_BY_USERID_SQL, operatorUserId);
					String jbhs = (String)usernameList.get(0);
					p.setC_zbhs(jbhs);
				}
				hdao.saveEntity(ed);
			}
		}
		
		return retObj;
	}

	@Override
	public ExchangeDetail getExchangeDetailListByExchangeDetailId(String exchangeDetailId) {
		return hdao.getEntity(ExchangeDetail.class, exchangeDetailId);
	}

	@Override
	public ExchangeDetail saveExchangeDetailItem(ExchangeDetail ed) {
		return (ExchangeDetail)hdao.saveEntity(ed);
	}

	@Override
	public Map getPatientHistory(String patientId) {
//		String hql = "From ExchangeDetailWithDate ed where ed.patient.patientId = ? and ed.c_status=? ORDER BY ed.c_exch_id.c_jbrq DESC";
//		return hdao.queryHql(hql, patientId, ExConstants.EXCHANGE_STATUS_SUBMITTED_10);
		
		Patient0 p = hdao.getEntity(Patient0.class, patientId);
		if(p == null){
			return null;
		}
		
//		String sql = "select ed.*, ex.c_jbrq from t_detail_info ed, t_exchange ex, t_patient p where ed.c_exch_id = ex.c_exch_id and ed.c_zyh = p.c_zyh and p.c_brid = ?";
//		List edList = hdao.querySql(sql, p.getPatientId());
		
		String hql = "From ExchangeDetailWithDate ed where ed.c_zyh = ? and ed.c_status=? ORDER BY ed.c_exch_id.c_jbrq DESC";
		List edList = hdao.queryHql(hql, p.getC_zyh(), ExConstants.EXCHANGE_STATUS_SUBMITTED_10);
		
		Map retMap = new HashMap();
		retMap.put("patient", p);
		retMap.put("list", edList);
		return retMap;
	}
	
	
}
