package com.zs.test.entity;

public class Goods {
	private int id;
	private String name;
	private int cata;
	private int price;
	private int sum;
	private int salesum;
	private String imgurl;
	private long addtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCata() {
		return cata;
	}
	public void setCata(int cata) {
		this.cata = cata;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public long getAddtime() {
		return addtime;
	}
	public void setAddtime(long addtime) {
		this.addtime = addtime;
	}
	public int getSalesum() {
		return salesum;
	}
	public void setSalesum(int salesum) {
		this.salesum = salesum;
	}
	
}
