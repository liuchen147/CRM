package com.lc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lc.dao.CustomerReprieveDao;
import com.lc.entity.CustomerReprieve;
import com.lc.service.CustomerReprieveService;


@Service("customerReprieveService")
public class CustomerReprieveServiceImpl implements CustomerReprieveService{

	@Resource
	private CustomerReprieveDao customerReprieveDao;

	@Override
	public List<CustomerReprieve> find(Map<String, Object> map) {
		
		return customerReprieveDao.find(map);
	}

	@Override
	public int add(CustomerReprieve customerReprieve) {
		
		return customerReprieveDao.add(customerReprieve);
	}

	@Override
	public int update(CustomerReprieve customerReprieve) {
		
		return customerReprieveDao.update(customerReprieve);
	}

	@Override
	public int delete(Integer id) {
		
		return delete(id);
	}
	
	
	
}
