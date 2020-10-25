package com.fc.exch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_exchange")
public class Exchange implements Cloneable{
	@Id
	@Column(name="c_exch_id")
	private String exchangeId;
	
	@Column(name="c_jbrq")
    private Date c_jbrq;

	@Column(name="c_jbhsid")
    private String c_jbhsid;
	
	@Column(name="c_jbhs")
    private String c_jbhs;
	
	@Column(name="c_jbhsid2")
    private String c_jbhsid2;
	
	@Column(name="c_jbhs2")
    private String c_jbhs2;
    
	@Column(name="c_xybrs")
	private int c_xybrs;
    
	@Column(name="c_yybrs")
    private int c_yybrs;
	
	@Column(name="c_xrybr")
    private int c_xrybr;
	
	@Column(name="c_zrbr")
    private int c_zrbr;
	
	@Column(name="c_cybr")
    private int c_cybr;
	
	@Column(name="c_zcbr")
    private int c_zcbr;
	
	@Column(name="c_swbrs")
    private int c_swbrs;
	
	@Column(name="c_bwrs")
    private int c_bwrs;
	
	@Column(name="c_bzrs")
    private int c_bzrs;
	
	@Column(name="c_yjhl")
    private int c_yjhl;
	
	@Column(name="c_ssbr")
    private int c_ssbr;
	
	@Column(name="c_nssbr")
    private int c_nssbr;
	
	@Column(name="c_qzwxwc_sb")
    private int c_qzwxwc_sb;
	
	@Column(name="c_qzwxwc_zf")
    private int c_qzwxwc_zf;
	
	@Column(name="c_qfyj")
    private int c_qfyj;
	
	@Column(name="c_zdtt")
    private int c_zdtt;
	
	@Column(name="c_gcjlgj")
    private int c_gcjlgj;
	
	@Column(name="c_tsjc")
    private int c_tsjc;
	
	@Column(name="c_tszl")
    private int c_tszl;
	
	@Column(name="c_fyc")
    private int c_fyc;
	
	@Column(name="c_fdt")
    private int c_fdt;
	
	@Column(name="c_sjmzg")
    private int c_sjmzg;
	
	@Column(name="c_wjzbg")
    private int c_wjzbg;
	
	@Column(name="c_dcnyx")
    private int c_dcnyx;
	
	@Column(name="c_blsj")
    private int c_blsj;
	
	@Column(name="c_yjsbzt")
    private String c_yjsbzt;
	
	@Column(name="c_yjsbbz")
    private String c_yjsbbz;
	
	@Column(name="c_status")
    private String c_status;
	
	@Column(name="c_dept_code")
    private String c_dept_code;

