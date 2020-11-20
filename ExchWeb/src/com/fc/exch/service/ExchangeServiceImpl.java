package com.fc.exch.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fc.core.dao.hibernate.genericdao.impl.HCommonDao;
import com.fc.core.model.PagedList;
import com.fc.exch.model.Department;
import com.fc.exch.model.ExConstants;
import com.fc.exch.model.Exchange;
import com.fc.exch.model.ExchangeDetail;
import com.fc.exch.model.ExchangeDetailWithDate;
import com.fc.exch.model.Patient0;


import bsh.org.objectweb.asm.Constants;
import net.sf.json.JSONObject;
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
	
	public List getUserList(String dept_code, String type_code, String excludeId){
		String queryStr = "select c_user_id, c_user_name from t_user where C_dept_id = ? and C_HOS_TYPE = ? and c_user_id != ?";
		return hdao.querySql(queryStr, dept_code, type_code, excludeId);
	}

	@Override
	public List getExchangeTeamplateList(String exchangeTargetUserId) {
		String queryStr = "select exch.c_exch_id, exch.c_jbrq, dept.C_DEPT_NAME  from t_exchange exch, t_dept dept where exch.c_dept_code = dept.c_dept_id and exch.c_status='11' and exch.c_jbhsid2='"+exchangeTargetUserId+"' order by exch.c_jbrq DESC limit 10";
		return hdao.querySql(queryStr);
	}
	
	public final static String GET_USERNAME_BY_USERID_SQL = "select c_user_name from t_user where c_user_id = ?";

	@Override
	@Transactional 
	public Exchange newExchange(Date date, String jbhs1, String jbhsid1,  String jbhsid2, String deptCode, String exchangeOwenrDoctorUserId, String exchangeDoctorUserId, String templatedId) {
		// TODO Auto-generated method stub
		
		String jbhs2 = null, jbys=null, jbys2 = null;
		
		if(StringUtils.isNotBlank(jbhsid2)){
			List usernameList = hdao.querySql(GET_USERNAME_BY_USERID_SQL, jbhsid2);
			jbhs2 = (String)usernameList.get(0);
		}
		
		if(StringUtils.isNotBlank(templatedId)){
			List usernameList2 = hdao.querySql(GET_USERNAME_BY_USERID_SQL, exchangeOwenrDoctorUserId);
			jbys = (String)usernameList2.get(0);
		}
		
		if(StringUtils.isNotBlank(exchangeDoctorUserId)){
			List usernameList3 = hdao.querySql(GET_USERNAME_BY_USERID_SQL, exchangeDoctorUserId);
			jbys2 = (String)usernameList3.get(0);
		}
		
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
			ex.setC_jbys(oldEx.getC_jbys2());
			ex.setC_jbysid(oldEx.getC_jbysid2());
		}else{
			ex = new Exchange();
			ex.setC_yjsbzt("");
			ex.setExchangeId(UUID.randomUUID().toString());
			ex.setC_jbys(jbys);
			ex.setC_jbysid(exchangeOwenrDoctorUserId);
			
			//to add patient which belongs to operator
			//list patient 1st
			String hql1 = "From Patient0 p where p.c_zbhsid = ? and p.c_gbbz=0";
			List<Patient0> list = hdao.queryHql(hql1, jbhsid1);
			for(Patient0 p:list){
				ExchangeDetailWithDate exdd = loadHistoryExchangeDetail(p);
				if(exdd == null){
					newList.add(newEmptyExchangeDetail(ex.getExchangeId(), p, deptCode));
				}else{
					if((date.getTime()/(1000*60*60*24)) > (exdd.getC_exch_id().getC_jbrq().getTime()/(1000*60*60*24))){
						newList.add(this.cloneHistoryExchangeDetail(exdd, ex.getExchangeId()));
					}else{
						//skip, records already in another exchange
						continue;
					}
				}

//				String hql2 = "From ExchangeDetailWithDate ed where ed.c_zyh = ? and ed.c_status=? ORDER BY ed.c_exch_id.c_jbrq DESC";
//				Query q = hdao.getSession().createQuery(hql2);
//				q.setParameter(0, p.getC_zyh());
//				q.setParameter(1, ExConstants.EXCHANGE_STATUS_SUBMITTED_10);
//				q.setMaxResults(1);
//				List<ExchangeDetailWithDate> list1 = q.list();
//				if(list1.size()>0){
//					ExchangeDetailWithDate exdd = list1.get(0);
//					if((date.getTime()/(1000*60*60*24)) > (exdd.getC_exch_id().getC_jbrq().getTime()/(1000*60*60*24))){
//						//clone item
//						ExchangeDetail newexd = (ExchangeDetail)hdao.getEntity(ExchangeDetail.class, exdd.getExchangeDetailId()).clone();
//						newexd.setC_insert_time(new Date());
//						if(newexd.getC_zr()>0){
//							newexd.setC_zr(0);
//						}
//						if(newexd.getC_xry()>0){
//							newexd.setC_xry(0);
//						}
//						newexd.setC_exch_id(ex.getExchangeId());
//						newexd.setExchangeDetailId(UUID.randomUUID().toString());
//						newList.add(newexd);
//					}else{
//						//skip, records already in another exchange
//						continue;
//					}
//				}else{
//					//new item
//					newList.add(newExchangeDetail(ex.getExchangeId(), p, deptCode));
//				}
			}
			
		}
		ex.setC_jbrq(date);
		ex.setC_jbhsid(jbhsid1);
		ex.setC_jbhs(jbhs1);
		ex.setC_jbhsid2(jbhsid2);
		ex.setC_jbhs2(jbhs2);
		ex.setC_jbysid2(exchangeDoctorUserId);
		ex.setC_jbys2(jbys2);
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
		ExchangeDetailWithDate exdd = loadHistoryExchangeDetail(p);
		ExchangeDetail newed;
		if(exdd == null){
			newed = newEmptyExchangeDetail(exchangeId,  p,  c_dept_code);
		}else{
			newed = cloneHistoryExchangeDetail(exdd, exchangeId);
		}
		return (ExchangeDetail)hdao.saveEntity(newed);
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
	
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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
				System.out.println(ed.getC_jsonstr());
				JSONObject jsonstr = JSONObject.fromObject(ed.getC_jsonstr());
				if(ed.getC_sw()>0){
					//死亡 或 出院 关闭状态
					if(jsonstr != null){
						p.setC_swsj(sdf.parse(jsonstr.getString("c_swsj")));
						p.setC_swyy(jsonstr.getString("c_swyy"));
						p.setC_qjcs(jsonstr.getString("c_qjcs"));
					}		
					p.setC_gbbz(1);
				}else if(ed.getC_cy()>0){
					if(jsonstr != null){
						p.setC_cysj(sdf.parse(jsonstr.getString("c_cysj")));
						p.setC_bmid(jsonstr.getString("c_cylx"));
					}
					p.setC_gbbz(1);
				}else if(ed.getC_zc()>0){
					//转出 清空部门ID
					if(jsonstr != null){
						p.setC_zrrq(jsonstr.getString("c_zrrq"));
						p.setC_bmid(jsonstr.getString("c_bmid"));
					}
					p.setC_ybmid(p.getC_bmid());
				}else{
					p.setC_zbhsid(operatorUserId);
					List usernameList = hdao.querySql(GET_USERNAME_BY_USERID_SQL, operatorUserId);
					String jbhs = (String)usernameList.get(0);
					p.setC_zbhs(jbhs);
					p.setC_zbys(ex.getC_jbys2());
					p.setC_zbysid(ex.getC_jbysid2());
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
		
		String hql = "From ExchangeDetailWithDate ed where ed.c_zyh = ? and ed.c_exch_id.c_status=? ORDER BY ed.c_exch_id.c_jbrq DESC";
		List edList = hdao.queryHql(hql, p.getC_zyh(), ExConstants.EXCHANGE_STATUS_SUBMITTED_10);
		
		Map retMap = new HashMap();
		retMap.put("patient", p);
		retMap.put("list", edList);
		return retMap;
	}
	
	public int addPatientByChList(String dept_code, String listStr, String exchangeId){
		String hql = "From Patient0 p where p.c_ch in ("+listStr+") and p.c_gbbz = 0 and p.c_bmid='"+ dept_code +"' and p.c_zyh not in (select ed.patient.c_zyh from ExchangeDetail ed where ed.c_exch_id = '"+ exchangeId +"')";
		List<Patient0> plist = hdao.queryHql(hql);
		for(Patient0 p: plist){
			newExchangeDetail(exchangeId, p, dept_code);
		}
		return plist.size();
	}
	
	
	private ExchangeDetail newEmptyExchangeDetail(String exchangeId, Patient0 p, String c_dept_code){
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
		return ed;
	}
	
	private ExchangeDetailWithDate loadHistoryExchangeDetail(Patient0 p){
		String hql2 = "From ExchangeDetailWithDate ed where ed.c_zyh = ? and ed.c_exch_id.c_status=? ORDER BY ed.c_exch_id.c_jbrq DESC";
		Query q = hdao.getSession().createQuery(hql2);
		q.setParameter(0, p.getC_zyh());
		q.setParameter(1, ExConstants.EXCHANGE_STATUS_SUBMITTED_10);
		q.setMaxResults(1);
		List<ExchangeDetailWithDate> list1 = q.list();
		if(list1.size()>0){
			return  list1.get(0);
//			if((date.getTime()/(1000*60*60*24)) > (exdd.getC_exch_id().getC_jbrq().getTime()/(1000*60*60*24))){
//				//clone item
//				ExchangeDetail newexd = (ExchangeDetail)hdao.getEntity(ExchangeDetail.class, exdd.getExchangeDetailId()).clone();
//				newexd.setC_insert_time(new Date());
//				if(newexd.getC_zr()>0){
//					newexd.setC_zr(0);
//				}
//				if(newexd.getC_xry()>0){
//					newexd.setC_xry(0);
//				}
//				newexd.setC_exch_id(ex.getExchangeId());
//				newexd.setExchangeDetailId(UUID.randomUUID().toString());
//				newList.add(newexd);
//			}else{
//				//skip, records already in another exchange
//				continue;
//			}
		}else{
			return null;
		}
	}
	
	private ExchangeDetail cloneHistoryExchangeDetail(ExchangeDetailWithDate exdd, String newExchangeId){
		ExchangeDetail newexd =   (ExchangeDetail)hdao.getEntity(ExchangeDetail.class, exdd.getExchangeDetailId()).clone();
		newexd.setC_insert_time(new Date());
		if(newexd.getC_zr()>0){
			newexd.setC_zr(0);
		}
		if(newexd.getC_xry()>0){
			newexd.setC_xry(0);
		}
		newexd.setC_exch_id(newExchangeId);
		newexd.setExchangeDetailId(UUID.randomUUID().toString());
		return newexd;
	}

	@Override
	public Integer updateExchangeDate(String exchangeId, String dateStr) {
		String sql = "update t_exchange set c_jbrq = ? where c_exch_id = ? and (c_status='00' or c_status='01')";
		return (Integer)hdao.executeSql(sql, dateStr, exchangeId);
	}

	@Override
	public Integer updateExchangeRelatedUser(String exchangeId, String roleid, String userId) throws Exception {
		String role = "";
		if("c_jbhsid2".equals(roleid)){
			role = "c_jbhs2";
		}else if("c_jbysid".equals(roleid)){
			role = "c_jbys";
		}else if("c_jbysid2".equals(roleid)){
			role = "c_jbys2";
		}else{
			throw new Exception("非法操作！字段名不正确！");
		}
		String sql = "update t_exchange set "+ role +" = (SELECT c_user_name FROM t_user where c_user_id = ?), "+ roleid +" = ? " +
						"where c_exch_id = ? and (c_status='00' or c_status='01')";
		return (Integer)hdao.executeSql(sql, userId, userId, exchangeId);
	}

	@Override
	public Integer remvoeExchagneDetail(String exchangeId, String exchangeDetailId) {
		String sql = "DELETE FROM t_detail_info WHERE detail_info_id = ? and c_exch_id = ?";
		return (Integer)hdao.executeSql(sql, exchangeDetailId, exchangeId);
	}

	@Override
	public List<Exchange> getRecentDraftExchangeByUser(String userId) throws ParseException {
		LocalDateTime ldt0 = LocalDateTime.now();
		LocalDateTime ldt1 = LocalDateTime.now().plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
		// TODO Auto-generated method stub
		String hql = "from Exchange ex where ex.c_jbhsid=? and (ex.c_status = '00' or ex.c_status='01') and ex.c_jbrq between ? and ? ";
		return hdao.queryHql(hql,  userId, sdf.parse(formatter.format(ldt0)), sdf.parse(formatter.format(ldt1)));
	}

	@Override
	public List<Department> getOtherDeptList(String dept_code) {
		String hql = "from Department d where d.deptId != ?";
		return hdao.queryHql(hql,dept_code);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Integer deleteDraftExchangeByCreator(String exchangeId, String userId) throws Exception {
		// TODO Auto-generated method stub
		String sql1 = "delete from t_detail_info where c_exch_id=?";
		String sql2 = "delete from t_exchange where c_exch_id=? and (c_status = '00' or c_status='01') and c_jbhsid=?";
		hdao.executeSql(sql1, exchangeId);
		Integer ret = (Integer)hdao.executeSql(sql2, exchangeId, userId);
		if(ret==0){
			throw new RuntimeException("非法操作，交班状态或已改变");
		}
		return ret;
	}
}
