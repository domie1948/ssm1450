package com.zs.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.smartcardio.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.test.dao.inf.CartDao;
import com.zs.test.dao.inf.GoodsDao;
import com.zs.test.entity.Cart;
import com.zs.test.paramEntity.FullCart;
import com.zs.test.service.inf.ICartService;
@Service("front_cartServiceImpl")
public class CartServiceImpl implements ICartService {

	@Autowired
	@Resource(name = "front_cartDao")
	private CartDao cartDao;
	
	@Resource(name = "front_goodsDao")
	private GoodsDao goodsDao;
	@Override
	public List<FullCart> getlistCartByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Cart> cartList=cartDao.getCartByUserId(userId);
		List<FullCart> fullCartList=new ArrayList<FullCart>();
		for(int i=0,max=cartList.size();i<max;i++){
			FullCart fullCart=new FullCart();
			fullCart.setCart(cartList.get(i));
			fullCart.setGoods(goodsDao.getGoodsById(cartList.get(i).getGoodid()));
			fullCartList.add(fullCart);
		}
		return fullCartList;
	}

	@Override
	public int addCart(Cart cart) {
		// TODO Auto-generated method stub
		Cart tempCart=cartDao.getCartByUserGood(cart);
		int result=0;
		if(tempCart!=null){
			tempCart.setSum(tempCart.getSum()+cart.getSum());
			
			result=cartDao.updataCart(tempCart);
		}else{
			result=cartDao.addCartFull(cart);
		}
		
		return result;
	}

	@Override
	public int deleteCartById(int id) {
		// TODO Auto-generated method stub
		return cartDao.deleCartById(id);
	}

	@Override
	public Cart getCartBygoodUserid(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.getCartByUserGood(cart);
	}

	@Override
	public int updataCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.updataCart(cart);
	}

}
