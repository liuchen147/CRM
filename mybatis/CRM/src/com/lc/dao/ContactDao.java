package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.Contact;
/**
 * ������¼����Dao�ӿ�
 * @author 
 *
 */
public interface ContactDao {
	/**
	 * ��ѯ������¼������
	 * @param map
	 * @return
	 */
	public List<Contact> find(Map<String, Object> map);
	/**
	 * ������¼�������
	 * @param contact
	 * @return
	 */
	public int add(Contact contact);
	/**
	 * ������¼�����޸�
	 * @param contact
	 * @return
	 */
	public int update(Contact contact);
	/**
	 * ������¼����ɾ��
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
 }
