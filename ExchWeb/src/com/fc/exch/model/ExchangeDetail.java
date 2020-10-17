package com.fc.exch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_detail_info")
public class ExchangeDetail implements Cloneable{
	public String getExchangeDetailId() {
		return exchangeDetailId;
	}

	public void setExchangeDetailId(String exchangeDetailId) {
		this.exchangeDetailId = exchangeDetailId;
	}

//	public String getC_zyh() {
//		return c_zyh;
//	}
//
//	public void setC_zyh(String c_zyh) {
//		this.c_zyh = c_zyh;
//	}

	public String getC_exch_id() {
		return c_exch_id;
	}

	public void setC_exch_id(String c_exch_id) {
		this.c_exch_id = c_exch_id;
	}

	public int getC_xry() {
		return c_xry;
	}

	public void setC_xry(int c_xry) {
		this.c_xry = c_xry;
	}

	public int getC_zr() {
		return c_zr;
	}

	public void setC_zr(int c_zr) {
		this.c_zr = c_zr;
	}

	public int getC_cy() {
		return c_cy;
	}

	public void setC_cy(int c_cy) {
		this.c_cy = c_cy;
	}

	public int getC_zc() {
		return c_zc;
	}

	public void setC_zc(int c_zc) {
		this.c_zc = c_zc;
	}

	public int getC_sw() {
		return c_sw;
	}

	public void setC_sw(int c_sw) {
		this.c_sw = c_sw;
	}

	public int getC_bqdj() {
		return c_bqdj;
	}

	public void setC_bqdj(int c_bqdj) {
		this.c_bqdj = c_bqdj;
	}

	public int getC_hldj() {
		return c_hldj;
	}

