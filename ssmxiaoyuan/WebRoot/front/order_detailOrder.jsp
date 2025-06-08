<%@page import="com.zs.test.paramEntity.HalfOrderext"%>
<%@page import="com.zs.test.paramEntity.FullOrders"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
FullOrders fullOrders=(FullOrders)request.getAttribute("fullOrders");
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>订单详情</title>
    <meta name="renderer" content="webkit">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/reset.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/order-detail.css">
</head>
<body>
<%@include file="index_header.jsp" %>

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
                订单详情
            </div>
            <div class="content-second-add">地址：<span><%=fullOrders.getAddress().getAddress() %>,<%=fullOrders.getAddress().getName() %>,<%=fullOrders.getAddress().getPhone() %></span></div>
            <div class="content-second-table mt-20">
                <table>
                    <tbody>
                    <tr>
                        <th>商品名称</th>
                        <th>单价</th>
                        <th>数量</th>
                        <th>小计</th>
                    </tr>
                    <%List<HalfOrderext> halfList=fullOrders.getHalfOrderextList(); %>
                    <%for(int i=0,max=halfList.size();i<max;i++){ %>
                    <tr>
                        <td><%=halfList.get(i).getGoods().getName() %></td>
                        <td>&yen;<%=halfList.get(i).getGoods().getPrice() %></td>
                        <td>
                           <%=halfList.get(i).getOrderext().getNum() %>
                        </td>
                        <%int p=halfList.get(i).getGoods().getPrice()*halfList.get(i).getOrderext().getNum(); %> 
                        <td style="color: red">&yen;<%=p %></td>
                    </tr>
                   <%} %>
                    </tbody>
                </table>
            </div>
            <div class="content-second-last clear mt-20">
                <div class="last-right">
                    应付金额：<span>&yen;<%=fullOrders.getOrders().getPrice() %></span>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>