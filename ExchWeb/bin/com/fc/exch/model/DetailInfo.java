package com.fc.exch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 护理病情信息表
 */
@Entity
@Table(name="t_detail_info")
public class DetailInfo {
    /*记录ID*/
	@Id
	@Column(name="detail_info_id")
    private String detailInfoId;

    /*住院号*/
	@Column(name="c_zyh")
    private String zyh;

    /*交接班记录ID*/
	@Column(name="c_exch_id")
    private String exchId;

    /*新入院*/
	@Column(name="c_xry")
    private Integer xry;

    /*转入*/
	@Column(name="c_zr")
    private Integer zr;

    /*出院*/
	@Column(name="c_cy")
    private Integer cy;

    /*转出*/
	@Column(name="c_zc")
    private Integer zc;

    /*死亡*/
	@Column(name="c_sw")
    private Integer sw;

    /* 病情等级 0-普通 1-病重  2-病危*/
	@Column(name="c_bqdj")
	private Integer bqdj;

    /*护理等级 1-一级护理 2-二级护理 3-三级护理*/
	@Column(name="c_hldj")
	private Integer hldj;

    /*手术病人*/
	@Column(name="c_ssbr")
	private Integer ssbr;

    /*拟手术病人*/
	@Column(name="c_nssbr")
    private Integer nssbr;

    /*劝阻无效外出*/
	@Column(name="c_qzwxwc")
    private Integer qzwxwc;

    /*欠费预警*/
	@Column(name="c_qfyj")
    private Integer qfyj;

    /*重度疼痛*/
	@Column(name="c_zdtt")
    private Integer zdtt;

    /*NRS值*/
	@Column(name="c_nrs")
    private Integer nrs;

    /*观察肌力感觉*/
	@Column(name="c_gcjlgj")
    private Integer gcjlgj;

    /*肌力*/
	@Column(name="c_jl")
    private Integer jl;

    /*感觉*/
	@Column(name="c_gj")
    private Integer gj;

    /*特殊检查*/
	@Column(name="c_tsjc")
    private Integer tsjc;

    /*特殊检查内容*/
	@Column(name="c_tsjcnr")
    private String tsjcnr;

    /*特殊治疗*/
	@Column(name="c_tszl")
    private Integer tszl;

    /*特殊治疗内容*/
	@Column(name="c_tszlnr")
    private String tszlnr;

    /*防压疮*/
	@Column(name="c_fyc")
    private Integer fyc;

    /*防跌倒*/
	@Column(name="c_fdt")
    private Integer fdt;

    /*防跌倒评分*/
	@Column(name="c_fdtpf")
    private Integer fdtpf;

    /*深静脉置管*/
	@Column(name="c_sjmzg")
    private Integer sjmzg;

    /*危急值报告*/
	@Column(name="c_wjzbg")
    private Integer wjzbg;

    /*多重耐药菌*/
	@Column(name="c_dcnyx")
    private Integer dcnyx;

    /*多重耐药备注*/
	@Column(name="c_dcnyxbz")
    private String dcnyxbz;

    /*不良事件*/
	@Column(name="c_blsj")
    private Integer blsj;

    /*不良事件备注*/
	@Column(name="c_blsjbz")
    private String blsjbz;

    /*护理内容*/
	@Column(name="c_hlnr")
    private String hlnr;

    /*病情内容*/
	@Column(name="c_bqnr")
    private String bqnr;

    /**
     * 护理提示标志
     * 0--生成交接班表格时不提示，
	 * 1--生成交接班表格时提示
	 */
	@Column(name="c_hltsbz")
    private Integer hltsbz;

    /*ys提示标志*/
	@Column(name="c_ystsbz")
    private Integer ystsbz;

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

	public String getDetailInfoId() {
		return detailInfoId;
	}

	public void setDetailInfoId(String detailInfoId) {
		this.detailInfoId = detailInfoId;
	}

	public String getZyh() {
		return zyh;
	}

	public void setZyh(String zyh) {
		this.zyh = zyh;
	}

	public String getExchId() {
		return exchId;
	}

	public void setExchId(String exchId) {
		this.exchId = exchId;
	}

	public Integer getXry() {
		return xry;
	}

	public void setXry(Integer xry) {
		this.xry = xry;
	}

	public Integer getZr() {
		return zr;
	}

	public void setZr(Integer zr) {
		this.zr = zr;
	}

	public Integer getCy() {
		return cy;
	}

	public void setCy(Integer cy) {
		this.cy = cy;
	}

	public Integer getZc() {
		return zc;
	}

	public void setZc(Integer zc) {
		this.zc = zc;
	}

	public Integer getSw() {
		return sw;
	}

	public void setSw(Integer sw) {
		this.sw = sw;
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

	public Integer getQzwxwc() {
		return qzwxwc;
	}

	public void setQzwxwc(Integer qzwxwc) {
		this.qzwxwc = qzwxwc;
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

	public Integer getNrs() {
		return nrs;
	}

	public void setNrs(Integer nrs) {
		this.nrs = nrs;
	}

	public Integer getGcjlgj() {
		return gcjlgj;
	}

	public void setGcjlgj(Integer gcjlgj) {
		this.gcjlgj = gcjlgj;
	}

	public Integer getJl() {
		return jl;
	}

	public void setJl(Integer jl) {
		this.jl = jl;
	}

	public Integer getGj() {
		return gj;
	}

	public void setGj(Integer gj) {
		this.gj = gj;
	}

	public Integer getTsjc() {
		return tsjc;
	}

	public void setTsjc(Integer tsjc) {
		this.tsjc = tsjc;
	}

	public String getTsjcnr() {
		return tsjcnr;
	}

	public void setTsjcnr(String tsjcnr) {
		this.tsjcnr = tsjcnr;
	}

	public Integer getTszl() {
		return tszl;
	}

	public void setTszl(Integer tszl) {
		this.tszl = tszl;
	}

	public String getTszlnr() {
		return tszlnr;
	}

	public void setTszlnr(String tszlnr) {
		this.tszlnr = tszlnr;
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

	public Integer getFdtpf() {
		return fdtpf;
	}

	public void setFdtpf(Integer fdtpf) {
		this.fdtpf = fdtpf;
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

	public String getDcnyxbz() {
		return dcnyxbz;
	}

	public void setDcnyxbz(String dcnyxbz) {
		this.dcnyxbz = dcnyxbz;
	}

	public Integer getBlsj() {
		return blsj;
	}

	public void setBlsj(Integer blsj) {
		this.blsj = blsj;
	}

	public String getBlsjbz() {
		return blsjbz;
	}

	public void setBlsjbz(String blsjbz) {
		this.blsjbz = blsjbz;
	}

	public String getHlnr() {
		return hlnr;
	}

	public void setHlnr(String hlnr) {
		this.hlnr = hlnr;
	}

	public String getBqnr() {
		return bqnr;
	}

	public void setBqnr(String bqnr) {
		this.bqnr = bqnr;
	}

	public Integer getHltsbz() {
		return hltsbz;
	}

	public void setHltsbz(Integer hltsbz) {
		this.hltsbz = hltsbz;
	}

	public Integer getYstsbz() {
		return ystsbz;
	}

	public void setYstsbz(Integer ystsbz) {
		this.ystsbz = ystsbz;
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

}