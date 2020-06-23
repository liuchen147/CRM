package com.lc.dao;

import java.util.List;
import java.util.Map;

import com.lc.entity.DataDic;
/**
 * �����ֵ�Dao�ӿ�
 * @author 
 *
 */
public interface DataDicDao {
	/**
	 * ��ѯ�����ֵ伯��
	 * @param map
	 * @return
	 */
	public List<DataDic> find(Map<String, Object> map);
	/**
	 * ��ѯ���������ֵ伯��
	 * @return
	 */
	public List<DataDic> findAll();
	/**
	 * ��ѯ�����ֵ��ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	/**
	 * �����ֵ����
	 * @param dataDic
	 * @return
	 */
	public int add(DataDic dataDic);
	/**
	 * �����ֵ��޸�
	 * @param dataDic
	 * @return
	 */
	public int update(DataDic dataDic);
	/**
	 * �����ֵ�ɾ��
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
 }
