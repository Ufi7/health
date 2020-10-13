package com.fc.exch.model;


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fc.sysmanager.common.UserType;

@Entity
@Table(name="T_USER")
public class UserEntity {

	@Id
	@Column(name = "C_USER_ID")
	private String userId;
	
	@Column(name = "C_DEPT_ID")
	private String deptId;
	
	@Column(name = "C_OFFICE_ID")
	private String officeId;
	
	@Column(name="C_USER_NAME")
	private String userName;
	
	@Column(name="C_USER_ACCOUNT")
	private String userAccount;
	
	@Column(name = "C_USER_PWD")
	private String userPwd;
	
	@Column(name = "C_NOTE")
	private String note;
	
	@Column(name = "C_USER_TYPE")
	private String userType = UserType.COMMON;
	
	@Column(name = "C_EMAIL")
	private String email;
	
	@Column(name = "C_HOS_TYPE")
	private String hosType;
	
	@Column(name = "C_SEX")
	private String sex;
	
	@Column(name = "C_POSITION")
	private String position;
	
	@Column(name = "C_FLAG")
	private String flag;
	
	@Transient
	private String status;
	
//	private String officeName;
	
	public UserEntity(){
		userId = UUID.randomUUID().toString();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		if(officeId == null || officeId.trim().trim().equals(""))
			officeId = null;
		this.officeId = officeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHosType() {
		return hosType;
	}

	public void setHosType(String hosType) {
		this.hosType = hosType;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
