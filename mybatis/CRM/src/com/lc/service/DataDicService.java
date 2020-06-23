package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.DataDic;
/**
 * �����ֵ�Dao�ӿ�
 * @author 
 *
 */
public interface DataDicService {
	/**
	 * ��ѯ�����ֵ伯��
	 * @param map
	 * @return
	 */
	public List<DataDic> find(Map<String, Object> map);
	/**
	 * ��ѯ�����ֵ����еļ���
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
