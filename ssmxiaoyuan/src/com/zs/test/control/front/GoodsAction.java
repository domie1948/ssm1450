package com.zs.test.control.front;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.jmx.snmp.Timestamp;
import com.zs.test.dao.inf.GoodsDao;
import com.zs.test.entity.Goods;
import com.zs.test.service.inf.IGoodsService;
import com.zs.test.util.SessionUtil;

import org.apache.commons.io.FileUtils;

@Controller("front_goodsAction")
@Scope("request")
public class GoodsAction extends  ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String actionurl;
	private InputStream json;
	@Autowired
	@Resource(name = "front_goodsServiceImpl")
	private IGoodsService goodsService;
	private Goods goods=new Goods();
	private Goods tempGoods;
	private List<Goods> listGoods;
	private Integer goodsId;
	private Integer cata;
	private File uploadFile;// 得到上传的文件
	
    private String uploadFileContentType;// 得到文件的类型

    private String uploadFileName;// 得到文件的名称
    
	/**
	 * 发布商品
	 * */
	public String pubGoods(){
		return SUCCESS;
	}
	/**
	 * 处理发布商品
	 * */
	public String doPub() throws Exception {
		int result=0;
		if(upload()){
			goods.setImgurl("images/"+uploadFileName);
			result=goodsService.addGoods(goods);
		}
		 
		
		if(result>0){
			actionurl="front_goodsAction_listSellerGoods";
		}else{
			actionurl="front_goodsAction_pubGoods";
		}
		return "redirect";
	}
	/**
	 * 列出卖家发布的商品
	 * */
	public String listSellerGoods(){
		listGoods=goodsService.getAllGoods();
		return SUCCESS;
	}
	/**
	 * 更多商品
	 * */
	public String moreGoods(){
		listGoods=goodsService.getAllGoods();
		return SUCCESS;
	}
	/**
	 * 删除商品
	 * */
	public String deleGoods(){
		int result=goodsService.delGoods(goodsId);
		if(result>0){
			SessionUtil.setAlert("删除成功");
		}else{
			SessionUtil.setAlert("删除失败");
		}
		actionurl="front_goodsAction_listSellerGoods";
		return "redirect";
	}
	
	/**
	 * 列出某个分类下面的所有商品
	 * */
	public String listGoodsCata(){
		listGoods=goodsService.getGoodsByCata(cata);
		return SUCCESS;
	}
	
	/**
	 * 商品详情
	 * */
	
	public String detail(){
		tempGoods=goodsService.getGoodsById(goodsId);
		return SUCCESS;
	}
	  //上传文件

    public boolean upload() throws Exception {

           String realpath = ServletActionContext.getServletContext().getRealPath(

                         "/images");

           File dir = new File(realpath);

           if (!dir.exists()) {

                  dir.mkdir();

           }

          

           if(uploadFileContentType.equals("image/jpeg")){

                  uploadFileContentType=".jpg";                 

           }else if(  uploadFileContentType.equals("image/png")){

                  uploadFileContentType=".png";                

           } else if(uploadFileContentType.equals("image/gif")){

                  uploadFileContentType=".gif";                  

           }            

           uploadFileName="image"+new Timestamp().getDateTime()+uploadFileContentType;        
           FileUtils.copyFile(uploadFile, new File(dir, uploadFileName));

           return true;

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
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<Goods> getListGoods() {
		return listGoods;
	}

	public void setListGoods(List<Goods> listGoods) {
		this.listGoods = listGoods;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getCata() {
		return cata;
	}
	public void setCata(Integer cata) {
		this.cata = cata;
	}
	public Goods getTempGoods() {
		return tempGoods;
	}
	public void setTempGoods(Goods tempGoods) {
		this.tempGoods = tempGoods;
	}
	
	
}
