package com.lc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lc.dao.CustomerLossDao;
import com.lc.entity.CustomerLoss;
import com.lc.service.CustomerLossService;

@Service("customerLossService")
public class CustomerLossServiceImpl implements CustomerLossService{

	@Resource
	private CustomerLossDao customerLossDao;
	
	public List<CustomerLoss> find(Map<String, Object> map) {
		return customerLossDao.find(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return customerLossDao.getTotal(map);
	}

	@Override
	public int update(CustomerLoss customerLoss) {
		
		return customerLossDao.update(customerLoss);
	}

	@Override
	public CustomerLoss findById(Integer id) {
		
		return customerLossDao.findById(id);
	}
}
