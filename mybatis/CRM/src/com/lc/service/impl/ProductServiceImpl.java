package com.lc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lc.dao.ProductDao;
import com.lc.entity.Product;
import com.lc.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Resource
	private ProductDao productDao;
	

	public List<Product> find(Map<String, Object> map) {
		return productDao.find(map);
	}


	public Long getTotal(Map<String, Object> map) {
		return productDao.getTotal(map);
	}

}
