package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.CusDevPlan;
/**
 * 客户开发计划Dao接口
 * @author 
 *
 */
public interface CusDevPlanDao {
	/**
	 * 查询客户开发计划集合
	 * @param map
	 * @return
	 */
	public List<CusDevPlan> find(Map<String, Object> map);
	/**
	 * 客户开发计划添加
	 * @param cusDevPlan
	 * @return
	 */
	public int add(CusDevPlan cusDevPlan);
	/**
	 * 客户开发计划修改
	 * @param cusDevPlan
	 * @return
	 */
	public int update(CusDevPlan cusDevPlan);
	/**
	 * 客户开发计划删除
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
 }
