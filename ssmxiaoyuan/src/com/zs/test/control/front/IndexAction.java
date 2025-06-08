package com.zs.test.control.front;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zs.test.entity.Goods;
import com.zs.test.service.inf.IGoodsService;

@Controller("front_indexAction")
@Scope("request")
public class IndexAction extends ActionSupport{
	private String actionurl;
	private InputStream json;
	
	@Resource(name = "front_goodsServiceImpl")
	private IGoodsService goodsService;
	
	private List<Goods> listGoods;
	private List<Goods> listGoodstwo;
	/**
	 * 首页
	 * */
	public String index(){
		listGoods=goodsService.getGoodsListSome(0, 8,"goods.addtime desc");
		listGoodstwo=goodsService.getGoodsListSome(0, 8,"goods.salesum desc");
		return SUCCESS;
	}
	public String getActionurl() {
		return actionurl;
	}
	public void setActionurl(String actionurl) {
		this.actionurl = actionurl;
	}
	public InputStream getJson() {
		return json;
	}
	public void setJson(InputStream json) {
		this.json = json;
	}
	public List<Goods> getListGoods() {
		return listGoods;
	}
	public void setListGoods(List<Goods> listGoods) {
		this.listGoods = listGoods;
	}
	public List<Goods> getListGoodstwo() {
		return listGoodstwo;
	}
	public void setListGoodstwo(List<Goods> listGoodstwo) {
		this.listGoodstwo = listGoodstwo;
	}
	
	
	
}
