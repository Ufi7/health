package com.fc.exch.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_patient")
public class Patient0 implements Serializable{
	@Id
	@Column(name="c_brid")
	private String patientId;
	
	@Column(name="c_zyh")
	private String c_zyh;
	
	@Column(name="c_ch")
    private String c_ch;
	
	@Column(name="c_brxm")
    private String c_brxm;
    
	@Column(name="c_csrq")
	private Date c_csrq;
    
	@Column(name="c_xb")
    private String c_xb;
    
    @Column(name="c_lxr")
    private String c_lxr;
    
    @Column(name="c_lxdh")
    private String c_lxdh;
    
    @Column(name="c_lxdz")
    private String c_lxdz;
    
    @Column(name="c_rysj")
    private Date c_rysj;
    
	@Column(name="c_brzt")
    private int c_brzt;
    
    @Column(name="c_ncyrq")
    private Date c_ncyrq;
    
    @Column(name="c_cysj")
    private Date c_cysj;
    
    @Column(name="c_cylx")
    private int c_cylx;
    
    @Column(name="c_swsj")
    private Date c_swsj;
    
    @Column(name="c_swyy")
    private String c_swyy;
    
    @Column(name="c_qjcs")
    private String c_qjcs;
    
    @Column(name="c_zgysid")
    private String c_zgysid;
    
    @Column(name="c_zyys")
    private String c_zyys;
    
    @Column(name="c_zghsid")
    private String c_zghsid;
    
    @Column(name="c_zghs")
    private String c_zghs;
    
    @Column(name="c_zs")
    private String c_zs;
    
    @Column(name="c_zyzd")
    private String c_zyzd;
    
    @Column(name="c_bz")
    private String c_bz;
    
    @Column(name="c_bmid")
    private String c_bmid;
    
    @Column(name="c_ybmid")
    private String c_ybmid;
    
    @Column(name="c_ybmzbhsid")
    private String c_ybmzbhsid;
    
    @Column(name="c_ybmzbysid")
    private String c_ybmzbysid;

    @Column(name="c_zrrq")
    private String c_zrrq;
   
    @Column(name="c_zbysid")
    private String c_zbysid;
    
    @Column(name="c_zbys")
    private String c_zbys;
    
    @Column(name="c_zbhsid")
    private String c_zbhsid;
    
    @Column(name="c_zbhs")
    private String c_zbhs;
    
    @Column(name="c_gbbz")
    private int c_gbbz;
    
    @Column(name="c_yblx")
	private String c_yblx;

	public String getC_yblx() {
		return c_yblx;
	}

