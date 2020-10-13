package com.fc.exch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 手术信息表 
 */
@Entity
@Table(name="t_sugery_info")
public class SugeryInfo {

	/*记录ID*/
	@Id
	@Column(name="c_sugery_id")
	private String sugeryId;
	
	/*住院号*/
	@Column(name="c_zyh")
	private String zyh;
	
	/*手术/拟手术*/
	@Column(name="c_ss_flag")
	private String ssFlag;
	
	/*手术时间*/
	@Column(name="c_sssj")
	private Date sssj;
	
	/*手术名称*/
	@Column(name="c_ssmc")
	private String ssmc;
	
	/*管床医生ID*/
	@Column(name="c_gcysid")
	private String gcysid;
	
	/*管床医生*/
	@Column(name="c_gcys")
	private String gcys;
	
	/*主刀医生ID*/
	@Column(name="c_zdysid")
	private String zdysid;
	
	/*主刀医生名称*/
	@Column(name="c_zcysmc")
	private String zcysmc;
	
	/*主刀医生资格*/
	@Column(name="c_zcyszg")
	private String zcyszg;
	
	/*术前诊断*/
	@Column(name="c_sqzd")
	private String sqzd;
	
	/*术后诊断*/
	@Column(name="c_shzd")
	private String shzd;
	
	/*术后情况*/
	@Column(name="c_shqk")
	private String shqk;
	
	/*备注*/
	@Column(name="c_bz")
	private String bz;

	public String getSugeryId() {
		return sugeryId;
	}

	public void setSugeryId(String sugeryId) {
		this.sugeryId = sugeryId;
	}

	public String getZyh() {
		return zyh;
	}

	public void setZyh(String zyh) {
		this.zyh = zyh;
	}

	public String getSsFlag() {
		return ssFlag;
	}

	public void setSsFlag(String ssFlag) {
		this.ssFlag = ssFlag;
	}

	public Date getSssj() {
		return sssj;
	}

	public void setSssj(Date sssj) {
		this.sssj = sssj;
	}

	public String getSsmc() {
		return ssmc;
	}

	public void setSsmc(String ssmc) {
		this.ssmc = ssmc;
	}

	public String getGcysid() {
		return gcysid;
	}

	public void setGcysid(String gcysid) {
		this.gcysid = gcysid;
	}

	public String getGcys() {
		return gcys;
	}

	public void setGcys(String gcys) {
		this.gcys = gcys;
	}

	public String getZdysid() {
		return zdysid;
	}

	public void setZdysid(String zdysid) {
		this.zdysid = zdysid;
	}

	public String getZcysmc() {
		return zcysmc;
	}

	public void setZcysmc(String zcysmc) {
		this.zcysmc = zcysmc;
	}

	public String getZcyszg() {
		return zcyszg;
	}

	public void setZcyszg(String zcyszg) {
		this.zcyszg = zcyszg;
	}

	public String getSqzd() {
		return sqzd;
	}

	public void setSqzd(String sqzd) {
		this.sqzd = sqzd;
	}

	public String getShzd() {
		return shzd;
	}

	public void setShzd(String shzd) {
		this.shzd = shzd;
	}

	public String getShqk() {
		return shqk;
	}

	public void setShqk(String shqk) {
		this.shqk = shqk;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
