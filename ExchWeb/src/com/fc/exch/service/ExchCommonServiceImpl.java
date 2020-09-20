package com.fc.exch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fc.exch.model.ExchSetting;

/**
 * 交接班基础服务
 * @author 98408
 *
 */
@Service
@Transactional
public class ExchCommonServiceImpl implements ExchCommonService {

	@Override
	public ExchSetting getSetting() {
		// TODO Auto-generated method stub
		return new ExchSetting();
	}

}
