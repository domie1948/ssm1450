package com.zs.test.dao.inf;

import java.util.List;

import com.zs.test.entity.Orders;

public interface OrdersDao {
	
	
	
	/**
	 * 添加订单
	 * */
	public int addOrders(Orders orders);
	
	
	public List<Orders> getOrdersList(int userId);
	
	/**
	 * 卖家获得所有订单
	 * */
	public List<Orders> getAllOrderList();
	
	public int updateStatus(Orders orders);
	
	public int updatePrice(Orders orders);
	public Orders getOrderById(int id);
}
