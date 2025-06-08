package com.zs.test.service.inf;

import java.util.List;

import com.zs.test.entity.Orders;
import com.zs.test.paramEntity.FullOrders;

public interface IOrdersService {
	public int addOrders(Orders orders);
	public List<FullOrders> getOrdersList(int userId);
	public List<FullOrders> getAllOrdersList();
	public int updateStatus(Orders orders);
	public int updatePrice(Orders orders);
	public FullOrders getFullOrders(int id);
}
