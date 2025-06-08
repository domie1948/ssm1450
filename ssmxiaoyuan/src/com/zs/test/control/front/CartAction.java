package com.zs.test.control.front;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zs.test.entity.Address;
import com.zs.test.entity.Cart;
import com.zs.test.entity.User;
import com.zs.test.paramEntity.FullCart;
import com.zs.test.service.inf.IAddressService;
import com.zs.test.service.inf.ICartService;

@Controller("front_cartAction")
@Scope("request")
public class CartAction extends ActionSupport{
	private String actionurl;
	private InputStream json;
	private Cart cart;
	private List<FullCart> fullCartList;
	private Integer goodId;
	private Integer cartId;
	private Address address;
	private List<Address> addressList;

	@Autowired
	@Resource(name = "front_cartServiceImpl")
	private ICartService cartService;
	
	@Resource(name = "front_addressServiceImpl")
	private IAddressService addressService;
	
	public String addCart() throws Exception{
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
		cart.setGoodid(goodId);
		cart.setUid(user.getId());
		int result=cartService.addCart(cart);
		if(result>0){
			this.json=new ByteArrayInputStream("success".getBytes("UTF-8"));
		}else{
			this.json=new ByteArrayInputStream("fail".getBytes("UTF-8"));
		}
		return "ajaxjson";
	}
	
	public String listCart(){
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
		fullCartList=cartService.getlistCartByUserId(user.getId());
		return SUCCESS;
	}
	public String delcart() throws Exception{
		int result=cartService.deleteCartById(cartId);
		if(result>0){
			this.json=new ByteArrayInputStream("success".getBytes("UTF-8"));
		}else{
			this.json=new ByteArrayInputStream("fail".getBytes("UTF-8"));
		}
		return "ajaxjson";
	}
	
	public String confirmCart(){
		
		
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
		addressList=addressService.getListAddress(user.getId());
		fullCartList=cartService.getlistCartByUserId(user.getId());
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<FullCart> getFullCartList() {
		return fullCartList;
	}

	public void setFullCartList(List<FullCart> fullCartList) {
		this.fullCartList = fullCartList;
	}

	public Integer getGoodId() {
		return goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	
	
	
}
