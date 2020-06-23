package com.lc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lc.dao.DataDicDao;
import com.lc.entity.DataDic;
import com.lc.service.DataDicService;

@Service("dataDicService")
public class DataDicServiceImpl implements DataDicService{
		@Resource
		private DataDicDao dataDicDao;
		
		public List<DataDic> find(Map<String, Object> map) {
			return dataDicDao.find(map);
		}

		public Long getTotal(Map<String, Object> map) {
			return dataDicDao.getTotal(map);
		}

		public int add(DataDic dataDic) {
			return dataDicDao.add(dataDic);
		}

		public int update(DataDic dataDic) {
			return dataDicDao.update(dataDic);
		}

		public int delete(Integer id) {
			return dataDicDao.delete(id);
		}

		public List<DataDic> findAll() {
			return dataDicDao.findAll();
		}
}
