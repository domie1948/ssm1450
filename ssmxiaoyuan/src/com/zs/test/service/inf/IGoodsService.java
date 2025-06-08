package com.zs.test.service.inf;

import java.util.List;

import com.zs.test.entity.Goods;

/**
 * goodsservice
 * */
public interface IGoodsService {
	/**
	 * 通过id获取goods实体
	 * */
	public Goods getGoodsById(int id);
	
	/**
	 * 通过cata获取goodslist
	 * */
	public List<Goods> getGoodsByCata(int cata);
	
	/**
	 * 通过id获取goods实体
	 * */
	public List<Goods> getGoodsListSome(int start,int end,String orderBy);
	/**
	 * 
	 * */
	public int addGoods(Goods goods);
	
	/**
	 * 获得所有goods
	 * */
	public List<Goods> getAllGoods();
	
	/**
	 * 删除goods
	 * */
	public int delGoods(int id);
}
