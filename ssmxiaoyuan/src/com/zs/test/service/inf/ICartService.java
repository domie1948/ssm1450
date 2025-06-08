package com.zs.test.service.inf;

import java.util.List;

import com.zs.test.entity.Cart;
import com.zs.test.paramEntity.FullCart;

public interface ICartService {
	public List<FullCart> getlistCartByUserId(int userId);
	
	public int addCart(Cart cart);
	
	public int deleteCartById(int id);
	
	public Cart getCartBygoodUserid(Cart cart);
	
	public int updataCart(Cart cart);
}
