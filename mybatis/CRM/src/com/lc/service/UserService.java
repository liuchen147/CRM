package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.User;

/**
 * 
 * �û�Service�ӿ�
 * 
 * */
public interface UserService {
	/**
	 * �û���¼
	 * */
	public User login(User user);
	/**
	 * ��ѯ�û�����
	 * @param map
	 * @return
	 */
	public List<User> find(Map<String, Object> map);
	/**
	 * ��ѯ�û��ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	/**
	 * �û����
	 * @param user
	 * @return
	 */
	public int add(User user);
	/**
	 * �û��޸�
	 * @param user
	 * @return
	 */
	public int update(User user);
	/**
	 * �û�ɾ��
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
}
