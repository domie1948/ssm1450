package com.zs.test.control.front;

import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zs.test.entity.Address;
import com.zs.test.entity.User;
import com.zs.test.service.inf.IAddressService;
import com.zs.test.util.SessionUtil;
@Controller("front_addressAction")
@Scope("request")
public class AddressAction extends ActionSupport{
	private String actionurl;
	private InputStream json;
	private Address address;
	private Integer addressId;
	
	@Resource(name = "front_addressServiceImpl")
	private IAddressService addressService;
	
	public String addAddress(){
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
		address.setUserid(user.getId());
		int result=addressService.addAddresss(address);
		if(result>0){
			SessionUtil.setAlert("添加成功");
		}else{
			SessionUtil.setAlert("添加失败");
		}
		actionurl="front_cartAction_confirmCart";
		return "redirect";
	}
	public String deleteAddress(){
		
		int result=addressService.deleAddressById(addressId);
		if(result>0){
			SessionUtil.setAlert("删除成功");
		}else{
			SessionUtil.setAlert("删除失败");
		}
		actionurl="front_cartAction_confirmCart";
		return "redirect";
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	
	
	
}
