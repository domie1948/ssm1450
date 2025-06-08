package com.zs.test.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.test.dao.inf.GoodsDao;
import com.zs.test.dao.inf.UserDao;
import com.zs.test.entity.Goods;
import com.zs.test.service.inf.IGoodsService;
@Service("front_goodsServiceImpl")
public class GoodsServiceImpl implements IGoodsService {
	
	@Autowired
	@Resource(name = "front_goodsDao")
	private GoodsDao goodsDao;
	@Override
	public Goods getGoodsById(int id) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsById(id);
	}

	@Override
	public int addGoods(Goods goods) {
		// TODO Auto-generated method stub
		goods.setAddtime(new Date().getTime());
		return goodsDao.addGoodsFull(goods);
	}

	@Override
	public List<Goods> getAllGoods() {
		// TODO Auto-generated method stub
		return goodsDao.getAllGoods();
	}

	@Override
	public int delGoods(int id) {
		// TODO Auto-generated method stub
		return goodsDao.deleGoodsById(id);
	}

	@Override
	public List<Goods> getGoodsListSome(int start, int end,String orderBy) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsListSome(start, end,orderBy);
	}

	@Override
	public List<Goods> getGoodsByCata(int cata) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsBycata(cata);
	}

}
