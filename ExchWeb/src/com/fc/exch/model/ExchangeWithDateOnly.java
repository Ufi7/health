package com.fc.exch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_exchange")
public class ExchangeWithDateOnly {
	@Id
	@Column(name="c_exch_id")
	private String exchangeId;
	
	@Column(name="c_jbrq")
    private Date c_jbrq;
	
	@Column(name="c_jbhsid")
    private String c_jbhsid;
	
	@Column(name="c_jbhs")
    private String c_jbhs;

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
}
