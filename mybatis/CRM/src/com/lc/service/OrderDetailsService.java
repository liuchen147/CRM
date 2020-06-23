package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.OrderDetails;

public interface OrderDetailsService {
	/**
	 * 查询订单详情集合
	 * @param map
	 * @return
	 */
	public List<OrderDetails> find(Map<String, Object> map);
	/**
	 * 查询订单详情总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	/**
	 * 获取总金额
	 * @param orderId
	 * @return
	 */
	public float getTotalPriceByOrderId(Integer orderId);
}
