package com.ml.exch.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.core.model.PagedList;
import com.fc.exch.model.Department;
import com.fc.exch.model.ExConstants;
import com.fc.exch.model.Exchange;
import com.fc.exch.model.ExchangeDetail;
import com.fc.exch.model.Patient0;
import com.fc.exch.service.ExchangeService;
import com.fc.exch.service.RefreshExchangeStatisThread;
import com.fc.sysmanager.login.bean.UserInfo;

import com.fc.sysmanager.web.common.SysConstant;
import com.fc.sysmanager.web.common.WebUtil;

@Controller
@RequestMapping("exchange")
public class ExchangeController {
	
	@Autowired
	private ExchangeService exchangeService;
	
	@RequestMapping("exchangelist.do")
	public String exchangeList(){
		return "exchangelist";
	}
	
	
	@RequestMapping(value="initexchangepage.do")
	public String initExchangePage(HttpServletRequest request) throws ParseException{
//		UserInfo ui  = (UserInfo)request.getSession().getAttribute(SysConstant.USERINFO_ALIAS);
//		//日期选项
//		LocalDateTime ldt0 = LocalDateTime.now();
//		LocalDateTime ldt1 = LocalDateTime.now().plusDays(1);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA);
//		List<String> dateOption = new ArrayList();
//		dateOption.add(formatter.format(ldt0));
//		dateOption.add(formatter.format(ldt1));
//		request.setAttribute("dateOption", dateOption);
//		//交班对象
//		List exchangeNurseList  = exchangeService.getUserList(ui.getDeptId(), "9", ui.getUserSysId());
//		request.setAttribute("exchangeNurseList", exchangeNurseList);
//		List exchangeDoctorList  = exchangeService.getUserList(ui.getDeptId(), "8", ui.getUserSysId());
//		request.setAttribute("exchangeDoctorList", exchangeDoctorList);
//		//交班模板
//		List exchangeTemplateList = exchangeService.getExchangeTeamplateList(ui.getUserSysId());
//		request.setAttribute("exchangeTemplateList", exchangeTemplateList);
//		return "initexchange";
//-------------------------------------------------------------------------------------------------------		
//		UserInfo ui  = (UserInfo)request.getSession().getAttribute(SysConstant.USERINFO_ALIAS);
//		LocalDateTime ldt0 = LocalDateTime.now();
//		Date jbrq = null;
//		if(ldt0.getHour()>=8){
//			jbrq =  Date.from(ldt0.plusDays(1).atZone(ZoneId.systemDefault()).toInstant());
//		}else{
//			jbrq =  Date.from(ldt0.atZone(ZoneId.systemDefault()).toInstant());
//		}
//		Exchange ex = exchangeService.newExchange(jbrq, ui.getUserName(), ui.getUserSysId(), null, ui.getDeptId(), null,null, null);
//		request.setAttribute("exchangeId", ex.getExchangeId());
//		
//		//搅拌日期
//		ldt0 = LocalDateTime.now();
//		LocalDateTime ldt1 = LocalDateTime.now().plusDays(1);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA);
//		List<String> dateOption = new ArrayList();
//		dateOption.add(formatter.format(ldt0));
//		dateOption.add(formatter.format(ldt1));
//		request.setAttribute("dateOption", dateOption);
//		//交班对象
//		List exchangeNurseList  = exchangeService.getUserList(ui.getDeptId(), "9", ui.getUserSysId());
//		request.setAttribute("exchangeNurseList", exchangeNurseList);
//		List exchangeDoctorList  = exchangeService.getUserList(ui.getDeptId(), "8", ui.getUserSysId());
//		request.setAttribute("exchangeDoctorList", exchangeDoctorList);
//		
//		//refresh statis
//		RefreshExchangeStatisThread thread = new RefreshExchangeStatisThread(exchangeService, ex.getExchangeId());
//		thread.start();
//		
//		return "editexchange";
		
		UserInfo ui  = (UserInfo)request.getSession().getAttribute(SysConstant.USERINFO_ALIAS);
		List<Exchange> recentDraftExchangelist = exchangeService.getRecentDraftExchangeByUser(ui.getUserSysId());
		if(recentDraftExchangelist.size()==0){
			return initExchange(request);
		}else{
			request.setAttribute("recentDraftExchangelist", recentDraftExchangelist);
			return "mydraftexchangelist";
		}
	}
	
