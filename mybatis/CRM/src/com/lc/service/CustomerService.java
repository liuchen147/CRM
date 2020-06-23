package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.Customer;
import com.lc.entity.CustomerFw;
import com.lc.entity.CustomerGc;
import com.lc.entity.CustomerGx;
/**
 * �ͻ�Serviceʵ��
 * @author 
 *
 */
public interface CustomerService {
	/**
	 * ��ѯ�ͻ�����
	 * @param map
	 * @return
	 */
	public List<Customer> find(Map<String, Object> map);
	/**
	 * ��ѯ�ͻ��ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	/**
	 * �ͻ�����
	 * @param customer
	 * @return
	 */
	public int add(Customer customer);
	/**
	 * �ͻ��޸�
	 * @param customer
	 * @return
	 */
	public int update(Customer customer);
	/**
	 * �ͻ�ɾ��
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	
	/**
	 * ����Id��ѯ�ͻ�
	 * @param id
	 * @return
	 */
	public Customer findById(Integer id);
	/**
	 * ��ѯ��ʧ�ͻ����������ӵ���ʧ�ͻ�������
	 */
	public void checkCustomerLoss();
	
	/**
	 * ��ѯ�ͻ������б�
	 * @param map
	 * @return
	 */
	public List<CustomerGx> findCustomerGx(Map<String,Object> map);
	/**
	 * ��ѯ�ͻ����׼�¼
	 * @param map
	 * @return
	 */
	public Long getTotalCustomerGx(Map<String, Object> map);
	
	/**
	 * ��ѯ�ͻ���������
	 * @param map
	 * @return
	 */
	public List<CustomerGc> findCustomerGc();
	
	/**
	 * ��ѯ�ͻ���������
	 * @param map
	 * @return
	 */
	public List<CustomerFw> findCustomerFw();
 }