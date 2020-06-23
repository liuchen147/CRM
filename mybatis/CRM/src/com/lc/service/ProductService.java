package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.Product;

/**
 * 
 * 用户Service接口
 * 
 * */
public interface ProductService {
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
