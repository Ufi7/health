package com.fc.exch.model;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ExConstants {
	
	public final static String EXCHANGE_STATUS_DRAFT_00 = "00";
	public final static String EXCHANGE_STATUS_DRAWBACK_01 = "01";
	public final static String EXCHANGE_STATUS_SUBMITTED_10 = "10";
	public final static String EXCHANGE_STATUS_FINALIZED_11 = "11";
	public final static String EXCHANGE_STATUS_INVALID_90 = "90";
	public final static DateTimeFormatter DATEFORMMATER = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA);
	public final static SimpleDateFormat SIMPLEDATEFORMATER = new SimpleDateFormat("yyyy-MM-dd");

}