	@RequestMapping(value="forceinitexchangepage.do")
	public String initExchange(HttpServletRequest request){
		UserInfo ui  = (UserInfo)request.getSession().getAttribute(SysConstant.USERINFO_ALIAS);
		LocalDateTime ldt0 = LocalDateTime.now();
		Date jbrq = null;
		if(ldt0.getHour()>=8){
			jbrq =  Date.from(ldt0.plusDays(1).atZone(ZoneId.systemDefault()).toInstant());
		}else{
			jbrq =  Date.from(ldt0.atZone(ZoneId.systemDefault()).toInstant());
		}
		Exchange ex = exchangeService.newExchange(jbrq, ui.getUserName(), ui.getUserSysId(), null, ui.getDeptId(), null,null, null);
		request.setAttribute("exchangeId", ex.getExchangeId());
		
		//搅拌日期
		ldt0 = LocalDateTime.now();
		LocalDateTime ldt1 = LocalDateTime.now().plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA);
		List<String> dateOption = new ArrayList();
		dateOption.add(formatter.format(ldt0));
		dateOption.add(formatter.format(ldt1));
		request.setAttribute("dateOption", dateOption);
		//交班对象
		List exchangeNurseList  = exchangeService.getUserList(ui.getDeptId(), "9", ui.getUserSysId());
		request.setAttribute("exchangeNurseList", exchangeNurseList);
		List exchangeDoctorList  = exchangeService.getUserList(ui.getDeptId(), "8", ui.getUserSysId());
		request.setAttribute("exchangeDoctorList", exchangeDoctorList);
		
		List<Department> deptList = exchangeService.getOtherDeptList(ui.getDeptId());
		request.setAttribute("deptList", deptList);
		
		//refresh statis
		new RefreshExchangeStatisThread(exchangeService, ex.getExchangeId()).start();;
		
		return "editexchange";
	}
	
	
