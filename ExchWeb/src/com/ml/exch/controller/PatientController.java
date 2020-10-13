package com.ml.exch.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fc.core.model.PagedList;
import com.fc.core.web.SessionInterceptor;
import com.fc.exch.model.Patient;
import com.fc.exch.service.PatientService;
import com.fc.sysmanager.login.bean.UserInfo;
import com.fc.sysmanager.model.Dept;
import com.fc.sysmanager.web.common.SysConstant;
import com.ml.ResultObject;

import nst.report.jasper.util.DataDealUtil;

@Controller
@RequestMapping("patient")
public class PatientController {
	
	public final static String DOCTOR = "8";
	public final static String NURSE = "9";
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping("index.do")
	public String index(){
		return "patient/patientList";
	}
	
	//获取病人信息列表
	@RequestMapping("getPatientList.do")
	@ResponseBody
	public PagedList getPatientList(PagedList pagedList, Patient patient, HttpSession session){
		UserInfo user = (UserInfo) session.getAttribute(SysConstant.USERINFO_ALIAS);
		return patientService.getPatientList(pagedList, patient, user);
	}
	
	//跳转0-新增,1-编辑,2-查看病人信息页面
	@RequestMapping("toEditPatientWin.do")
	public String toEditPatientWin(HttpServletRequest request, String zyh, Integer editFlag){
		if(editFlag!=2){
			List<UserInfo> doctorList = patientService.getUserListByHosType(DOCTOR);
			List<UserInfo> nurseList = patientService.getUserListByHosType(NURSE);
			List<Dept> deptList = patientService.getDeptList();
			request.setAttribute("doctorList", doctorList);
			request.setAttribute("nurseList", nurseList);
			request.setAttribute("deptList", deptList);
		}
		if(editFlag!=0){
			Patient patient = patientService.getPatientByZyh(zyh);
			request.setAttribute("patient", patient);
		}
		if(editFlag==2)
			return "patient/checkPatient";
		else if(editFlag==1)
			return "patient/editPatient";
		else
			return "patient/addPatient";
	}
	
	@RequestMapping("addPatient.do")
	@ResponseBody
	public Object addPatient(HttpServletRequest request,Patient patient) throws ParseException{
		String editFlag = request.getParameter("editFlag");//1-编辑 0新增
		Patient patientOld = null;
		if(editFlag.equals("1")){
			patientOld = patientService.getPatientByZyh(patient.getZyh());
			if(patientOld==null){
				return new ResultObject(false, "找不到相应数据，请刷新重试！");
			}
		}
		String csrqStr = request.getParameter("csrqStr");
		String rysjStr = request.getParameter("rysjStr");
		String cysjStr = request.getParameter("cysjStr");
		String swsjStr = request.getParameter("swsjStr");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		patient.setCsrq(sdf.parse(csrqStr));
		patient.setRysj(sdf.parse(rysjStr));
		if(!DataDealUtil.stringIsEmpty(cysjStr)) patient.setCysj(sdf.parse(cysjStr));
		if(!DataDealUtil.stringIsEmpty(swsjStr)) patient.setSwsj(sdf.parse(swsjStr));
		if(editFlag.equals("0")){
			if(!patient.getBrzt().equals("1")){
				patient.setGbbz("1");
			}else{
				patient.setGbbz("0");
			}
		}else{
			patient.setGbbz(patientOld.getGbbz());
		}
		patientService.savePatient(patient);
		return new ResultObject(true, "保存成功");
	}
	
	@RequestMapping("delPatient.do")
	@ResponseBody
	public Object delPatient(HttpServletRequest request,String zyh) throws ParseException{
		Patient patient = patientService.getPatientByZyh(zyh);
		if(patient==null){
			return new ResultObject(false, "找不到相应数据，请刷新重试！");
		}
		patientService.delPatient(patient);
		return new ResultObject(true, "删除成功");
	}
	
}
