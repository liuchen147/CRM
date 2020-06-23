package com.lc.dao;

import java.util.List;
import java.util.Map;


import com.lc.entity.CustomerReprieve;
/**
 * �ͻ���ʧDao�ӿ�
 * @author 
 *
 */
public interface CustomerReprieveDao {
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
