package com.lc.service;


import java.util.List;
import java.util.Map;

import com.lc.entity.CustomerService;
/**
 * 客户Service实现
 * @author 
 *
 */
public interface CustomerServiceService {
	
	/**
	 * 客户添加
	 * @param customer
	 * @return
	 */
	public int add(CustomerService customerService);
	

	/**
	 * 查询客户服务集合
	 * @param map
	 * @return
	 */
	
	public List<CustomerService> find(Map<String, Object> map);
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * 客户服务修改
	 * @param customerService
	 * @return
	 */
	public int update(CustomerService customerService);
 }
