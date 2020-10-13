package com.fc.exch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 交接班记录表
 */
@Entity
@Table(name="t_exchange")
public class ExchangeEntity {
    /*交接班记录ID*/
	@Id
	@Column(name="c_exch_id")
    private String exchId;

    /*交班日期*/
	@Column(name="c_jbrq")
    private Date jbrq;

    /*交班护士ID*/
	@Column(name="c_jbhsid")
    private String jbhsid;

    /*交班护士*/
	@Column(name="c_jbhs")
    private String jbhs;

    /*接班护士ID*/
	@Column(name="c_jbhsid2")
    private String jbhsid2;

    /*接班护士*/
	@Column(name="c_jbhs2")
    private String jbhs2;

    /*现有病人数*/
	@Column(name="c_xybrs")
    private Integer xybrs;

    /*原有病人数*/
	@Column(name="c_yybrs")
    private Integer yybrs;

    /*新入院病人*/
	@Column(name="c_xrybr")
    private Integer xrybr;

    /*转入病人*/
	@Column(name="c_zrbr")
    private Integer zrbr;

    /*出院病人*/
	@Column(name="c_cybr")
    private Integer cybr;

    /*转出病人*/
	@Column(name="c_zcbr")
    private Integer zcbr;

    /*死亡病人数*/
	@Column(name="c_swbrs")
    private Integer swbrs;

    /*病危人数*/
	@Column(name="c_bwrs")
    private Integer bwrs;

    /*病重人数*/
	@Column(name="c_bzrs")
    private Integer bzrs;

    /*一级护理*/
	@Column(name="c_yjhl")
    private Integer yjhl;

    /*手术病人*/
	@Column(name="c_ssbr")
    private Integer ssbr;

    /*拟手术病人*/
	@Column(name="c_nssbr")
    private Integer nssbr;

    /*劝阻无效外出-社保*/
	@Column(name="c_qzwxwc_sb")
    private Integer qzwxwcSb;

    /*劝阻无效外出-自费*/
	@Column(name="c_qzwxwc_zf")
    private Integer qzwxwcZf;

    /*欠费预警（自费）*/
	@Column(name="c_qfyj")
    private Integer qfyj;

    /*重度疼痛*/
	@Column(name="c_zdtt")
    private Integer zdtt;

    /*观察肌力感觉*/
	@Column(name="c_gcjlgj")
    private Integer gcjlgj;

    /*特殊检查*/
	@Column(name="c_tsjc")
    private Integer tsjc;

    /*特殊治疗*/
	@Column(name="c_tszl")
    private Integer tszl;

    /*防压疮*/
	@Column(name="c_fyc")
    private Integer fyc;

    /*防跌倒*/
    @Column(name="c_fdt")
    private Integer fdt;

    /*深静脉置管*/
    @Column(name="c_sjmzg")
    private Integer sjmzg;

    /*危急值报告*/
    @Column(name="c_wjzbg")
    private Integer wjzbg;

    /*多重耐药性*/
    @Column(name="c_dcnyx")
    private Integer dcnyx;

    /*不良事件*/
    @Column(name="c_blsj")
    private Integer blsj;

    /*应急设备状态*/
    @Column(name="c_yjsbzt")
    private String yjsbzt;

    /*应急设备备注*/
    @Column(name="c_yjsbbz")
    private String yjsbbz;

    /**状态
     *00--草稿
	 *01--退回
	 *10--待接班
	 *11-已完成
	 *90-已过期   ----草稿数据只有当天有效
	 */
    @Column(name="c_status")
    private String status;

    /*所属部门编码*/
    @Column(name="c_dept_code")
    private String deptCode;

    @Transient
    private String jbrqBegin;
    
    @Transient
    private String jbrqEnd;
    
	public String getExchId() {
		return exchId;
	}

	public void setExchId(String exchId) {
		this.exchId = exchId;
	}

	public Date getJbrq() {
		return jbrq;
	}

	public void setJbrq(Date jbrq) {
		this.jbrq = jbrq;
	}

	public String getJbhsid() {
		return jbhsid;
	}

	public void setJbhsid(String jbhsid) {
		this.jbhsid = jbhsid;
	}

	public String getJbhs() {
		return jbhs;
	}

	public void setJbhs(String jbhs) {
		this.jbhs = jbhs;
	}

	public String getJbhsid2() {
		return jbhsid2;
	}

	public void setJbhsid2(String jbhsid2) {
		this.jbhsid2 = jbhsid2;
	}

	public String getJbhs2() {
		return jbhs2;
	}

	public void setJbhs2(String jbhs2) {
		this.jbhs2 = jbhs2;
	}

