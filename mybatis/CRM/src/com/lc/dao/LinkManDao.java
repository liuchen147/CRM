package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.LinkMan;
/**
 * 联系人管理Dao接口
 * @author 
 *
 */
public interface LinkManDao {
	/**
	 * 查询联系人管理集合
	 * @param map
	 * @return
	 */
	public List<LinkMan> find(Map<String, Object> map);
	/**
	 * 联系人管理添加
	 * @param linkMan
	 * @return
	 */
	public int add(LinkMan linkMan);
	/**
	 * 联系人管理修改
	 * @param linkMan
	 * @return
	 */
	public int update(LinkMan linkMan);
	/**
	 * 联系人管理删除
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
 }
