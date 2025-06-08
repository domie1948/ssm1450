package com.zs.test.dao.inf;

import java.util.List;

import com.zs.test.entity.Goods;

public interface GoodsDao {
/**
 * 通过id获取goods
 * */
	public Goods getGoodsById(int id);
	/**
	 * 通过cata获取goodslist
	 * */
		public List<Goods> getGoodsBycata(int cata);
		
	
	/**
	 * 通过id获取goods
	 * */
	public List<Goods> getGoodsListSome(int start,int end,String orderBy);
		
	
/**
 * 插入goods
 * */	
	public int addGoodsFull(Goods goods);
	
	/**
	 * update goods
	 * */	
		public int updateGoods(Goods goods);
		
/**
 * 获取所以goods
 * */
	public List<Goods> getAllGoods();
/**
 * 删除商品通过id
 * */
	public int deleGoodsById(int id);
	
	
}
