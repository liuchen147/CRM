package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.LinkMan;
/**
 * ��ϵ�˹���Service�ӿ�
 * @author 
 *
 */
public interface LinkManService {
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
