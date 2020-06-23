package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.CustomerLoss;
/**
 * �ͻ���ʧService�ӿ�
 * @author 
 *
 */
public interface CustomerLossService {
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
