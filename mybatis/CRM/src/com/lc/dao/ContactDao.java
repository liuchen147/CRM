package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.Contact;
/**
 * 交往记录管理Dao接口
 * @author 
 *
 */
public interface ContactDao {
	/**
	 * 查询交往记录管理集合
	 * @param map
	 * @return
	 */
	public List<Contact> find(Map<String, Object> map);
	/**
	 * 交往记录管理添加
	 * @param contact
	 * @return
	 */
	public int add(Contact contact);
	/**
	 * 交往记录管理修改
	 * @param contact
	 * @return
	 */
	public int update(Contact contact);
	/**
	 * 交往记录管理删除
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
 }
