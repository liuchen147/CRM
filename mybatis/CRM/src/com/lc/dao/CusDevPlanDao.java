package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.CusDevPlan;
/**
 * �ͻ������ƻ�Dao�ӿ�
 * @author 
 *
 */
public interface CusDevPlanDao {
	/**
	 * ��ѯ�ͻ������ƻ�����
	 * @param map
	 * @return
	 */
	public List<CusDevPlan> find(Map<String, Object> map);
	/**
	 * �ͻ������ƻ����
	 * @param cusDevPlan
	 * @return
	 */
	public int add(CusDevPlan cusDevPlan);
	/**
	 * �ͻ������ƻ��޸�
	 * @param cusDevPlan
	 * @return
	 */
	public int update(CusDevPlan cusDevPlan);
	/**
	 * �ͻ������ƻ�ɾ��
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
 }
