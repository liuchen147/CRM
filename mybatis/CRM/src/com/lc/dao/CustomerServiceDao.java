package com.lc.dao;



import java.util.List;
import java.util.Map;

import com.lc.entity.CustomerService;


/**
 * �û�Dao�ӿ�
 * @author 
 *
 */
public interface CustomerServiceDao {
	/**
	 * ��ӿͻ�����
	 * @param customerService
	 * @return
	 */
	public int add(CustomerService customerService);
	
	/**
	 * ��ѯ�ͻ����񼯺�
	 * @param map
	 * @return
	 */
	
	public List<CustomerService> find(Map<String, Object> map);
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * �ͻ������޸�
	 * @param customerService
	 * @return
	 */
	public int update(CustomerService customerService);
	
	
 }
