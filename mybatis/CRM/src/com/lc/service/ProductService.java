package com.lc.service;

import java.util.List;
import java.util.Map;

import com.lc.entity.Product;

/**
 * 
 * �û�Service�ӿ�
 * 
 * */
public interface ProductService {
	/**
	 * ��ѯ�û�����
	 * @param map
	 * @return
	 */
	public List<Product> find(Map<String, Object> map);
	/**
	 * ��ѯ�û��ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
}
