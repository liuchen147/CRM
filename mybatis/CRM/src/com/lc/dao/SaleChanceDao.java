package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.SaleChance;
/**
 * Ӫ������Dao�ӿ�
 * @author 
 *
 */
public interface SaleChanceDao {
	/**
	 * ��ѯӪ�����Ἧ��
	 * @param map
	 * @return
	 */
	public List<SaleChance> find(Map<String, Object> map);
	/**
	 * ��ѯӪ�������ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	/**
	 * Ӫ���������
	 * @param saleChance
	 * @return
	 */
	public int add(SaleChance saleChance);
	/**
	 * Ӫ�������޸�
	 * @param saleChance
	 * @return
	 */
	public int update(SaleChance saleChance);
	/**
	 * Ӫ������ɾ��
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	/**
	 * ͨ��Id��ѯ���ۻ�����ϸ��Ϣ
	 * @param id
	 * @return
	 */
	public SaleChance findById(Integer id);
 }
