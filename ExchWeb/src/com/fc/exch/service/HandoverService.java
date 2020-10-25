package com.fc.exch.service;

import com.fc.core.model.PagedList;
import com.fc.exch.model.ExchangeEntity;
import com.fc.sysmanager.model.User;

/**
 * 交接班管理service
 */
public interface HandoverService {

	//获取交班管理信息列表
	PagedList getHandoverList(PagedList pagedList, ExchangeEntity exchange, String userId);
	
}
