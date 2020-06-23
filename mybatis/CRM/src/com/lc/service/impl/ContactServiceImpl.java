package com.lc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lc.dao.ContactDao;
import com.lc.entity.Contact;
import com.lc.service.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService{
		@Resource
		private ContactDao contactDao;
		
		public List<Contact> find(Map<String, Object> map) {
			return contactDao.find(map);
		}
		
		public int add(Contact contact) {
			return contactDao.add(contact);
		}

		public int update(Contact contact) {
			return contactDao.update(contact);
		}

		public int delete(Integer id) {
			return contactDao.delete(id);
		}
}
