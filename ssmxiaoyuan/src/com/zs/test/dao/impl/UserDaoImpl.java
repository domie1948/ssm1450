package com.zs.test.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zs.test.dao.inf.UserDao;
import com.zs.test.entity.User;
@Repository("front_userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	private String range = "com.zs.test.dao.inf.UserDao";
	
	public String sqlId(String idSql) {

		String position = range + "." + idSql;
		return position;
	}
	
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("getUserById", id);
		
	}

	@Override
	public User getUserByNameOrPhone(User user) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("getUserByNameOrPhone", user);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("addUserSelective", user);
	}

}
