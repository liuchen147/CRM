package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.DataDic;
/**
 * 数据字典Dao接口
 * @author 
 *
 */
public interface DataDicDao {
	/**
	 * 查询数据字典集合
	 * @param map
	 * @return
	 */
	public List<DataDic> find(Map<String, Object> map);
	/**
	 * 查询所有数据字典集合
	 * @return
	 */
	public List<DataDic> findAll();
	/**
	 * 查询数据字典总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	/**
	 * 数据字典添加
	 * @param dataDic
	 * @return
	 */
	public int add(DataDic dataDic);
	/**
	 * 数据字典修改
	 * @param dataDic
	 * @return
	 */
	public int update(DataDic dataDic);
	/**
	 * 数据字典删除
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
 }
