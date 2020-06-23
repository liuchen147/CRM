package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.CustomerLoss;
import com.lc.entity.CustomerReprieve;
/**
 * 客户流失Service接口
 * @author 
 *
 */
public interface CustomerReprieveService {
	/**
	 * 查询客户流失集合
	 * @param map
	 * @return
	 */
	public List<CustomerReprieve> find(Map<String, Object> map);

	
	/**
	 * 暂缓措施添加
	 * @param customerReprieve
	 * @return
	 */
	public int add(CustomerReprieve customerReprieve);
	/**
	 * 暂缓措施修改
	 * @param customerReprieve
	 * @return
	 */
	public int update(CustomerReprieve customerReprieve);
	/**
	 * 暂缓措施删除
	 * @param customerReprieve
	 * @return
	 */
	public int delete  (Integer id);
 }