//	@RequestMapping(value="initexchange.do", method=RequestMethod.POST)
//	@ResponseBody
//	public Map initExchange(HttpServletRequest request, @RequestBody Map<String, String> map) throws ParseException{
//		String exchangeDate = map.get("exchangeDate");
//		String exchangeTargetUserId = map.get("exchangeTargetUserId");
//		String exchangeOwenrDoctorUserId = map.get("exchangeOwenrDoctorUserId");
//		String exchangeDoctorUserId = map.get("exchangeDoctorUserId");
//		String exchangeTemplateId =map.get("exchangeTemplateId");
//		System.out.println(exchangeTemplateId);
//		UserInfo ui  = (UserInfo)request.getSession().getAttribute(SysConstant.USERINFO_ALIAS);
//		
//		//TODO: 校验数据
//		
//		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(exchangeDate);
//		Exchange ex = exchangeService.newExchange(date, ui.getUserName(), ui.getUserSysId(), exchangeTargetUserId, ui.getDeptId(), exchangeOwenrDoctorUserId,exchangeDoctorUserId, exchangeTemplateId);
//		Map returnMap = new HashMap();
//		returnMap.put("exchangeId", ex.getExchangeId());
//		
//		//refresh statis
//		RefreshExchangeStatisThread thread = new RefreshExchangeStatisThread(exchangeService, ex.getExchangeId());
//		thread.start();
//		
//		return returnMap;
//	}
	
	
	@RequestMapping("list.do")
	@ResponseBody
	public PagedList list(PagedList pl, int begin, int end, HttpServletRequest request){
		
		UserInfo ui  = (UserInfo)request.getSession().getAttribute(SysConstant.USERINFO_ALIAS);
		return exchangeService.getExchangeList(pl, ui.getDeptSysCode());
	}
	
	@RequestMapping(value="detailpage/{exchangeId}.do")
	public String showdetailpage(@PathVariable("exchangeId") String exchangeId, HttpServletRequest request){
		request.setAttribute("exchangeId", exchangeId);
		return "exchangedetail";
	}
	
	@RequestMapping("detail/{exchangeId}.do")
	@ResponseBody
	public Exchange getExchangeById(@PathVariable("exchangeId") String exchangeId){
		return exchangeService.getExchangeById(exchangeId);
	}
	
	@RequestMapping(value="editpage/{exchangeId}.do")
	public String showEditPage(@PathVariable("exchangeId") String exchangeId, HttpServletRequest request){
		request.setAttribute("exchangeId", exchangeId);
		
		//交班护士 option list
		UserInfo ui  = (UserInfo)request.getSession().getAttribute(SysConstant.USERINFO_ALIAS);
//		List exchangeTargetList = exchangeService.getExchangeTargetList(ui.getDeptId());
//		request.setAttribute("exchangeTargetList", exchangeTargetList);
		List exchangeNurseList  = exchangeService.getUserList(ui.getDeptId(), "9", ui.getUserSysId());
		request.setAttribute("exchangeNurseList", exchangeNurseList);
		List exchangeDoctorList  = exchangeService.getUserList(ui.getDeptId(), "8", ui.getUserSysId());
		request.setAttribute("exchangeDoctorList", exchangeDoctorList);
		
		//搅拌日期
		LocalDateTime ldt0 = LocalDateTime.now();
		LocalDateTime ldt1 = LocalDateTime.now().plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA);
		List<String> dateOption = new ArrayList();
		dateOption.add(formatter.format(ldt0));
		dateOption.add(formatter.format(ldt1));
		request.setAttribute("dateOption", dateOption);
		
		List<Department> deptList = exchangeService.getOtherDeptList(ui.getDeptId());
		request.setAttribute("deptList", deptList);
		
		return "editexchange";
	}
	
	
	@RequestMapping("selectablepatientlist.do")
	@ResponseBody
	public Object getSelectablepatientlist(PagedList pl, int begin, int end, HttpServletRequest request, @RequestParam(value="exchangeId",required=false)String exchangeId){
		UserInfo ui  = (UserInfo)request.getSession().getAttribute(SysConstant.USERINFO_ALIAS);
		return exchangeService.getSelectablePatientList(pl, ui.getDeptId(), exchangeId);
	}
	
	
	@RequestMapping("exchangedetaillist/{exchangeId}.do")
	@ResponseBody
	public List getExchangeDetailList(@PathVariable("exchangeId") String exchangeId){
		List list = exchangeService.getExchangeDetailListByExchangeId(exchangeId);
		System.out.println(list.size());
		if(list.size()>0)
			System.out.println(list.get(0));
		return list;
	}
	
	
	@RequestMapping(value="updateexchangeitem.do", method=RequestMethod.POST)
	@ResponseBody
	public Object updateAttribute(HttpServletRequest request, @RequestBody Map<String, String> map) throws Exception{
		String exchangeId = map.get("exchangeId");
		String exchangeDetailId = map.get("exchangeDetailId");
		String field = map.get("field");
		String value = map.get("value");
		
		//validate if the exhcnage is in draft status...
		Exchange ex = exchangeService.getExchangeById(exchangeId);
		if(!ex.getC_status().equals("00") && !ex.getC_status().equals("01")){
			throw new Exception("用户要更改的交接班状态不可用或已被修改...");
		}
		
		//update sql
		String[] fields=null;
		String[] values=null;
		if("c_bqdj".equals(field) || "c_hldj".equals(field)){
			fields = new String[]{field};
			values = new String[]{value};
		}else if("jianyuan".equals(field)){
			fields = new String[]{"c_cy", "c_zc", "c_sw", "c_jsonstr"};
			String jsonStr = map.get("jsonstr");
			if("1".equals(value)){
				values = new String[]{"0", "0", "1", jsonStr};
			}else if("2".equals(value)){
				values = new String[]{"1", "0", "0", jsonStr};
			}else if("3".equals(value)){
				values = new String[]{"0", "1", "0", jsonStr};
			}else{
				values = new String[]{"0", "0", "0", jsonStr};
			}
		}else if("c_hltsbz".equals(field)){
			fields = new String[]{field};
			values = new String[]{"true".equals(value)?"1":"0"};
		}
		Object retObject =  exchangeService.updateExchangeDetailItem(exchangeId, exchangeDetailId, fields, values);
		
		//refresh statis
		new RefreshExchangeStatisThread(exchangeService, exchangeId).start();
		
		
		return retObject;
	}
	
	@RequestMapping(value="updateexchangeattr/{exchangeId}.do", method=RequestMethod.POST)
	@ResponseBody
	public Object updateExAttribute(HttpServletRequest request, @RequestBody Map<String, String> map, @PathVariable("exchangeId") String exchangeId) throws Exception{
		//TODO
		String exchangeDetailId = map.get("exchangeDetailId");
		String field = map.get("field");
		String value = map.get("value");
		
		//validate if the exhcnage is in draft status...
		Exchange ex = exchangeService.getExchangeById(exchangeId);
		if(!ex.getC_status().equals("00") && !ex.getC_status().equals("01")){
			throw new Exception("用户要更改的交接班状态不可用或已被修改...");
		}
		Integer ret=0;
		if("c_jbrq".equals(field)){
			ret = exchangeService.updateExchangeDate(exchangeId, value);
		}else if("c_jbysid".equals(field) || "c_jbhsid2".equals(field) || "c_jbysid2".equals(field)){
			ret = exchangeService.updateExchangeRelatedUser(exchangeId, field, value);
		}else{
			throw new Exception("非法操作！字段名不正确！");
		}
		return ret;
	}
	
	@RequestMapping(value="addpatient/{exchangeId}.do", method=RequestMethod.POST)
	@ResponseBody
	public ExchangeDetail addPatientToExchange(HttpServletRequest request, @RequestBody Map<String, String> map,@PathVariable("exchangeId") String exchangeId) throws Exception{
		UserInfo ui  = (UserInfo)request.getSession().getAttribute(SysConstant.USERINFO_ALIAS);
		String c_zyh = map.get("c_zyh");
		Patient0 p = exchangeService.getPatienByZYH(c_zyh);
		if(p==null){
			throw new Exception("选择病人不存在， 请重新操作...");
		}
		ExchangeDetail ed = exchangeService.newExchangeDetail(exchangeId, p, ui.getDeptId());
		
		//refresh statis
		new RefreshExchangeStatisThread(exchangeService, exchangeId).start();
		
		return ed;
	}
	
	@RequestMapping(value="addpatientbych/{exchangeId}.do", method=RequestMethod.POST)
	@ResponseBody
	public Object addPatientByCH(HttpServletRequest request, @RequestBody Map<String, String> map,@PathVariable("exchangeId") String exchangeId) throws Exception{
		UserInfo ui  = (UserInfo)request.getSession().getAttribute(SysConstant.USERINFO_ALIAS);
		String c_ch = map.get("c_ch");
		Pattern pattern1 = Pattern.compile("^[\\d+\\,]*\\d+$");
		Matcher isPattern1 = pattern1.matcher(c_ch);
		Pattern pattern2 = Pattern.compile("^\\d+-\\d+$");
		Matcher isPattern2 = pattern2.matcher(c_ch);
		String sql_parameter = "";
		int input_count = 0;
		Map retmap = new HashMap(); 
		if(isPattern1.matches()){
			String[] ids = c_ch.split(",");
			for(String str:ids){
				sql_parameter = sql_parameter+"'"+str+"',";
				if(str.length()==1){
					sql_parameter = sql_parameter+"'0"+str+"',";
				}
				input_count++;
			}
			
		}else if(isPattern2.matches()){
			String[] range = c_ch.split("-");
			int start =  Integer.parseInt(range[0]);
			int end = Integer.parseInt(range[1]);
			for(int i=start;i<=end;i++){
				sql_parameter = sql_parameter +"'"+i+"',";
				if(i<10){
					sql_parameter = sql_parameter +"'0"+i+"',";
				}
				input_count++;
			}
		}else{
			throw new Exception("格式输入有误.....");
		}
		
		if(input_count>0){
			sql_parameter = sql_parameter.substring(0, sql_parameter.length()-1);
			input_count = exchangeService.addPatientByChList(ui.getDeptId(),sql_parameter,exchangeId);
			retmap.put("count", input_count);
		}else{
			throw new Exception("格式输入有误.....");
		}
		
		//refresh statis
		if(input_count>0){
			new RefreshExchangeStatisThread(exchangeService, exchangeId).start();;
		}
		
		return retmap;
	}
	