	public void setC_yblx(String c_yblx) {
		this.c_yblx = c_yblx;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getC_zyh() {
		return c_zyh;
	}

	public void setC_zyh(String c_zyh) {
		this.c_zyh = c_zyh;
	}

	public String getC_ch() {
		return c_ch;
	}

	public void setC_ch(String c_ch) {
		this.c_ch = c_ch;
	}

	public String getC_brxm() {
		return c_brxm;
	}

	public void setC_brxm(String c_brxm) {
		this.c_brxm = c_brxm;
	}

	public Date getC_csrq() {
		return c_csrq;
	}

	public void setC_csrq(Date c_csrq) {
		this.c_csrq = c_csrq;
	}

	public String getC_xb() {
		return c_xb;
	}

	public void setC_xb(String c_xb) {
		this.c_xb = c_xb;
	}

	public String getC_lxr() {
		return c_lxr;
	}

	public void setC_lxr(String c_lxr) {
		this.c_lxr = c_lxr;
	}

	public String getC_lxdh() {
		return c_lxdh;
	}

	public void setC_lxdh(String c_lxdh) {
		this.c_lxdh = c_lxdh;
	}

	public String getC_lxdz() {
		return c_lxdz;
	}

	public void setC_lxdz(String c_lxdz) {
		this.c_lxdz = c_lxdz;
	}

	public Date getC_rysj() {
		return c_rysj;
	}

	public void setC_rysj(Date c_rysj) {
		this.c_rysj = c_rysj;
	}

	public int getC_brzt() {
		return c_brzt;
	}

	public void setC_brzt(int c_brzt) {
		this.c_brzt = c_brzt;
	}

	public Date getC_ncyrq() {
		return c_ncyrq;
	}

	public void setC_ncyrq(Date c_ncyrq) {
		this.c_ncyrq = c_ncyrq;
	}

	public Date getC_cysj() {
		return c_cysj;
	}

	public void setC_cysj(Date c_cysj) {
		this.c_cysj = c_cysj;
	}

	public int getC_cylx() {
		return c_cylx;
	}

	public void setC_cylx(int c_cylx) {
		this.c_cylx = c_cylx;
	}

	public Date getC_swsj() {
		return c_swsj;
	}

	public void setC_swsj(Date c_swsj) {
		this.c_swsj = c_swsj;
	}

	public String getC_swyy() {
		return c_swyy;
	}

	public void setC_swyy(String c_swyy) {
		this.c_swyy = c_swyy;
	}

	public String getC_qjcs() {
		return c_qjcs;
	}

	public void setC_qjcs(String c_qjcs) {
		this.c_qjcs = c_qjcs;
	}

	public String getC_zgysid() {
		return c_zgysid;
	}

	public void setC_zgysid(String c_zgysid) {
		this.c_zgysid = c_zgysid;
	}

	public String getC_zyys() {
		return c_zyys;
	}

	public void setC_zyys(String c_zyys) {
		this.c_zyys = c_zyys;
	}

	public String getC_zghsid() {
		return c_zghsid;
	}

	public void setC_zghsid(String c_zghsid) {
		this.c_zghsid = c_zghsid;
	}

	public String getC_zghs() {
		return c_zghs;
	}

	public void setC_zghs(String c_zghs) {
		this.c_zghs = c_zghs;
	}

	public String getC_zs() {
		return c_zs;
	}

	public void setC_zs(String c_zs) {
		this.c_zs = c_zs;
	}

	public String getC_zyzd() {
		return c_zyzd;
	}

	public void setC_zyzd(String c_zyzd) {
		this.c_zyzd = c_zyzd;
	}

	public String getC_bz() {
		return c_bz;
	}

	public void setC_bz(String c_bz) {
		this.c_bz = c_bz;
	}

	public String getC_bmid() {
		return c_bmid;
	}

	public void setC_bmid(String c_bmid) {
		this.c_bmid = c_bmid;
	}

	public String getC_ybmid() {
		return c_ybmid;
	}

	public void setC_ybmid(String c_ybmid) {
		this.c_ybmid = c_ybmid;
	}

	public String getC_ybmzbhsid() {
		return c_ybmzbhsid;
	}

	public void setC_ybmzbhsid(String c_ybmzbhsid) {
		this.c_ybmzbhsid = c_ybmzbhsid;
	}

	public String getC_ybmzbysid() {
		return c_ybmzbysid;
	}

	public void setC_ybmzbysid(String c_ybmzbysid) {
		this.c_ybmzbysid = c_ybmzbysid;
	}

	public String getC_zrrq() {
		return c_zrrq;
	}

	public void setC_zrrq(String c_zrrq) {
		this.c_zrrq = c_zrrq;
	}

	public String getC_zbysid() {
		return c_zbysid;
	}

	public void setC_zbysid(String c_zbysid) {
		this.c_zbysid = c_zbysid;
	}

	public String getC_zbys() {
		return c_zbys;
	}

	public void setC_zbys(String c_zbys) {
		this.c_zbys = c_zbys;
	}

	public String getC_zbhsid() {
		return c_zbhsid;
	}

	public void setC_zbhsid(String c_zbhsid) {
		this.c_zbhsid = c_zbhsid;
	}

	public String getC_zbhs() {
		return c_zbhs;
	}

	public void setC_zbhs(String c_zbhs) {
		this.c_zbhs = c_zbhs;
	}

	public int getC_gbbz() {
		return c_gbbz;
	}

	public void setC_gbbz(int c_gbbz) {
		this.c_gbbz = c_gbbz;
	}
    
    
}
