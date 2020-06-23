package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.Customer;
import com.lc.entity.Order;
import com.lc.entity.SaleChance;
/**
 * �ͻ���ʷ����Dao�ӿ�
 * @author 
 *
 */
public interface OrderDao {
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
	/**
	 * ��ѯָ���ͻ�����µĵ�
	 * @param cusId
	 * @return
	 */
	public Order findLastOrderByCusId(int cusId);
 }
