package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.Customer;
import com.lc.entity.CustomerFw;
import com.lc.entity.CustomerGc;
import com.lc.entity.CustomerGx;
/**
 * 客户Dao接口
 * @author 
 *
 */
public interface CustomerDao {
	/**
	 * 查询客户集合
	 * @param map
	 * @return
	 */
	public List<Customer> find(Map<String, Object> map);
	/**
	 * 查询客户总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	/**
	 * 客户添加
	 * @param customer
	 * @return
	 */
	public int add(Customer customer);
	/**
	 * 客户修改
	 * @param customer
	 * @return
	 */
	public int update(Customer customer);
	/**
	 * 客户删除
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	
	/**
	 * 根据Id查询客户
	 * @param id
	 * @return
	 */
	public Customer findById(Integer id);
	/**
	 * 查询流失客户，六个月未下单的客户
	 * @return
	 */
	public List<Customer> findLossCustomer();
	/**
	 * 查询客户贡献列表
	 * @param map
	 * @return
	 */
	public List<CustomerGx> findCustomerGx(Map<String,Object> map);
	/**
	 * 查询客户贡献记录
	 * @param map
	 * @return
	 */
	public Long getTotalCustomerGx(Map<String, Object> map);
	/**
	 * 查询客户构成数据
	 * @param map
	 * @return
	 */
	public List<CustomerGc> findCustomerGc();
	
	/**
	 * 查询客户服务数据
	 * @param map
	 * @return
	 */
	public List<CustomerFw> findCustomerFw();
 }
