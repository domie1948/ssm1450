package com.zs.test.control.front;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zs.test.entity.Orders;
import com.zs.test.entity.User;
import com.zs.test.paramEntity.FullOrders;
import com.zs.test.service.inf.IOrdersService;
import com.zs.test.util.SessionUtil;
@Controller("front_orderAction")
@Scope("request")
public class OrderAction extends ActionSupport{
	private String actionurl;
	private InputStream json;
	private Integer addressId;
	private Orders orders;
	private FullOrders fullOrders;
	private Integer orderId;
	private List<FullOrders> fullOrdersList;
	@Autowired
	@Resource(name = "front_ordersServiceImpl")
	private IOrdersService ordersService;
	public String addCart(){
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
		Orders orders=new Orders();
		orders.setAddid(addressId);
		orders.setAddtime(new Date().getTime());
		orders.setPrice(1);
		orders.setStatus(1);
		orders.setUserid(user.getId());
		if(ordersService.addOrders(orders)>0){
			//清空购物车
			
			SessionUtil.setAlert("生产订单成功");
			
			actionurl="front_orderAction_listOrders";
		}else{
			actionurl="front_cartAction_addCart";
			SessionUtil.setAlert("生产订单失败");
		}
		return "redirect";
	}
	public String listOrders(){
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
		fullOrdersList=ordersService.getOrdersList(user.getId());
		return SUCCESS;
	}
	
	public String listAllOrderList(){
		fullOrdersList=ordersService.getAllOrdersList();
		return SUCCESS;
	}
	public String sellerupdateOrder(){
		if(ordersService.updateStatus(orders)>0){
			SessionUtil.setAlert("发货成功");
			
		}else{
			SessionUtil.setAlert("发货失败");
		}
		actionurl="front_orderAction_listAllOrderList";
		return "redirect";
	}
	public String buyerupdateOrder(){
		if(ordersService.updateStatus(orders)>0){
			SessionUtil.setAlert("确认订单成功");
			
		}else{
			SessionUtil.setAlert("确认订单失败");
		}
		actionurl="front_orderAction_listOrders";
		return "redirect";
	}
	public String detailOrder(){
		fullOrders=ordersService.getFullOrders(orderId);
		return SUCCESS;
	}
	public String getActionurl() {
		return actionurl;
	}
	public void setActionurl(String actionurl) {
		this.actionurl = actionurl;
	}
	public InputStream getJson() {
		return json;
	}
	public void setJson(InputStream json) {
		this.json = json;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public List<FullOrders> getFullOrdersList() {
		return fullOrdersList;
	}
	public void setFullOrdersList(List<FullOrders> fullOrdersList) {
		this.fullOrdersList = fullOrdersList;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public FullOrders getFullOrders() {
		return fullOrders;
	}
	public void setFullOrders(FullOrders fullOrders) {
		this.fullOrders = fullOrders;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	
}
