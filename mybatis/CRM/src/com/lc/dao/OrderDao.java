package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.Customer;
import com.lc.entity.Order;
import com.lc.entity.SaleChance;
/**
 * 客户历史订单Dao接口
 * @author 
 *
 */
public interface OrderDao {
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
	/**
	 * 查询指定客户最近下的单
	 * @param cusId
	 * @return
	 */
	public Order findLastOrderByCusId(int cusId);
 }
