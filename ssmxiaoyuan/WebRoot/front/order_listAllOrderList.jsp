<%@page import="com.zs.test.paramEntity.HalfOrderext"%>
<%@page import="com.zs.test.util.TimeUtil"%>
<%@page import="com.zs.test.paramEntity.FullOrders"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<FullOrders> fullOrdersList=(List<FullOrders>)request.getAttribute("fullOrdersList");
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单</title>
    <meta name="renderer" content="webkit">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/reset.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/my-order.css">
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
            <div class="content-second-top">
                所有订单
            </div>
            <%for(int i=0,max=fullOrdersList.size();i<max;i++){ %>
            <div class="content-second-table mt-20">
                <div class="content-second-table-top">
                    <div class="fl">
                        时间：<span><%=TimeUtil.dateFormateYMDHM(new Date(fullOrdersList.get(i).getOrders().getAddtime())) %></span>
                    </div>
                    <div  class="fr">
                       
                        <a class="order-detail" href="front_orderAction_detailOrder?orderId=<%=fullOrdersList.get(i).getOrders().getId()%>">订单详情</a>
                    </div>
                    <div class="clear"></div>
                </div>
                <table>
                    <tbody>
                    <tr>
                        <th>商品名称</th>
                        <th>单价</th>
                        <th>数量</th>
                        <th>小计</th>
                        <th>交易状态</th>
                        <th>操作</th>
                    </tr>
                    
                    <%
                    List<HalfOrderext> halfOrderextList=fullOrdersList.get(i).getHalfOrderextList();
                     %>
                     <%for(int j=0,ma=halfOrderextList.size();j<ma;j++){ %>
                    <tr>
                        <td><%=halfOrderextList.get(j).getGoods().getName() %></td>
                        <td>&yen;<%=halfOrderextList.get(j).getGoods().getPrice() %></td>
                        <td>
                           <%=halfOrderextList.get(j).getOrderext().getNum() %>
                        </td>
                        <%if(j==0){ %>
                        <td style="color: red">&yen;<%=fullOrdersList.get(i).getOrders().getPrice() %></td>
                        <td>
                        <%if(fullOrdersList.get(i).getOrders().getStatus()==1){%>
                        待发货
                        <%}else if(fullOrdersList.get(i).getOrders().getStatus()==2){ %>
                        待收货
                        <%} else{%>
                        已完成
                        <%} %>
                        </td>
                        <td>
                        <%if(fullOrdersList.get(i).getOrders().getStatus()==1){%>
                            <button onclick="sendOrder('<%=fullOrdersList.get(i).getOrders().getId() %>')">发货</button>
                         <%} %>
                        </td>
                        <%}else{ %>
                        <td style="color: red"></td>
                        <td></td>
                        <td>
                           
                        </td>
                        <%} %>
                    </tr>
                    <%} %>
              
                    </tbody>
                </table>
            </div>
          <%} %>
        </div>

    </div>
</div>
<script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
<script>
function sendOrder(id){
	if(confirm("确认要发货吗？")){
	window.location.href="front_orderAction_sellerupdateOrder?orders.status=2&orders.id="+id;
	}
}
</script>
<%@include file="alertUtil.jsp" %>
</body>
</html>
