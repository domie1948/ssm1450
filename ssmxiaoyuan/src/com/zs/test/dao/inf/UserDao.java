package com.zs.test.dao.inf;

import com.zs.test.entity.User;
/**
 * User的dao层
 * */
public interface UserDao {
/**
 * 通过id获取user
 * */
 public User getUser(int id);
/**
 * 通过nickname或phone查询user
 * */
 public User getUserByNameOrPhone(User user);
 
 /**
  *插入user表数据
  * */
 public int addUser(User user);
}
