package com.lc.dao;



import java.util.List;
import java.util.Map;

import com.lc.entity.CustomerService;


/**
 * 用户Dao接口
 * @author 
 *
 */
public interface CustomerServiceDao {
	/**
	 * 添加客户服务
	 * @param customerService
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