	public Integer getXybrs() {
		return xybrs;
	}

	public void setXybrs(Integer xybrs) {
		this.xybrs = xybrs;
	}

	public Integer getYybrs() {
		return yybrs;
	}

	public void setYybrs(Integer yybrs) {
		this.yybrs = yybrs;
	}

	public Integer getXrybr() {
		return xrybr;
	}

	public void setXrybr(Integer xrybr) {
		this.xrybr = xrybr;
	}

	public Integer getZrbr() {
		return zrbr;
	}

	public void setZrbr(Integer zrbr) {
		this.zrbr = zrbr;
	}

	public Integer getCybr() {
		return cybr;
	}

	public void setCybr(Integer cybr) {
		this.cybr = cybr;
	}

	public Integer getZcbr() {
		return zcbr;
	}

	public void setZcbr(Integer zcbr) {
		this.zcbr = zcbr;
	}

	public Integer getSwbrs() {
		return swbrs;
	}

	public void setSwbrs(Integer swbrs) {
		this.swbrs = swbrs;
	}

	public Integer getBwrs() {
		return bwrs;
	}

	public void setBwrs(Integer bwrs) {
		this.bwrs = bwrs;
	}

	public Integer getBzrs() {
		return bzrs;
	}

	public void setBzrs(Integer bzrs) {
		this.bzrs = bzrs;
	}

	public Integer getYjhl() {
		return yjhl;
	}

	public void setYjhl(Integer yjhl) {
		this.yjhl = yjhl;
	}

	public Integer getSsbr() {
		return ssbr;
	}

	public void setSsbr(Integer ssbr) {
		this.ssbr = ssbr;
	}

	public Integer getNssbr() {
		return nssbr;
	}

	public void setNssbr(Integer nssbr) {
		this.nssbr = nssbr;
	}

	public Integer getQzwxwcSb() {
		return qzwxwcSb;
	}

	public void setQzwxwcSb(Integer qzwxwcSb) {
		this.qzwxwcSb = qzwxwcSb;
	}

	public Integer getQzwxwcZf() {
		return qzwxwcZf;
	}

	public void setQzwxwcZf(Integer qzwxwcZf) {
		this.qzwxwcZf = qzwxwcZf;
	}

	public Integer getQfyj() {
		return qfyj;
	}

	public void setQfyj(Integer qfyj) {
		this.qfyj = qfyj;
	}

	public Integer getZdtt() {
		return zdtt;
	}

	public void setZdtt(Integer zdtt) {
		this.zdtt = zdtt;
	}

	public Integer getGcjlgj() {
		return gcjlgj;
	}

	public void setGcjlgj(Integer gcjlgj) {
		this.gcjlgj = gcjlgj;
	}

	public Integer getTsjc() {
		return tsjc;
	}

	public void setTsjc(Integer tsjc) {
		this.tsjc = tsjc;
	}

	public Integer getTszl() {
		return tszl;
	}

	public void setTszl(Integer tszl) {
		this.tszl = tszl;
	}

	public Integer getFyc() {
		return fyc;
	}

	public void setFyc(Integer fyc) {
		this.fyc = fyc;
	}

	public Integer getFdt() {
		return fdt;
	}

	public void setFdt(Integer fdt) {
		this.fdt = fdt;
	}

	public Integer getSjmzg() {
		return sjmzg;
	}

	public void setSjmzg(Integer sjmzg) {
		this.sjmzg = sjmzg;
	}

	public Integer getWjzbg() {
		return wjzbg;
	}

	public void setWjzbg(Integer wjzbg) {
		this.wjzbg = wjzbg;
	}

	public Integer getDcnyx() {
		return dcnyx;
	}

	public void setDcnyx(Integer dcnyx) {
		this.dcnyx = dcnyx;
	}

	public Integer getBlsj() {
		return blsj;
	}

	public void setBlsj(Integer blsj) {
		this.blsj = blsj;
	}

	public String getYjsbzt() {
		return yjsbzt;
	}

	public void setYjsbzt(String yjsbzt) {
		this.yjsbzt = yjsbzt;
	}

	public String getYjsbbz() {
		return yjsbbz;
	}

	public void setYjsbbz(String yjsbbz) {
		this.yjsbbz = yjsbbz;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getJbrqBegin() {
		return jbrqBegin;
	}

	public void setJbrqBegin(String jbrqBegin) {
		this.jbrqBegin = jbrqBegin;
	}

	public String getJbrqEnd() {
		return jbrqEnd;
	}

	public void setJbrqEnd(String jbrqEnd) {
		this.jbrqEnd = jbrqEnd;
	}

}