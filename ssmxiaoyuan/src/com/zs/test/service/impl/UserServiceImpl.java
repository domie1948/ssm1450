package com.zs.test.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.test.dao.inf.UserDao;
import com.zs.test.entity.User;
import com.zs.test.service.inf.IUserService;
@Service("front_userServiceImpl")
public class UserServiceImpl implements IUserService {

	@Autowired
	@Resource(name = "front_userDao")
	private UserDao userDao;
	
	
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}


	@Override
	public User getUserByNameOrPhone(User user) {
		// TODO Auto-generated method stub
		return userDao.getUserByNameOrPhone(user);
	}


	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

}