	public void setC_hldj(int c_hldj) {
		this.c_hldj = c_hldj;
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

	public int getC_qzwxwc() {
		return c_qzwxwc;
	}

	public void setC_qzwxwc(int c_qzwxwc) {
		this.c_qzwxwc = c_qzwxwc;
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

	public int getC_nrs() {
		return c_nrs;
	}

	public void setC_nrs(int c_nrs) {
		this.c_nrs = c_nrs;
	}

	public int getC_gcjlgj() {
		return c_gcjlgj;
	}

	public void setC_gcjlgj(int c_gcjlgj) {
		this.c_gcjlgj = c_gcjlgj;
	}

	public int getC_jl() {
		return c_jl;
	}

	public void setC_jl(int c_jl) {
		this.c_jl = c_jl;
	}

	public int getC_gj() {
		return c_gj;
	}

	public void setC_gj(int c_gj) {
		this.c_gj = c_gj;
	}

	public int getC_tsjc() {
		return c_tsjc;
	}

	public void setC_tsjc(int c_tsjc) {
		this.c_tsjc = c_tsjc;
	}

	public String getC_tsjcnr() {
		return c_tsjcnr;
	}

	public void setC_tsjcnr(String c_tsjcnr) {
		this.c_tsjcnr = c_tsjcnr;
	}

	public int getC_tszl() {
		return c_tszl;
	}

	public void setC_tszl(int c_tszl) {
		this.c_tszl = c_tszl;
	}

	public String getC_tszlnr() {
		return c_tszlnr;
	}

	public void setC_tszlnr(String c_tszlnr) {
		this.c_tszlnr = c_tszlnr;
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

	public int getC_fdtpf() {
		return c_fdtpf;
	}

	public void setC_fdtpf(int c_fdtpf) {
		this.c_fdtpf = c_fdtpf;
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

	public String getC_dcnyxbz() {
		return c_dcnyxbz;
	}

	public void setC_dcnyxbz(String c_dcnyxbz) {
		this.c_dcnyxbz = c_dcnyxbz;
	}

	public int getC_blsj() {
		return c_blsj;
	}

	public void setC_blsj(int c_blsj) {
		this.c_blsj = c_blsj;
	}

	public String getC_blsjbz() {
		return c_blsjbz;
	}

	public void setC_blsjbz(String c_blsjbz) {
		this.c_blsjbz = c_blsjbz;
	}

	public String getC_hlnr() {
		return c_hlnr;
	}

	public void setC_hlnr(String c_hlnr) {
		this.c_hlnr = c_hlnr;
	}

	public String getC_bqnr() {
		return c_bqnr;
	}

	public void setC_bqnr(String c_bqnr) {
		this.c_bqnr = c_bqnr;
	}

	public int getC_hltsbz() {
		return c_hltsbz;
	}

	public void setC_hltsbz(int c_hltsbz) {
		this.c_hltsbz = c_hltsbz;
	}

	public int getC_ystsbz() {
		return c_ystsbz;
	}

	public void setC_ystsbz(int c_ystsbz) {
		this.c_ystsbz = c_ystsbz;
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
	
	

	public Patient0 getPatient() {
		return patient;
	}

	public void setPatient(Patient0 patient) {
		this.patient = patient;
	}



	@Id
	@Column(name="detail_info_id")
	private String exchangeDetailId;
	
//	@Column(name="c_zyh")
//    private String c_zyh;
	
	//@ManyToOne
    //@JoinColumn(name="c_zyh",unique=true)
	@ManyToOne(targetEntity = Patient0.class )
	@JoinColumn(name="c_zyh", referencedColumnName="c_zyh")
    private Patient0 patient;
	
	@Column(name="c_exch_id")
    private String c_exch_id;
	
	@Column(name="c_xry")
	private int c_xry;
    
	@Column(name="c_zr")
	private int c_zr;
	
	@Column(name="c_cy")
    private int c_cy;
	
	@Column(name="c_zc")
    private int c_zc;
	
	@Column(name="c_sw")
    private int c_sw;
	
	@Column(name="c_bqdj")
    private int c_bqdj;
	
	@Column(name="c_hldj")
    private int c_hldj;
	
	@Column(name="c_ssbr")
    private int c_ssbr;
	
	@Column(name="c_nssbr")
    private int c_nssbr;

	@Column(name="c_qzwxwc")
    private int c_qzwxwc;
	
	@Column(name="c_qfyj")
    private int c_qfyj;
	
	@Column(name="c_zdtt")
    private int c_zdtt;
	
	@Column(name="c_nrs")
    private int c_nrs;
	
	@Column(name="c_gcjlgj")
    private int c_gcjlgj;
	
	@Column(name="c_jl")
    private int c_jl;
	
	@Column(name="c_gj")
    private int c_gj;
	
	@Column(name="c_tsjc")
    private int c_tsjc;
	
	@Column(name="c_tsjcnr")
    private String c_tsjcnr;
	
	@Column(name="c_tszl")
    private int c_tszl;
	
	@Column(name="c_tszlnr")
    private String c_tszlnr;
	
	@Column(name="c_fyc")
    private int c_fyc;
	
	@Column(name="c_fdt")
    private int c_fdt;
	
	@Column(name="c_fdtpf")
    private int c_fdtpf;
	
	@Column(name="c_sjmzg")
    private int c_sjmzg;
	
	@Column(name="c_wjzbg")
    private int c_wjzbg;
	
	@Column(name="c_dcnyx")
    private int c_dcnyx;
	
	@Column(name="c_dcnyxbz")
    private String c_dcnyxbz;
	
	@Column(name="c_blsj")
    private int c_blsj;
	
	@Column(name="c_blsjbz")
    private String c_blsjbz;
	
	@Column(name="c_hlnr")
    private String c_hlnr;
	
	@Column(name="c_bqnr")
    private String c_bqnr;
	
	@Column(name="c_hltsbz")
    private int c_hltsbz;
	
	@Column(name="c_ystsbz")
    private int c_ystsbz;
	
	@Column(name="c_status")
    private String c_status;
	
	@Column(name="c_dept_code")
    private String c_dept_code;
	
	 @Override  
	    public Object clone() {  
		 ExchangeDetail exd = null;  
	        try{  
	        	exd = (ExchangeDetail)super.clone();  
	        }catch(CloneNotSupportedException e) {  
	            e.printStackTrace();  
	        }  
	        exd.setExchangeDetailId(null);
	        return exd;  
	    }  
}
