package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.CusDevPlan;
/**
 * �ͻ������ƻ�Service�ӿ�
 * @author 
 *
 */
public interface CusDevPlanService {
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
