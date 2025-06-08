package com.zs.test.service.inf;

import java.util.List;

import com.zs.test.entity.Address;

public interface IAddressService {
/**
 * 通过id获取address
 * */
	
	public Address getAddressById(int id);
	
	/**
	 * 通过userid获取list address
	 * */
	
	public List<Address> getListAddress(int userid);
	
	/**
	 * 通过id删除address
	 * */
	
	public int deleAddressById(int id);
	
	/**
	 * 添加地址
	 * */
	
	public int addAddresss(Address address);
}
