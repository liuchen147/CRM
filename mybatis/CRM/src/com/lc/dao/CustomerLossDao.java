package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.Customer;
import com.lc.entity.CustomerLoss;
/**
 * 客户流失Dao接口
 * @author 
 *
 */
public interface CustomerLossDao {
	/**
	 * 查询客户流失集合
	 * @param map
	 * @return
	 */
	public List<CustomerLoss> find(Map<String, Object> map);
	/**
	 * 查询客户流失总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * 添加客户流失记录
	 * @param customerLoss
	 * @return
	 */
	public int add(CustomerLoss customerLoss);
	/**
	 * 修改客户流失记录
	 * @param customerLoss
	 * @return
	 */
	public int update(CustomerLoss customerLoss);
	/**
	 * 更具id查找对应的实体
	 * @param id
	 * @return
	 */
	public CustomerLoss findById  (Integer id);
 }