//	@RequestMapping(value="updatestatus/{exchangeId}.do", method=RequestMethod.POST)
//	@ResponseBody
//	public Object updateStatis(@PathVariable("exchangeId") String exchangeId){
//		return exchangeService.updateStatis(exchangeId);
//	}
	
	@RequestMapping(value="update/{exchangeId}.do", method=RequestMethod.POST)
	@ResponseBody
	public Object updateStatus(@PathVariable("exchangeId") String exchangeId, @RequestBody Map<String, String> map, HttpServletRequest request) throws Exception{
		UserInfo ui  = (UserInfo)request.getSession().getAttribute(SysConstant.USERINFO_ALIAS);
		String targetStatus = map.get("targetStatus");
		String comment = map.get("comment");
		return exchangeService.exStatusUpdate(exchangeId, targetStatus, comment, ui.getUserSysId());
	}
	
	
	@RequestMapping(value="exchangedetailitempage/{exchangeDetailId}.do",method=RequestMethod.GET)
	public String showExchangeDetailPage(@PathVariable("exchangeDetailId") String exchangeDetailId, HttpServletRequest request){
		ExchangeDetail ed = exchangeService.getExchangeDetailListByExchangeDetailId(exchangeDetailId);
		request.setAttribute("ed", ed);
		
		Exchange ex = exchangeService.getExchangeById(ed.getC_exch_id());
		UserInfo ui  = (UserInfo)request.getSession().getAttribute(SysConstant.USERINFO_ALIAS);
		boolean editable = false;
		if( (ex.getC_status().equals(ExConstants.EXCHANGE_STATUS_DRAFT_00) || ex.getC_status().equals(ExConstants.EXCHANGE_STATUS_DRAWBACK_01) )
				&& ex.getC_jbhsid().equals(ui.getUserSysId())){
			editable = true;
		}
		request.setAttribute("editable", editable==true?"true":"false");
		
		request.setAttribute("exchangeDetailId", exchangeDetailId);
		
		return "exchangedetailitempage";
	}
	
	@RequestMapping(value="exchangedetailitem/{exchangeDetailId}.do",method=RequestMethod.GET)
	@ResponseBody
	public ExchangeDetail getExhcnageDetailItem(@PathVariable("exchangeDetailId") String exchangeDetailId){
		ExchangeDetail ed = exchangeService.getExchangeDetailListByExchangeDetailId(exchangeDetailId);
		//refresh statis
		//new RefreshExchangeStatisThread(exchangeService, ed.getC_exch_id()).start(); 
		return ed;
	}
	
	private int converStringToInt(String input){
		if(StringUtils.isBlank(input)){
			return 0;
		}else{
			try{
				return Integer.parseInt(input);
			}catch(Exception e){
				return 0;
			}
		}
	}
	
	@RequestMapping(value="exchangedetailitem/{exchangeDetailId}.do",method=RequestMethod.POST)
	@ResponseBody
	public Object updateExchangeDetailItem(@RequestBody Map<String, String> map, @PathVariable("exchangeDetailId") String exchangeDetailId, HttpServletRequest request) throws Exception{
		ExchangeDetail ed = exchangeService.getExchangeDetailListByExchangeDetailId(exchangeDetailId);
		Exchange ex = exchangeService.getExchangeById(ed.getC_exch_id());
		UserInfo ui  = (UserInfo)request.getSession().getAttribute(SysConstant.USERINFO_ALIAS);
		if( (ex.getC_status().equals(ExConstants.EXCHANGE_STATUS_DRAFT_00) || ex.getC_status().equals(ExConstants.EXCHANGE_STATUS_DRAWBACK_01) )
				&& ex.getC_jbhsid().equals(ui.getUserSysId())){
			

			int c_bqdj = converStringToInt(map.get("c_bqdj"));
			int c_hldj = converStringToInt(map.get("c_hldj"));
			int c_qzwxwc = converStringToInt(map.get("c_qzwxwc"));
			int c_qfyj = converStringToInt(map.get("c_qfyj"));
			int c_zdtt = converStringToInt(map.get("c_zdtt"));
			int c_nrs = converStringToInt(map.get("c_nrs"));
			int c_fyc = converStringToInt(map.get("c_fyc"));
			int c_gcjlgj = converStringToInt(map.get("c_gcjlgj"));
			int c_jl = converStringToInt(map.get("c_jl"));
			int c_gj = converStringToInt(map.get("c_gj"));
			int c_fdt = converStringToInt(map.get("c_fdt"));
			int c_fdtpf = converStringToInt(map.get("c_fdtpf"));
			int c_tsjc = converStringToInt(map.get("c_tsjc"));
			String c_tsjcnr = map.get("c_tsjcnr");
			int c_sjmzg = converStringToInt(map.get("c_sjmzg"));
			int c_tszl = converStringToInt(map.get("c_tszl"));
			String c_tszlnr = map.get("c_tszlnr");
			int c_wjzbg = converStringToInt(map.get("c_wjzbg"));
			int c_dcnyx = converStringToInt(map.get("c_dcnyx"));
			String c_dcnyxbz = map.get("c_dcnyxbz");
			int c_blsj = converStringToInt(map.get("c_blsj"));
			String c_blsjbz = map.get("c_blsjbz");
			int c_ssbr = converStringToInt(map.get("c_ssbr"));
			int c_nssbr = converStringToInt(map.get("c_nssbr"));
			String c_hlnr = map.get("c_hlnr");
			String c_bqnr = map.get("c_bqnr");
			
			ed.setC_bqdj(c_bqdj);
			ed.setC_hldj(c_hldj);
			ed.setC_qzwxwc(c_qzwxwc);
			ed.setC_qfyj(c_qfyj);
			ed.setC_zdtt(c_zdtt);
			ed.setC_nrs(c_nrs);
			ed.setC_fyc(c_fyc);
			ed.setC_gcjlgj(c_gcjlgj);
			ed.setC_jl(c_jl);
			ed.setC_gj(c_gj);
			ed.setC_fdt(c_fdt);
			ed.setC_fdtpf(c_fdtpf);
			ed.setC_tsjc(c_tsjc);
			ed.setC_tsjcnr(c_tsjcnr);
			ed.setC_sjmzg(c_sjmzg);
			ed.setC_tszl(c_tszl);
			ed.setC_tszlnr(c_tszlnr);
			ed.setC_wjzbg(c_wjzbg);
			ed.setC_dcnyx(c_dcnyx);
			ed.setC_dcnyxbz(c_dcnyxbz);
			ed.setC_blsj(c_blsj);
			ed.setC_blsjbz(c_blsjbz);
			ed.setC_ssbr(c_ssbr);
			ed.setC_nssbr(c_nssbr);
			ed.setC_hlnr(c_hlnr);
			ed.setC_bqnr(c_bqnr);
			
			Object retObj =  exchangeService.saveExchangeDetailItem(ed);
			
			//refresh statis
			new RefreshExchangeStatisThread(exchangeService, ex.getExchangeId()).start();
			
			return retObj;
		}else{
			throw new Exception("非法操作。。。");
		}
	}

	@RequestMapping(value="patienthistory/{patientId}.do")
	@ResponseBody
	public Map getPatientHistoryByPatientId(@PathVariable("patientId") String patientId){
		return exchangeService.getPatientHistory(patientId);
	}
	
	@RequestMapping(value="patienthistorypage/{patientId}.do")
	public String showPatientHistoryPage(@PathVariable("patientId") String patientId,HttpServletRequest request){
		request.setAttribute("patientId", patientId);
		return "patienthistorypage";
	}
	
	@RequestMapping(value="removeitem/{exchangeId}/{exchangeDetailId}.do",method=RequestMethod.POST)
	@ResponseBody
	public Integer removeExchangeDetailFromExchange(@PathVariable("exchangeDetailId")String exchangeDetailId, @PathVariable("exchangeId") String exchangeId) throws Exception{
		//validate if the exhcnage is in draft status...
		Exchange ex = exchangeService.getExchangeById(exchangeId);
		if(!ex.getC_status().equals("00") && !ex.getC_status().equals("01")){
			throw new Exception("用户要更改的交接班状态不可用或已被修改...");
		}
		Integer ret =  exchangeService.remvoeExchagneDetail(exchangeId, exchangeDetailId);
		//refresh statis
		new RefreshExchangeStatisThread(exchangeService, ex.getExchangeId()).start();
		
		return ret;
	}
	
	@RequestMapping(value="remove/{exchangeId}.do")
	@ResponseBody
	public Integer removeDraftExchange(@PathVariable("exchangeId")String exchangeId,HttpServletRequest request) throws Exception{
		UserInfo ui  = (UserInfo)request.getSession().getAttribute(SysConstant.USERINFO_ALIAS);
		return exchangeService.deleteDraftExchangeByCreator(exchangeId, ui.getUserSysId());
	}
	
	
}
