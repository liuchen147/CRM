package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.Order;
/**
 * �ͻ���ʷ����Service�ӿ�
 * @author 
 *
 */
public interface OrderService {
	/**
	 * ��ѯ�ͻ���ʷ��������
	 * @param map
	 * @return
	 */
	public List<Order> find(Map<String, Object> map);
	/**
	 * ��ѯ�ͻ���ʷ�����ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * ����Id��ѯ�ͻ�
	 * @param id
	 * @return
	 */
	public Order findById(Integer id);
 }
