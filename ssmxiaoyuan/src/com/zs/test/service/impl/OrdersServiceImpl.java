package com.zs.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.test.dao.inf.AddressDao;
import com.zs.test.dao.inf.CartDao;
import com.zs.test.dao.inf.GoodsDao;
import com.zs.test.dao.inf.OrderextDao;
import com.zs.test.dao.inf.OrdersDao;
import com.zs.test.entity.Address;
import com.zs.test.entity.Cart;
import com.zs.test.entity.Goods;
import com.zs.test.entity.Orderext;
import com.zs.test.entity.Orders;
import com.zs.test.entity.User;
import com.zs.test.paramEntity.FullOrders;
import com.zs.test.paramEntity.HalfOrderext;
import com.zs.test.service.inf.IOrdersService;
@Service("front_ordersServiceImpl")
public class OrdersServiceImpl implements IOrdersService {
	
	@Autowired
	
	@Resource(name = "front_cartDao")
	private CartDao cartDao;
	
	@Resource(name = "front_ordersDao")
	private OrdersDao ordersDao;
	
	@Resource(name = "front_orderextDao")
	private OrderextDao orderextDao;
	
	@Resource(name = "front_addressDao")
	private AddressDao addressDao;
	
	@Resource(name = "front_goodsDao")
	private GoodsDao goodsDao;
	@Override
	public int addOrders(Orders orders) {
		// TODO Auto-generated method stub
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
		List<Cart> cartList=cartDao.getCartByUserId(user.getId());
		int result=ordersDao.addOrders(orders);//生成总订单
		if(result>0){
			int p=0;
			for(int i=0,max=cartList.size();i<max;i++)
			{
				Orderext orderext=new Orderext();
				orderext.setGoodid(cartList.get(i).getGoodid());
				orderext.setOrderid(orders.getId());
				orderext.setNum(cartList.get(i).getSum());
				orderextDao.addOrder(orderext);//逐个插入订单明细表
				Goods tempGoods=goodsDao.getGoodsById(cartList.get(i).getGoodid());
				//更新商品库存
				int oldKc   = tempGoods.getSum();
				int soldNum = orderext.getNum();
				tempGoods.setSalesum(soldNum+tempGoods.getSalesum());//更新已售出数量
				tempGoods.setSum(oldKc - soldNum);//更新库存
				goodsDao.updateGoods(tempGoods);
				p=p+orderext.getNum()*tempGoods.getPrice();
			}
			orders.setPrice(p);
			ordersDao.updatePrice(orders);
		}
		
		
		return result;
		
		
	}
	@Override
	public List<FullOrders> getOrdersList(int userId) {
		// TODO Auto-generated method stub
		List<Orders> ordersList= ordersDao.getOrdersList(userId);
		List<FullOrders> fullOrdersList=new ArrayList<FullOrders>();
		for(int i=0,max=ordersList.size();i<max;i++){
			FullOrders fullOrders=new FullOrders();
			Orders orders=ordersList.get(i);
			fullOrders.setOrders(orders);
			
			fullOrders.setAddress(addressDao.getAddressById(orders.getAddid()));
			List<Orderext> orderextList=orderextDao.getListOrderext(orders.getId());
			List<HalfOrderext> halfOrderextsList=new ArrayList<HalfOrderext>();
			for (int j = 0; j < orderextList.size(); j++) {
				HalfOrderext halfOrderext=new HalfOrderext();
				halfOrderext.setOrderext(orderextList.get(j));
				halfOrderext.setGoods(goodsDao.getGoodsById(orderextList.get(j).getGoodid()));
				halfOrderextsList.add(halfOrderext);
			}
			fullOrders.setHalfOrderextList(halfOrderextsList);
			fullOrdersList.add(fullOrders);
		}
		return fullOrdersList;
	}
	@Override
	public List<FullOrders> getAllOrdersList() {
		// TODO Auto-generated method stub
		List<Orders> ordersList= ordersDao.getAllOrderList();
		List<FullOrders> fullOrdersList=new ArrayList<FullOrders>();
		for(int i=0,max=ordersList.size();i<max;i++){
			FullOrders fullOrders=new FullOrders();
			Orders orders=ordersList.get(i);
			fullOrders.setOrders(orders);
			
			fullOrders.setAddress(addressDao.getAddressById(orders.getAddid()));
			List<Orderext> orderextList=orderextDao.getListOrderext(orders.getId());
			List<HalfOrderext> halfOrderextsList=new ArrayList<HalfOrderext>();
			for (int j = 0; j < orderextList.size(); j++) {
				HalfOrderext halfOrderext=new HalfOrderext();
				halfOrderext.setOrderext(orderextList.get(j));
				halfOrderext.setGoods(goodsDao.getGoodsById(orderextList.get(j).getGoodid()));
				halfOrderextsList.add(halfOrderext);
			}
			fullOrders.setHalfOrderextList(halfOrderextsList);
			fullOrdersList.add(fullOrders);
		}
		return fullOrdersList;
	}
	@Override
	public int updateStatus(Orders orders) {
		// TODO Auto-generated method stub
		return ordersDao.updateStatus(orders);
	}
	@Override
	public FullOrders getFullOrders(int id) {
		// TODO Auto-generated method stub
		Orders orders=ordersDao.getOrderById(id);
		FullOrders fullOrders=new FullOrders();
		fullOrders.setOrders(orders);
		fullOrders.setAddress(addressDao.getAddressById(orders.getAddid()));
		List<Orderext> orderextList=orderextDao.getListOrderext(orders.getId());
		List<HalfOrderext> halfOrderextsList=new ArrayList<HalfOrderext>();
		for (int j = 0; j < orderextList.size(); j++) {
			HalfOrderext halfOrderext=new HalfOrderext();
			halfOrderext.setOrderext(orderextList.get(j));
			halfOrderext.setGoods(goodsDao.getGoodsById(orderextList.get(j).getGoodid()));
			halfOrderextsList.add(halfOrderext);
		}
		fullOrders.setHalfOrderextList(halfOrderextsList);
		return fullOrders;
	}
	@Override
	public int updatePrice(Orders orders) {
		// TODO Auto-generated method stub
		return ordersDao.updatePrice(orders);
	}

}
