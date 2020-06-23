package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.User;

/**
 * 
 * 用户Service接口
 * 
 * */
public interface UserService {
	/**
	 * 用户登录
	 * */
	public User login(User user);
	/**
	 * 查询用户集合
	 * @param map
	 * @return
	 */
	public List<User> find(Map<String, Object> map);
	/**
	 * 查询用户总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	/**
	 * 用户添加
	 * @param user
	 * @return
	 */
	public int add(User user);
	/**
	 * 用户修改
	 * @param user
	 * @return
	 */
	public int update(User user);
	/**
	 * 用户删除
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
}
