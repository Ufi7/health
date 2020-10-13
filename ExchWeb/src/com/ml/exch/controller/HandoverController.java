package com.ml.exch.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.core.model.PagedList;
import com.fc.exch.model.ExchangeEntity;
import com.fc.exch.service.HandoverService;
import com.fc.exch.service.PatientService;
import com.fc.sysmanager.login.bean.UserInfo;
import com.fc.sysmanager.model.Dept;
import com.fc.sysmanager.web.common.SysConstant;

@Controller
@RequestMapping("handover")
public class HandoverController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private HandoverService handoverService;
	
	@RequestMapping("index.do")
	public String index(HttpServletRequest request){
		List<Dept> deptList = patientService.getDeptList();
		request.setAttribute("deptList", deptList);
		return "handover/handoverList";
	}
	
	//获取交接信息列表
	@RequestMapping("getHandoverList.do")
	@ResponseBody
	public PagedList getHandoverList(PagedList pagedList, ExchangeEntity exchange, HttpSession session){
		UserInfo user = (UserInfo) session.getAttribute(SysConstant.USERINFO_ALIAS);
		return handoverService.getHandoverList(pagedList, exchange, user.getUserSysId());
	}
}
