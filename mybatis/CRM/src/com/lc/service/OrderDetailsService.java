package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.OrderDetails;

public interface OrderDetailsService {
	/**
	 * ��ѯ�������鼯��
	 * @param map
	 * @return
	 */
	public List<OrderDetails> find(Map<String, Object> map);
	/**
	 * ��ѯ���������ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	/**
	 * ��ȡ�ܽ��
	 * @param orderId
	 * @return
	 */
	public float getTotalPriceByOrderId(Integer orderId);
}
