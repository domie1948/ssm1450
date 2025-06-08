package com.zs.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zs.test.dao.inf.CartDao;
import com.zs.test.entity.Cart;
@Repository("front_cartDao")
public class CartDaoImpl implements CartDao {

	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	private String range = "com.zs.test.dao.inf.CartDao";
	
	public String sqlId(String idSql) {

		String position = range + "." + idSql;
		return position;
	}
	
	@Override
	public List<Cart> getCartByUserId(int userId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(sqlId("getcartByUserId"),userId);
	}

	@Override
	public int addCartFull(Cart cart) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(sqlId("addCartFull"),cart);
	}

	@Override
	public int deleCartById(int id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete(sqlId("deleteById"),id);
	}

	@Override
	public Cart getCartByUserGood(Cart cart) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(sqlId("getcartByUsergood"),cart);
	}

	@Override
	public int updataCart(Cart cart) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(sqlId("updatacart"),cart);
	}

	@Override
	public Cart getCartByGoodid(int goodId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(sqlId("getcartByGoodId"),goodId);
	}

}
