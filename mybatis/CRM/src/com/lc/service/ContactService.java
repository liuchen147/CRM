package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.Contact;
/**
 * 交易记录管理Service接口
 * @author 
 *
 */
public interface ContactService {
	/**
	 * 查询交易记录管理集合
	 * @param map
	 * @return
	 */
	public List<Contact> find(Map<String, Object> map);
	/**
	 * 交易记录管理添加
	 * @param contact
	 * @return
	 */
	public int add(Contact contact);
	/**
	 * 交易记录管理修改
	 * @param contact
	 * @return
	 */
	public int update(Contact contact);
	/**
	 * 交易记录管理删除
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
 }
