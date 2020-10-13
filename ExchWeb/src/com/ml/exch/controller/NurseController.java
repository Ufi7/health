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

import com.fc.core.model.PagedList;
import com.fc.exch.model.Patient;
import com.fc.exch.model.UserEntity;
import com.fc.exch.service.PatientService;
import com.fc.exch.service.StaffService;
import com.fc.sysmanager.login.bean.UserInfo;
import com.fc.sysmanager.model.Dept;
import com.fc.sysmanager.web.common.SysConstant;
import com.ml.ResultObject;

import nst.report.jasper.util.DataDealUtil;

@Controller
@RequestMapping("nurse")
public class NurseController {
	
	public final static String DOCTOR = "8";
	public final static String NURSE = "9";
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping("index.do")
	public String index(HttpServletRequest request, HttpSession session){
		List<Dept> deptList = patientService.getDeptList();
		request.setAttribute("deptList", deptList);
		UserInfo user = (UserInfo) session.getAttribute(SysConstant.USERINFO_ALIAS);
		Boolean handoverUser = staffService.isHandoverUser(user.getUserSysId());
		request.setAttribute("handoverUser", handoverUser);
		return "staff/nurse/nurseList";
	}
	
	//获取护士信息列表
	@RequestMapping("getNurseList.do")
	@ResponseBody
	public PagedList getNurseList(PagedList pagedList, UserEntity user,String hosType){
		user.setHosType(hosType);
		PagedList list = staffService.getStaffList(pagedList, user);
		return staffService.getStaffList(pagedList, user);
	}
	
	//跳转管理病人信息列表页面
	@RequestMapping("toPatientWin.do")
	public String toPatientWin(HttpServletRequest request, String userSysId, HttpSession session){
		if(!DataDealUtil.stringIsEmpty(userSysId)){
			request.setAttribute("userSysId", userSysId);
			session.setAttribute("userId", userSysId);
		}else{
			request.setAttribute("userSysId", session.getAttribute("userId"));
		}
		return "staff/nurse/patientList";
	}
	
	//获取病人信息列表
	@RequestMapping("getPatientList.do")
	@ResponseBody
	public PagedList getPatientList(PagedList pagedList, String userSysId, Patient patient){
		//PagedList list = staffService.getPatientList(pagedList, user);
		return staffService.getPatientList(pagedList, userSysId, "9", patient);
	}
	
	//跳转0-新增,1-编辑护士信息页面
	@RequestMapping("toEditNurseWin.do")
	public String toEditNurseWin(HttpServletRequest request, String userId, Integer editFlag){
		request.setAttribute("hosType", "9");
		List<Dept> deptList = patientService.getDeptList();
		request.setAttribute("deptList", deptList);
		if(editFlag==1){
			UserEntity user = staffService.getUserByUserSysId(userId);
			request.setAttribute("user", user);
			return "staff/nurse/editNurse";
		}else
			return "staff/nurse/addNurse";
	}
	
	@RequestMapping("addNurse.do")
	@ResponseBody
	public Object addNurse(HttpServletRequest request,UserEntity user){
		user.setUserType("1");
		String editFlag = request.getParameter("editFlag");//1-编辑 0新增
		UserEntity userOld = null;
		if(editFlag.equals("1")){
			userOld = staffService.getUserByUserSysId(user.getUserId());
			if(userOld==null){
				return new ResultObject(false, "找不到相应数据，请刷新重试！");
			}
			user.setUserAccount(userOld.getUserAccount());
			user.setUserPwd(userOld.getUserPwd());
		}
		staffService.saveStaff(user);
		return new ResultObject(true, "保存成功");
	}
	

	@RequestMapping("delNurse.do")
	@ResponseBody
	public Object delNurse(String userId){
		UserEntity user = staffService.getUserByUserSysId(userId);
		if(user==null){
			return new ResultObject(false, "找不到相应数据，请刷新重试！");
		}
		user.setFlag("0");
		staffService.saveStaff(user);
		return new ResultObject(true, "删除成功");
	}
	
	//跳转0-新增,1-编辑,2-查看病人信息页面
	@RequestMapping("toEditPatientWin.do")
	public String toEditPatientWin(HttpServletRequest request, String zyh, Integer editFlag, Integer hosType, HttpSession session){
		request.setAttribute("userSysId", session.getAttribute("userId"));
		request.setAttribute("hosType", hosType);
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
			return "staff/checkPatient";
		else if(editFlag==1)
			return "staff/editPatient";
		else
			return "staff/addPatient";
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
	
}
