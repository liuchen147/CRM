package com.lc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lc.dao.SaleChanceDao;
import com.lc.entity.SaleChance;
import com.lc.service.SaleChanceService;

@Service("saleChanceService")
public class SaleChanceServiceImpl implements SaleChanceService{

	@Resource
	private SaleChanceDao saleChanceDao;

	public List<SaleChance> find(Map<String, Object> map) {
		return saleChanceDao.find(map);
	}


	public Long getTotal(Map<String, Object> map) {
		return saleChanceDao.getTotal(map);
	}

	public int add(SaleChance saleChance) {
		return saleChanceDao.add(saleChance);
	}

	public int update(SaleChance saleChance) {
		return saleChanceDao.update(saleChance);
	}

	public int delete(Integer id) {
		return saleChanceDao.delete(id);
	}

	public SaleChance findById(Integer id) {
		return saleChanceDao.findById(id);
	}

}
