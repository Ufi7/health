package com.fc.exch.service;

import com.fc.exch.model.ExchSetting;

/**
 * 交接班普通服务
 * @author 98408
 *
 */
public interface ExchCommonService {

	/**
	 * 获得交接班全局设置
	 * @return
	 */
	ExchSetting getSetting();
}
