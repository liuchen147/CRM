package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.CustomerLoss;
import com.lc.entity.CustomerReprieve;
/**
 * �ͻ���ʧService�ӿ�
 * @author 
 *
 */
public interface CustomerReprieveService {
	/**
	 * ��ѯ�ͻ���ʧ����
	 * @param map
	 * @return
	 */
	public List<CustomerReprieve> find(Map<String, Object> map);

	
	/**
	 * �ݻ���ʩ���
	 * @param customerReprieve
	 * @return
	 */
	public int add(CustomerReprieve customerReprieve);
	/**
	 * �ݻ���ʩ�޸�
	 * @param customerReprieve
	 * @return
	 */
	public int update(CustomerReprieve customerReprieve);
	/**
	 * �ݻ���ʩɾ��
	 * @param customerReprieve
	 * @return
	 */
	public int delete  (Integer id);
 }
