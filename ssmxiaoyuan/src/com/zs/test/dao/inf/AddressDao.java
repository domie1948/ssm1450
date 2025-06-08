package com.zs.test.dao.inf;

import java.util.List;

import com.zs.test.entity.Address;

public interface AddressDao {
	/**
	 * 通过id获取address
	 * */
	public Address getAddressById(int id);
	/**
	 * 通过userid获取address的list
	 * */
	public List<Address> getAddressListByUserid(int userid);
	/**
	 * 删除某个地址通过id
	 * */
	public int deleCartById(int id);
	
	/**
	 * 添加地址
	 * */
	public int addAddress(Address address);
	
	
}
