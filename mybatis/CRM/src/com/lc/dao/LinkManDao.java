package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.LinkMan;
/**
 * ��ϵ�˹���Dao�ӿ�
 * @author 
 *
 */
public interface LinkManDao {
	/**
	 * ��ѯ��ϵ�˹�����
	 * @param map
	 * @return
	 */
	public List<LinkMan> find(Map<String, Object> map);
	/**
	 * ��ϵ�˹������
	 * @param linkMan
	 * @return
	 */
	public int add(LinkMan linkMan);
	/**
	 * ��ϵ�˹����޸�
	 * @param linkMan
	 * @return
	 */
	public int update(LinkMan linkMan);
	/**
	 * ��ϵ�˹���ɾ��
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
 }
