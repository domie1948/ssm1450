package com.zs.test.util;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

/**
 * Description:Session工具类
 * 
 */
public class SessionUtil {

	/**
	 * 设置alert信息
	 * 
	 * 
	 * @param message
	 *            要显示的alert信息
	 */
	public static void setAlert(String message) {
	
		if (message!="" && message!=null) {
			ActionContext ac = ActionContext.getContext();
			Map session = ac.getSession();
			session.remove("sessionAlert");
			ServletActionContext.getRequest().getSession().setAttribute("sessionAlert", message);
		} else {
			ActionContext ac = ActionContext.getContext();
			Map session = ac.getSession();
			session.remove("sessionAlert");
		}
	}

	/**
	 * 删除alert信息
	 * 
	 * 
	 */
	public static void deleteAlert() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.remove("sessionAlert");
	}

	/**
	 * 获取alert信息
	 * 
	 * 
	 */
	public static String getAlert() {
		
		return (String) ServletActionContext.getRequest().getSession().getAttribute("sessionAlert");
	}

	
}