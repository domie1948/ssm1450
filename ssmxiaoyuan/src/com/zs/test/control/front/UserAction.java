package com.zs.test.control.front;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zs.test.entity.User;
import com.zs.test.service.inf.IUserService;

@Controller("front_userAction")
@Scope("request")
public class UserAction extends ActionSupport{
	@Autowired
	@Resource(name = "front_userServiceImpl")
	private IUserService userService;
	
	private String actionurl;
	private InputStream json;
	private User user=new User();
	/**
	 * 注册
	 * */
	public String reg(){
		return SUCCESS;
	}
	/**
	 * 处理注册
	 * */
	public String doreg() throws Exception{
		user.setNickname("SC"+new Date().getTime());
		if(userService.addUser(user)>0){
			this.json=new ByteArrayInputStream("success".getBytes("UTF-8"));
		}else{
			this.json=new ByteArrayInputStream("fail".getBytes("UTF-8"));
		}
		return "ajaxjson";
	}
	public String login(){
		return SUCCESS;
	}
	public String dologin() throws Exception{
		User temuser=userService.getUserByNameOrPhone(user);
		if(temuser.getPassword().equals(user.getPassword())){
			ServletActionContext.getRequest().getSession().setAttribute("user", temuser);
			this.json=new ByteArrayInputStream("success".getBytes("UTF-8"));
		}else{
			this.json=new ByteArrayInputStream("fail".getBytes("UTF-8"));
		}
		
		return "ajaxjson";
	}
	public String logout() throws Exception{
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.remove("user");
		this.json=new ByteArrayInputStream("success".getBytes("UTF-8"));
		
		return "ajaxjson";
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
