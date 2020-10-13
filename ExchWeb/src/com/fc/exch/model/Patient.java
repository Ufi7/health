package com.fc.exch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fc.core.common.utils.Util;

import antlr.Utils;

@Entity
@Table(name="t_patient")
public class Patient {

	/*住院号*/
	@Id
	@Column(name="c_zyh")
	private String zyh;
	
	/*病人ID*/
	@Column(name="c_brid")
	private String brid;
	
	/*床号*/
	@Column(name="c_ch")
	private String ch;
	
	/*病人姓名*/
	@Column(name="c_brxm")
	private String brxm;
	
	/*出生日期*/
	@Column(name="c_csrq")
	@DateTimeFormat
	private Date csrq;
	
	@Transient
	private String csrqStr;
	
	/*性别 F--女 M--男*/
	@Column(name="c_xb")
	private String xb;
	
	/*联系人*/
	@Column(name="c_lxr")
	private String lxr;
	
	/*联系电话*/
	@Column(name="c_lxdh")
	private String lxdh;
	
	/*联系地址*/
	@Column(name="c_lxdz")
	private String lxdz;
	
	/*入院时间*/
	@Column(name="c_rysj")
	@DateTimeFormat
	private Date rysj;
	
	@Transient
	private String rysjStr;
	
	/*病人状态 在院 --- 1，出院---0，死亡 --9*/
	@Column(name="c_brzt")
	private String brzt;
	
	/*拟出院日期*/
	@Column(name="c_ncyrq")
	@DateTimeFormat
	private Date ncycq;

	/*出院时间*/
	@Column(name="c_cysj")
	@DateTimeFormat
	private Date cysj;
	
	@Transient
	private String cysjStr;
	
	/*出院类型 1--治愈出院 2--转入他院 3--家属要求出院*/
	@Column(name="c_cylx")
	private String cylx;

	/*死亡时间*/
	@Column(name="c_swsj")
	@DateTimeFormat
	private Date swsj;

	/*死亡原因*/
	@Column(name="c_swyy")
	private String swyy;
	
	/*抢救措施*/
	@Column(name="c_qjcs")
	private String qjcs;
	
	/*主管医生ID*/
	@Column(name="c_zgysid")
	private String zgysid;
	
	/*主管医生*/
	@Column(name="c_zyys")
	private String zyys;
	
	/*主管护士ID*/
	@Column(name="c_zghsid")
	private String zghsid;
	
	/*主管护士*/
	@Column(name="c_zghs")
	private String zghs;
	
	/*主诉*/
	@Column(name="c_zs")
	private String zs;
	
	/*主要诊断*/
	@Column(name="c_zyzd")
	private String zyzd;
	
	/*备注*/
	@Column(name="c_bz")
	private String bz;
	
	/*所属部门ID*/
	@Column(name="c_bmid")
	private String bmid;
	
	/*原所属部门ID*/
	@Column(name="c_ybmid")
	private String ybmid;
	
	/*原部门值班护士ID*/
	@Column(name="c_ybmzbhsid")
	private String ybmzbhsid;
	
	/*原部门值班医生ID*/
	@Column(name="c_ybmzbysid")
	private String ybmzbysid;
	
	/*转入日期*/
	@Column(name="c_zrrq")
	@DateTimeFormat
	private Date zrrq;
	
	/*值班医生ID*/
	@Column(name="c_zbysid")
	private String zbysid;
	
	/*值班医生*/
	@Column(name="c_zbys")
	private String zbys;
	
	/*值班护士ID*/
	@Column(name="c_zbhsid")
	private String zbhsid;
	
	/*值班护士*/
	@Column(name="c_zbhs")
	private String zbhs;
	
	/*关闭标志*/
	@Column(name="c_gbbz")
	private String gbbz;

	/*医保类型 0-医保，1-自费*/
	@Column(name="c_yblx")
	private String yblx;
	
	@Transient
	private Integer bqdj;
	
	@Transient
	private Integer hldj;
	
	public String getZyh() {
		return zyh;
	}

	public void setZyh(String zyh) {
		this.zyh = zyh;
	}

	public String getBrid() {
		return brid;
	}

	public void setBrid(String brid) {
		this.brid = brid;
	}

