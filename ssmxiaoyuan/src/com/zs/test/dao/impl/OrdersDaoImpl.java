package com.zs.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zs.test.dao.inf.OrdersDao;
import com.zs.test.entity.Orders;
@Repository("front_ordersDao")
public class OrdersDaoImpl implements OrdersDao {
	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	private String range = "com.zs.test.dao.inf.OrdersDao";
	
	public String sqlId(String idSql) {

		String position = range + "." + idSql;
		return position;
	}
	@Override
	public int addOrders(Orders orders) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(sqlId("addOrder"),orders);
	}
	@Override
	public List<Orders> getOrdersList(int userId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(sqlId("getOrdersByUserId"),userId);
	}
	@Override
	public List<Orders> getAllOrderList() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(sqlId("getAllOrders"));
	}
	@Override
	public int updateStatus(Orders orders) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(sqlId("updataStatus"), orders);
	}
	@Override
	public Orders getOrderById(int id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(sqlId("getOrdersById"),id);
	}
	@Override
	public int updatePrice(Orders orders) {
		// TODO Auto-generated method stub
		return  sqlSessionTemplate.update(sqlId("updataPrice"), orders);
	}

}
