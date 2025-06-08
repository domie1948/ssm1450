package com.zs.test.paramEntity;

import com.zs.test.entity.Cart;
import com.zs.test.entity.Goods;

public class FullCart {
private Cart cart;
private Goods goods;

public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
}
public Goods getGoods() {
	return goods;
}
public void setGoods(Goods goods) {
	this.goods = goods;
}

}
