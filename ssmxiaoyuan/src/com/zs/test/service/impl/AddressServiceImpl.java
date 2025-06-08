package com.zs.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.test.dao.inf.AddressDao;
import com.zs.test.entity.Address;
import com.zs.test.service.inf.IAddressService;
@Service("front_addressServiceImpl")
public class AddressServiceImpl implements IAddressService {

	@Autowired
	
	@Resource(name = "front_addressDao")
	private AddressDao addressDao;
	@Override
	public Address getAddressById(int id) {
		// TODO Auto-generated method stub
		return addressDao.getAddressById(id);
	}

	@Override
	public List<Address> getListAddress(int userid) {
		// TODO Auto-generated method stub
		return addressDao.getAddressListByUserid(userid);
	}

	@Override
	public int deleAddressById(int id) {
		// TODO Auto-generated method stub
		return addressDao.deleCartById(id);
	}

	@Override
	public int addAddresss(Address address) {
		// TODO Auto-generated method stub
		return addressDao.addAddress(address);
	}

}
