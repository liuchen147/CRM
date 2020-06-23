package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.SaleChance;
/**
 * 营销机会Dao接口
 * @author 
 *
 */
public interface SaleChanceDao {
	/**
	 * 查询营销机会集合
	 * @param map
	 * @return
	 */
	public List<SaleChance> find(Map<String, Object> map);
	/**
	 * 查询营销机会总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	/**
	 * 营销机会添加
	 * @param saleChance
	 * @return
	 */
	public int add(SaleChance saleChance);
	/**
	 * 营销机会修改
	 * @param saleChance
	 * @return
	 */
	public int update(SaleChance saleChance);
	/**
	 * 营销机会删除
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	/**
	 * 通过Id查询销售机会详细信息
	 * @param id
	 * @return
	 */
	public SaleChance findById(Integer id);
 }
