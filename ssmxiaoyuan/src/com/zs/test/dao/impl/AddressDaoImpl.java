package com.zs.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zs.test.dao.inf.AddressDao;
import com.zs.test.entity.Address;
@Repository("front_addressDao")
public class AddressDaoImpl implements AddressDao{
	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	private String range = "com.zs.test.dao.inf.AddressDao";
	
	public String sqlId(String idSql) {

		String position = range + "." + idSql;
		return position;
	}
	@Override
	public Address getAddressById(int id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(sqlId("getAddressById"),id);
	}

	@Override
	public List<Address> getAddressListByUserid(int userid) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(sqlId("getAddressByUserId"),userid);
	}

	@Override
	public int deleCartById(int id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete(sqlId("deleteById"),id);
	}
	@Override
	public int addAddress(Address address) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(sqlId("addFullAddress"),address);
	}

}
