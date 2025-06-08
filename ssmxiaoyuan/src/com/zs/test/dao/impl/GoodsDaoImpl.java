package com.zs.test.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zs.test.dao.inf.GoodsDao;
import com.zs.test.entity.Goods;
@Repository("front_goodsDao")
public class GoodsDaoImpl implements GoodsDao {

	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	private String range = "com.zs.test.dao.inf.GoodsDao";
	
	public String sqlId(String idSql) {

		String position = range + "." + idSql;
		return position;
	}
	
	
	@Override
	public Goods getGoodsById(int id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(sqlId("getGoodsById"), id);
	}

	@Override
	public int addGoodsFull(Goods goods) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(sqlId("addGoodsFull"), goods);
	}


	@Override
	public List<Goods> getAllGoods() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(sqlId("getGoodsList"));
	}


	@Override
	public int deleGoodsById(int id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete(sqlId("deleteById"),id);
	}


	@Override
	public List<Goods> getGoodsListSome( int start, int end,String orderBy) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("orderBy", orderBy);
		return sqlSessionTemplate.selectList(sqlId("getGoodsListSome"), map);
	}


	@Override
	public List<Goods> getGoodsBycata(int cata) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(sqlId("getGoodsById"), cata);
	}


	@Override
	public int updateGoods(Goods goods) {
		return sqlSessionTemplate.update(sqlId("updateGoods"), goods);
	}

}