	public String getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}

	public Date getC_jbrq() {
		return c_jbrq;
	}

	public void setC_jbrq(Date c_jbrq) {
		this.c_jbrq = c_jbrq;
	}

	public String getC_jbhsid() {
		return c_jbhsid;
	}

	public void setC_jbhsid(String c_jbhsid) {
		this.c_jbhsid = c_jbhsid;
	}

	public String getC_jbhs() {
		return c_jbhs;
	}

	public void setC_jbhs(String c_jbhs) {
		this.c_jbhs = c_jbhs;
	}

	public String getC_jbhsid2() {
		return c_jbhsid2;
	}

	public void setC_jbhsid2(String c_jbhsid2) {
		this.c_jbhsid2 = c_jbhsid2;
	}

	public String getC_jbhs2() {
		return c_jbhs2;
	}

	public void setC_jbhs2(String c_jbhs2) {
		this.c_jbhs2 = c_jbhs2;
	}

	public int getC_xybrs() {
		return c_xybrs;
	}

	public void setC_xybrs(int c_xybrs) {
		this.c_xybrs = c_xybrs;
	}

	public int getC_yybrs() {
		return c_yybrs;
	}

	public void setC_yybrs(int c_yybrs) {
		this.c_yybrs = c_yybrs;
	}

	public int getC_xrybr() {
		return c_xrybr;
	}

	public void setC_xrybr(int c_xrybr) {
		this.c_xrybr = c_xrybr;
	}

	public int getC_zrbr() {
		return c_zrbr;
	}

	public void setC_zrbr(int c_zrbr) {
		this.c_zrbr = c_zrbr;
	}

	public int getC_cybr() {
		return c_cybr;
	}

	public void setC_cybr(int c_cybr) {
		this.c_cybr = c_cybr;
	}

	public int getC_zcbr() {
		return c_zcbr;
	}

	public void setC_zcbr(int c_zcbr) {
		this.c_zcbr = c_zcbr;
	}

	public int getC_swbrs() {
		return c_swbrs;
	}

	public void setC_swbrs(int c_swbrs) {
		this.c_swbrs = c_swbrs;
	}

	public int getC_bwrs() {
		return c_bwrs;
	}

	public void setC_bwrs(int c_bwrs) {
		this.c_bwrs = c_bwrs;
	}

	public int getC_bzrs() {
		return c_bzrs;
	}

	public void setC_bzrs(int c_bzrs) {
		this.c_bzrs = c_bzrs;
	}

	public int getC_yjhl() {
		return c_yjhl;
	}

	public void setC_yjhl(int c_yjhl) {
		this.c_yjhl = c_yjhl;
	}

	public int getC_ssbr() {
		return c_ssbr;
	}

	public void setC_ssbr(int c_ssbr) {
		this.c_ssbr = c_ssbr;
	}

	public int getC_nssbr() {
		return c_nssbr;
	}

	public void setC_nssbr(int c_nssbr) {
		this.c_nssbr = c_nssbr;
	}

	public int getC_qzwxwc_sb() {
		return c_qzwxwc_sb;
	}

	public void setC_qzwxwc_sb(int c_qzwxwc_sb) {
		this.c_qzwxwc_sb = c_qzwxwc_sb;
	}

	public int getC_qzwxwc_zf() {
		return c_qzwxwc_zf;
	}

	public void setC_qzwxwc_zf(int c_qzwxwc_zf) {
		this.c_qzwxwc_zf = c_qzwxwc_zf;
	}

	public int getC_qfyj() {
		return c_qfyj;
	}

	public void setC_qfyj(int c_qfyj) {
		this.c_qfyj = c_qfyj;
	}

	public int getC_zdtt() {
		return c_zdtt;
	}

	public void setC_zdtt(int c_zdtt) {
		this.c_zdtt = c_zdtt;
	}

	public int getC_gcjlgj() {
		return c_gcjlgj;
	}

	public void setC_gcjlgj(int c_gcjlgj) {
		this.c_gcjlgj = c_gcjlgj;
	}

	public int getC_tsjc() {
		return c_tsjc;
	}

	public void setC_tsjc(int c_tsjc) {
		this.c_tsjc = c_tsjc;
	}

	public int getC_tszl() {
		return c_tszl;
	}

	public void setC_tszl(int c_tszl) {
		this.c_tszl = c_tszl;
	}

	public int getC_fyc() {
		return c_fyc;
	}

	public void setC_fyc(int c_fyc) {
		this.c_fyc = c_fyc;
	}

	public int getC_fdt() {
		return c_fdt;
	}

	public void setC_fdt(int c_fdt) {
		this.c_fdt = c_fdt;
	}

	public int getC_sjmzg() {
		return c_sjmzg;
	}

	public void setC_sjmzg(int c_sjmzg) {
		this.c_sjmzg = c_sjmzg;
	}

	public int getC_wjzbg() {
		return c_wjzbg;
	}

	public void setC_wjzbg(int c_wjzbg) {
		this.c_wjzbg = c_wjzbg;
	}

	public int getC_dcnyx() {
		return c_dcnyx;
	}

	public void setC_dcnyx(int c_dcnyx) {
		this.c_dcnyx = c_dcnyx;
	}

	public int getC_blsj() {
		return c_blsj;
	}

	public void setC_blsj(int c_blsj) {
		this.c_blsj = c_blsj;
	}

	public String getC_yjsbzt() {
		return c_yjsbzt;
	}

	public void setC_yjsbzt(String c_yjsbzt) {
		this.c_yjsbzt = c_yjsbzt;
	}

	public String getC_yjsbbz() {
		return c_yjsbbz;
	}

	public void setC_yjsbbz(String c_yjsbbz) {
		this.c_yjsbbz = c_yjsbbz;
	}

	public String getC_status() {
		return c_status;
	}

	public void setC_status(String c_status) {
		this.c_status = c_status;
	}

	public String getC_dept_code() {
		return c_dept_code;
	}

	public void setC_dept_code(String c_dept_code) {
		this.c_dept_code = c_dept_code;
	}
	
	
	 @Override  
	    public Object clone() {  
	        Exchange ex = null;  
	        try{  
	        	ex = (Exchange)super.clone();  
	        }catch(CloneNotSupportedException e) {  
	            e.printStackTrace();  
	        }  
	        ex.setExchangeId(null);
	        return ex;  
	    }  
}
