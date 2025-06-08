<%@page import="com.zs.test.paramEntity.FullCart"%>
<%@page import="com.zs.test.entity.Address"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
List<FullCart> fullCartList=(List<FullCart>)request.getAttribute("fullCartList");
	List<Address> addressList=(List<Address>)request.getAttribute("addressList");
 %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>提交订单</title>
    <meta name="renderer" content="webkit">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/reset.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/confirm-order.css">
</head>
<body>
<%@include file="index_header.jsp" %>
<!--***main***-->
<div class="main">
    <div class="common">
        <div class="content-first clear">
            <div class="content-first-logo">
                <div class="logo-img">
                    <img src="<%=path%>/img/logo.png">
                </div>
            </div>
            <!--<div class="content-first-search">-->
                <!--<div class="clear">-->
                    <!--<input type="text" placeholder="商品">-->
                    <!--<button>搜索</button>-->
                <!--</div>-->
            <!--</div>-->
            <div class="clear"></div>
        </div>
        <div class="content-second mt-20">
            <div class="content-second-top clear">
                <div class="content-second-top-left fl">
                    收货地址
                </div>
                <div class="content-second-top-right fr">
                    <a class="new-address">新增收货地址</a>
                </div>
                <div class="clear"></div>
            </div>
            <div class="content-second-add">
            <%
            if(addressList!=null && addressList.size()>0){
            for(int i=0,max=addressList.size();i<max;i++){ %>
                <div class="content-second-add-list">
                    <div class="fl">
                        <input type="radio" name="addressId" value="<%=addressList.get(i).getId() %>"><%=addressList.get(i).getAddress() %>
                        <span><%=addressList.get(i).getName() %></span>
                        <span><%=addressList.get(i).getPhone() %></span>
                    </div>
                    <div class="fr add-change">
                      <!--   <div class="fl add-modify"><a>修改地址</a></div> -->
                        <div class="fr"><a href="javascript:del('<%=addressList.get(i).getId() %>')">删除</a></div>
                    </div>
                    <div class="clear"></div>
                </div>
              <%}} %> 
            </div>
        </div>
        <div class="content-fourth mt-50">
            <input type="radio">货到付款
        </div>
        <div class="content-third">
            <div class="content-third-top">
                确认订单
            </div>
            <div class="content-second-table mt-20">
                <table>
                    <tbody>
                    <tr>
                        <th>商品名称</th>
                        <th>单价</th>
                        <th>数量</th>
                        <th>小计</th>
                        <!--<th>操作</th>-->
                    </tr>
                   <%  if(fullCartList!=null &&fullCartList.size()>0){
                   
                     %>
                    <%for(int i=0,max=fullCartList.size();i<max;i++){ %>
                    <tr>
                        <td><%=fullCartList.get(i).getGoods().getName() %></td>
                        <td>&yen;<%=fullCartList.get(i).getGoods().getPrice() %></td>
                        <td>
                           <span><%=fullCartList.get(i).getCart().getSum() %></span>
                        </td>
                        <%int m=fullCartList.get(i).getGoods().getPrice() *fullCartList.get(i).getCart().getSum();
                         %>
                        <td style="color: red">&yen;<%=m %></td>
                        <!--<td><a class="delete">删除</a></td>-->
                    </tr>
					<%}} %>
                    </tbody>
                </table>
            </div>
            <div class="content-second-last clear mt-20">
                <button type="button" onclick="addorder();">提交订单</button>
            </div>
        </div>
    </div>
</div>

<!--pop-up-->
<div class="mask">
    <div class="pop-address">
    	<form action="front_addressAction_addAddress" method="post">
        <div class="pop-address-top">
            <span>新增收货地址</span>
            <span class="close-img">
                <img src="<%=path%>/img/close.png">
            </span>
        </div>
        <div class="pop-address-content">
            <div class="pop-address-content-list mt-20">
                <label>详细地址：</label>
                <textarea name="address.address"></textarea>
            </div>
            <div class="pop-address-content-list1 mt-20">
                <label> 收货人：</label>
                <input type="text" name="address.name">
            </div>
            <div class="pop-address-content-list1 mt-20">
                <label> 手机号：</label>
                <input type="text" name="address.phone">
            </div>
        </div>
        <div class="pop-address-btn mt-30">
            <button type="submit">保存</button>
        </div>
        </form>
    </div>
</div>

<script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    $(".new-address").click(function(){
        $(".mask").fadeIn();
        $(".pop-address").fadeIn();
    })
    $(".add-modify").click(function(){
        $(".mask").fadeIn();
        $(".pop-address").fadeIn();
    })
    $(".close-img").click(function(){
        $(".mask").fadeOut();
        $(".pop-address").fadeOut();
    })
    function del(id){
     if(confirm("确定要删除地址吗？")){
     window.location.href='front_addressAction_deleteAddress?addressId='+id;
     }
    }
    
    function addorder(){
    var addId=$("input[name='addressId']:checked").val(); 
   	window.location.href="front_orderAction_addCart?addressId="+addId;
    }
</script>
<%@include file="alertUtil.jsp" %>
</body>
</html>