package com.zs.test.dao.inf;

import java.util.List;

import com.zs.test.entity.Cart;

public interface CartDao {

	/**
	 * 通过cata获取Cartlist
	 * */
		public List<Cart> getCartByUserId(int userId);

	
	/**
	 * 插入Cart
	 * */	
		public int addCartFull(Cart cart);
	

	/**
	 * 删除商品通过id
	 * */
		public int deleCartById(int id);
	/**
	 * 通过userid, goodid
	 * */
		public Cart getCartByUserGood(Cart cart);	
	
	/**
	 * 
	 * */
		public int updataCart(Cart cart);
		
		public Cart getCartByGoodid(int goodId);
}
