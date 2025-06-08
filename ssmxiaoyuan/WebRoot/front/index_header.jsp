<%@page import="com.zs.test.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
User tempUser=(User)request.getSession().getAttribute("user");
 %>
<script>
var userid=-1;
<%if(tempUser!=null){%>
userid="<%=tempUser.getId()%>";
<%}%>
</script>
<!--***header***-->
<div class="header">
    <div class="common">
        <div class="header-top">
            <div class="header-left fl">
                <div class="header-left-title">
                    校园超市
                </div>
            </div>
            <div class="header-right fr">
                <ul>
                <%if(tempUser==null){ %>
                    <li><a href="front_userAction_login">登录</a></li>
                    <li><a href="front_userAction_reg">注册</a></li>
                 <%}else{ %>
                 	<li><%=tempUser.getNickname()%><a href="javascript:logout();">退出</a></li>
                 	<%if(!tempUser.getNickname().equals("admin")){ %>
                 	 <li><a href="front_orderAction_listOrders">我的订单</a></li>
                    <li><a href="front_cartAction_listCart">我的购物车</a></li>
                 	<%}else{ %>
                 	  <li><a href="front_goodsAction_pubGoods">卖家发布商品</a></li>
                    <li> <a href="front_orderAction_listAllOrderList">卖家订单管理</a></li>
                 	<%} %>
                 
                 <%} %>
                   
                  
                    <div class="clear"></div>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<script>
function logout(){
if(confirm("确定要退出吗？")){
	$.post("front_userAction_logout",function(data){
		if(data=="success"){
		alert("退出成功！");
		//window.location.reload();
		window.location.href="/ssm/front_indexAction_index";
		}else{
		alert("退出失败！");
		}
	});
}
}

</script>