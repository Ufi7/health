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

	/*浣忛櫌鍙�*/
	@Id
	@Column(name="c_zyh")
	private String zyh;
	
	/*鐥呬汉ID*/
	@Column(name="c_brid")
	private String brid;
	
	/*搴婂彿*/
	@Column(name="c_ch")
	private String ch;
	
	/*鐥呬汉濮撳悕*/
	@Column(name="c_brxm")
	private String brxm;
	
	/*鍑虹敓鏃ユ湡*/
	@Column(name="c_csrq")
	@DateTimeFormat
	private Date csrq;
	
	@Transient
	private String csrqStr;
	
	/*鎬у埆 F--濂� M--鐢�*/
	@Column(name="c_xb")
	private String xb;
	
	/*鑱旂郴浜�*/
	@Column(name="c_lxr")
	private String lxr;
	
	/*鑱旂郴鐢佃瘽*/
	@Column(name="c_lxdh")
	private String lxdh;
	
	/*鑱旂郴鍦板潃*/
	@Column(name="c_lxdz")
	private String lxdz;
	
	/*鍏ラ櫌鏃堕棿*/
	@Column(name="c_rysj")
	@DateTimeFormat
	private Date rysj;
	
	@Transient
	private String rysjStr;
	
	/*鐥呬汉鐘舵�� 鍦ㄩ櫌 --- 1锛屽嚭闄�---0锛屾浜� --9*/
	@Column(name="c_brzt")
	private String brzt;
	
	/*鎷熷嚭闄㈡棩鏈�*/
	@Column(name="c_ncyrq")
	@DateTimeFormat
	private Date ncycq;

	/*鍑洪櫌鏃堕棿*/
	@Column(name="c_cysj")
	@DateTimeFormat
	private Date cysj;
	
	@Transient
	private String cysjStr;
	
	/*鍑洪櫌绫诲瀷 1--娌绘剤鍑洪櫌 2--杞叆浠栭櫌 3--瀹跺睘瑕佹眰鍑洪櫌*/
	@Column(name="c_cylx")
	private String cylx;

	/*姝讳骸鏃堕棿*/
	@Column(name="c_swsj")
	@DateTimeFormat
	private Date swsj;

	/*姝讳骸鍘熷洜*/
	@Column(name="c_swyy")
	private String swyy;
	
	/*鎶㈡晳鎺柦*/
	@Column(name="c_qjcs")
	private String qjcs;
	
	/*涓荤鍖荤敓ID*/
	@Column(name="c_zgysid")
	private String zgysid;
	
	/*涓荤鍖荤敓*/
	@Column(name="c_zyys")
	private String zyys;
	
	/*涓荤鎶ゅ＋ID*/
	@Column(name="c_zghsid")
	private String zghsid;
	
	/*涓荤鎶ゅ＋*/
	@Column(name="c_zghs")
	private String zghs;
	
	/*涓昏瘔*/
	@Column(name="c_zs")
	private String zs;
	
	/*涓昏璇婃柇*/
	@Column(name="c_zyzd")
	private String zyzd;
	
	/*澶囨敞*/
	@Column(name="c_bz")
	private String bz;
	
	/*鎵�灞為儴闂↖D*/
	@Column(name="c_bmid")
	private String bmid;
	
	/*鍘熸墍灞為儴闂↖D*/
	@Column(name="c_ybmid")
	private String ybmid;
	
	/*鍘熼儴闂ㄥ�肩彮鎶ゅ＋ID*/
	@Column(name="c_ybmzbhsid")
	private String ybmzbhsid;
	
	/*鍘熼儴闂ㄥ�肩彮鍖荤敓ID*/
	@Column(name="c_ybmzbysid")
	private String ybmzbysid;
	
	/*杞叆鏃ユ湡*/
	@Column(name="c_zrrq")
	@DateTimeFormat
	private Date zrrq;
	
	/*鍊肩彮鍖荤敓ID*/
	@Column(name="c_zbysid")
	private String zbysid;
	
	/*鍊肩彮鍖荤敓*/
	@Column(name="c_zbys")
	private String zbys;
	
	/*鍊肩彮鎶ゅ＋ID*/
	@Column(name="c_zbhsid")
	private String zbhsid;
	
	/*鍊肩彮鎶ゅ＋*/
	@Column(name="c_zbhs")
	private String zbhs;
	
	/*鍏抽棴鏍囧織*/
	@Column(name="c_gbbz")
	private String gbbz;

	/*鍖讳繚绫诲瀷 0-鍖讳繚锛�1-鑷垂*/
	@Column(name="c_yblx")
	private String yblx;
	
	@Column(name="c_email")
	private String email;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
