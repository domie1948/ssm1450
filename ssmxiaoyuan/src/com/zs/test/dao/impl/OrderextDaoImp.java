package com.zs.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zs.test.dao.inf.OrderextDao;
import com.zs.test.entity.Orderext;
@Repository("front_orderextDao")
public class OrderextDaoImp implements OrderextDao {

	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	private String range = "com.zs.test.dao.inf.OrderextDao";
	
	public String sqlId(String idSql) {

		String position = range + "." + idSql;
		return position;
	}
	
	

	@Override
	public int addOrder(Orderext orderext) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(sqlId("addorderextFull"),orderext);
	}

	@Override
	public List<Orderext> getListOrderext(int orderid) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(sqlId("getOrderextByOrder"),orderid);
	}

}