	public String getCh() {
		return ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public Date getCsrq() {
		return csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getLxr() {
		return lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getLxdz() {
		return lxdz;
	}

	public void setLxdz(String lxdz) {
		this.lxdz = lxdz;
	}

	public Date getRysj() {
		return rysj;
	}

	public void setRysj(Date rysj) {
		this.rysj = rysj;
	}

	public String getBrzt() {
		return brzt;
	}

	public void setBrzt(String brzt) {
		this.brzt = brzt;
	}

	public Date getNcycq() {
		return ncycq;
	}

	public void setNcycq(Date ncycq) {
		this.ncycq = ncycq;
	}

	public Date getCysj() {
		return cysj;
	}

	public void setCysj(Date cysj) {
		this.cysj = cysj;
	}

	public String getCylx() {
		return cylx;
	}

	public void setCylx(String cylx) {
		this.cylx = cylx;
	}

	public Date getSwsj() {
		return swsj;
	}

	public void setSwsj(Date swsj) {
		this.swsj = swsj;
	}

	public String getSwyy() {
		return swyy;
	}

	public void setSwyy(String swyy) {
		this.swyy = swyy;
	}

	public String getQjcs() {
		return qjcs;
	}

	public void setQjcs(String qjcs) {
		this.qjcs = qjcs;
	}

	public String getZgysid() {
		return zgysid;
	}

	public void setZgysid(String zgysid) {
		this.zgysid = zgysid;
	}

	public String getZyys() {
		return zyys;
	}

	public void setZyys(String zyys) {
		this.zyys = zyys;
	}

	public String getZghsid() {
		return zghsid;
	}

	public void setZghsid(String zghsid) {
		this.zghsid = zghsid;
	}

	public String getZghs() {
		return zghs;
	}

	public void setZghs(String zghs) {
		this.zghs = zghs;
	}

	public String getZs() {
		return zs;
	}

	public void setZs(String zs) {
		this.zs = zs;
	}

	public String getZyzd() {
		return zyzd;
	}

	public void setZyzd(String zyzd) {
		this.zyzd = zyzd;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getBmid() {
		return bmid;
	}

	public void setBmid(String bmid) {
		this.bmid = bmid;
	}

	public String getYbmid() {
		return ybmid;
	}

	public void setYbmid(String ybmid) {
		this.ybmid = ybmid;
	}

	public String getYbmzbhsid() {
		return ybmzbhsid;
	}

	public void setYbmzbhsid(String ybmzbhsid) {
		this.ybmzbhsid = ybmzbhsid;
	}

	public String getYbmzbysid() {
		return ybmzbysid;
	}

	public void setYbmzbysid(String ybmzbysid) {
		this.ybmzbysid = ybmzbysid;
	}

	public Date getZrrq() {
		return zrrq;
	}

	public void setZrrq(Date zrrq) {
		this.zrrq = zrrq;
	}

	public String getZbysid() {
		return zbysid;
	}

	public void setZbysid(String zbysid) {
		this.zbysid = zbysid;
	}

	public String getZbys() {
		return zbys;
	}

	public void setZbys(String zbys) {
		this.zbys = zbys;
	}

	public String getZbhsid() {
		return zbhsid;
	}

	public void setZbhsid(String zbhsid) {
		this.zbhsid = zbhsid;
	}

	public String getZbhs() {
		return zbhs;
	}

	public void setZbhs(String zbhs) {
		this.zbhs = zbhs;
	}

	public String getGbbz() {
		return gbbz;
	}

	public void setGbbz(String gbbz) {
		this.gbbz = gbbz;
	}

	public String getYblx() {
		return yblx;
	}

	public void setYblx(String yblx) {
		this.yblx = yblx;
	}

	public Integer getBqdj() {
		return bqdj;
	}

	public void setBqdj(Integer bqdj) {
		this.bqdj = bqdj;
	}

	public Integer getHldj() {
		return hldj;
	}

	public void setHldj(Integer hldj) {
		this.hldj = hldj;
	}

	public String getCsrqStr() {
		return csrqStr;
	}

	public void setCsrqStr(String csrqStr) {
		this.csrqStr = csrqStr;
	}

	public String getRysjStr() {
		return rysjStr;
	}

	public void setRysjStr(String rysjStr) {
		this.rysjStr = rysjStr;
	}

	public String getCysjStr() {
		return cysjStr;
	}

	public void setCysjStr(String cysjStr) {
		this.cysjStr = cysjStr;
	}
	
}
