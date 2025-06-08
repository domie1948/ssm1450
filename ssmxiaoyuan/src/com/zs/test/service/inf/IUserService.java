package com.zs.test.service.inf;

import com.zs.test.entity.User;
/**
 * 通过id获取User
 * */
public interface IUserService {
	/**
	 * 通过id查询user
	 * */
	public User getUserById(int id);
	/**
	 * 通过nickname或者phone查询user
	 * */
	public User getUserByNameOrPhone(User user);
	/**
	 * 插入数据
	 * */
	public int addUser(User user);
}
