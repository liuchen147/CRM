package com.lc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lc.dao.UserDao;
import com.lc.entity.User;
import com.lc.service.UserService;
@Service("userService")
public class UserServiceImpl  implements UserService{

	
	@Resource
	private UserDao userDao;
	public User login(User user) {
		
		return userDao.login(user);
	}
		
}
