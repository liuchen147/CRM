package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.Customer;
import com.lc.entity.CustomerLoss;
/**
 * �ͻ���ʧDao�ӿ�
 * @author 
 *
 */
public interface CustomerLossDao {
	/**
	 * ��ѯ�ͻ���ʧ����
	 * @param map
	 * @return
	 */
	public List<CustomerLoss> find(Map<String, Object> map);
	/**
	 * ��ѯ�ͻ���ʧ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * ��ӿͻ���ʧ��¼
	 * @param customerLoss
	 * @return
	 */
	public int add(CustomerLoss customerLoss);
	/**
	 * �޸Ŀͻ���ʧ��¼
	 * @param customerLoss
	 * @return
	 */
	public int update(CustomerLoss customerLoss);
	/**
	 * ����id���Ҷ�Ӧ��ʵ��
	 * @param id
	 * @return
	 */
	public CustomerLoss findById  (Integer id);
 }
