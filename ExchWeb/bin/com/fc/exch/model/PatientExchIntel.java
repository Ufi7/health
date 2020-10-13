package com.fc.exch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 科室部门转出记录表
 */
@Entity
@Table(name="t_patinet_exch_intel")
public class PatientExchIntel {

	/*记录ID*/
	@Id
	@Column(name="c_tran_id")
	private String tranId;
	
	/*住院号*/
	@Column(name="c_zyh")
	private String zyh;
	
	/*转入时间*/
	@Column(name="c_zrsj")
	private Date zrsj;
	
	/*转入部门ID*/
	@Column(name="c_zrbmid")
	private String zrbmid;
	
	/*转出部门ID*/
	@Column(name="c_zcbmid")
	private String zcbmid;
	
	/*原值班医生ID*/
	@Column(name="c_yzbysid")
	private String yzbysid;
	
	/*原值班护士ID*/
	@Column(name="c_yzbhsid")
	private String yzbhsid;
	
	/*备注*/
	@Column(name="c_note")
	private String note;

	public String getTranId() {
		return tranId;
	}

	public void setTranId(String tranId) {
		this.tranId = tranId;
	}

	public String getZyh() {
		return zyh;
	}

	public void setZyh(String zyh) {
		this.zyh = zyh;
	}

	public Date getZrsj() {
		return zrsj;
	}

	public void setZrsj(Date zrsj) {
		this.zrsj = zrsj;
	}

	public String getZrbmid() {
		return zrbmid;
	}

	public void setZrbmid(String zrbmid) {
		this.zrbmid = zrbmid;
	}

	public String getZcbmid() {
		return zcbmid;
	}

	public void setZcbmid(String zcbmid) {
		this.zcbmid = zcbmid;
	}

	public String getYzbysid() {
		return yzbysid;
	}

	public void setYzbysid(String yzbysid) {
		this.yzbysid = yzbysid;
	}

	public String getYzbhsid() {
		return yzbhsid;
	}

	public void setYzbhsid(String yzbhsid) {
		this.yzbhsid = yzbhsid;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
