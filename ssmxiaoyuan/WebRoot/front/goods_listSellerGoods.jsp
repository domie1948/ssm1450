<%@page import="com.zs.test.entity.Goods"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
List<Goods> listGoods=(List<Goods>)request.getAttribute("listGoods");
 %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>卖家商品列表</title>
    <meta name="renderer" content="webkit">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/reset.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/seller-goods-list.css">
</head>
<body>
<%@include file="index_header.jsp" %>

<!--***content***-->
<div class="main">
    <div class="common">
        <div class="content-first clear">
            <div class="content-first-logo">
                <div class="logo-img">
                    <img src="<%=path %>/img/logo.png">
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
                商品列表
            </div>
            <div class="content-second-table mt-20">
                <table>
                    <tbody>
                    <tr>
                        <th>商品名称</th>
                        <th>库存</th>
                        <th>金额</th>
                        <th>所属分类</th>
                        <th>操作</th>
                    </tr>
                     <%for(int i=0,max=listGoods.size();i<max;i++){ %>
                    <tr>
                   
                        <td class="list-one" style="padding-left: 20px">
                            <img src="<%=path %>/<%=listGoods.get(i).getImgurl() %>">
                            <span><%=listGoods.get(i).getName() %></span>
                        </td>
                        <td><%=listGoods.get(i).getSum() %></td>
                        <td style="color: red">&yen;<%=listGoods.get(i).getPrice() %></td>
                        <%if(listGoods.get(i).getCata()==1){ %>
                       <td> 方便零食</td>
                        <%}else if(listGoods.get(i).getCata()==2){ %>
                   		<td> 奶蛋制品</td>
                     	 <%}else if(listGoods.get(i).getCata()==3){ %>
                        <td> 饮料酒水</td>
                        <%}else if(listGoods.get(i).getCata()==4){ %>
                         <td>  生活用品</td>
                        <%}else if(listGoods.get(i).getCata()==5){ %>
                        <td>咖啡冲饮</td>
                        <%}else if(listGoods.get(i).getCata()==6){ %>
                         <td>日用百货</td>
                         <%}else if(listGoods.get(i).getCata()==7){ %>
                         <td>新鲜水果</td>
                         <%}else {%>
                          <td> 其他 </td>
                         <%} %>
                        <td>
                            <a href="front_goodsAction_deleGoods?goodsId=<%=listGoods.get(i).getId() %>">删除</a>
                        </td>
                    </tr>
                    <%} %>
                    

                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>

</body>
</html>
<%@include file="alertUtil.jsp" %>