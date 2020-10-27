package com.fc.exch.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fc.core.dao.hibernate.genericdao.impl.HCommonDao;

@Repository
public class ExchangeDaoImpl implements ExchangeDao {
	@Autowired
	private HCommonDao hdao;
	
	
}
