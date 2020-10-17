package com.fc.exch.service;

public class RefreshExchangeStatisThread extends Thread {
	private ExchangeService exService;
	private String exchangeId;
	
	public RefreshExchangeStatisThread(ExchangeService exService,String exchangeId){
		this.exService=exService;
		this.exchangeId=exchangeId;
	}

	public ExchangeService getExService() {
		return exService;
	}

	public void setExService(ExchangeService exService) {
		this.exService = exService;
	}

	public String getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}
	
	public void run(){
		this.exService.updateStatis(exchangeId);
	}
	
}
