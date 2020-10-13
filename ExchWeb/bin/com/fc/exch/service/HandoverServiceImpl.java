package com.fc.exch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fc.core.model.PagedList;
import com.fc.exch.dao.HandoverDao;
import com.fc.exch.model.ExchangeEntity;

@Service
@Transactional
public class HandoverServiceImpl implements HandoverService {

	@Autowired
	private HandoverDao handoverDao;
	
	@Override
	public PagedList getHandoverList(PagedList pagedList, ExchangeEntity exchange, String userId) {
		return handoverDao.getHandoverList(pagedList, exchange, userId);
	}

}
