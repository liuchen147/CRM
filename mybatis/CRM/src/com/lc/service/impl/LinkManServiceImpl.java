package com.lc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lc.dao.LinkManDao;
import com.lc.entity.LinkMan;
import com.lc.service.LinkManService;

@Service("linkManService")
public class LinkManServiceImpl implements LinkManService{
		@Resource
		private LinkManDao linkManDao;
		
		public List<LinkMan> find(Map<String, Object> map) {
			return linkManDao.find(map);
		}
		
		public int add(LinkMan linkMan) {
			return linkManDao.add(linkMan);
		}

		public int update(LinkMan linkMan) {
			return linkManDao.update(linkMan);
		}

		public int delete(Integer id) {
			return linkManDao.delete(id);
		}
}
