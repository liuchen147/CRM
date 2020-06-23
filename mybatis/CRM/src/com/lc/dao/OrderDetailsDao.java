package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.OrderDetails;
/**
 * ��������Dao�ӿ�
 * @author 
 *
 */
public interface OrderDetailsDao {
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
