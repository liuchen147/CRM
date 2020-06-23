package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.Product;
/**
 * 用户Dao接口
 * @author 
 *
 */
public interface ProductDao {
	/**
	 * 查询用户集合
	 * @param map
	 * @return
	 */
	public List<Product> find(Map<String, Object> map);
	/**
	 * 查询用户总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
 }
