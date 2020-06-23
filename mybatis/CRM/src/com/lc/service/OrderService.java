package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.Order;
/**
 * 客户历史订单Service接口
 * @author 
 *
 */
public interface OrderService {
	/**
	 * 查询客户历史订单集合
	 * @param map
	 * @return
	 */
	public List<Order> find(Map<String, Object> map);
	/**
	 * 查询客户历史订单总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * 根据Id查询客户
	 * @param id
	 * @return
	 */
	public Order findById(Integer id);
 }
