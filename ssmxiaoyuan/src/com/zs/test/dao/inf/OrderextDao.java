package com.zs.test.dao.inf;

import java.util.List;

import com.zs.test.entity.Orderext;

public interface OrderextDao {
 /**
 * 通过id获取goods
 * */
	public int addOrder(Orderext orderext);
	
	public List<Orderext> getListOrderext(int orderid);
 
}
