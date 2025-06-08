<%@page import="com.zs.test.entity.Goods"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Goods> listGoods=(List<Goods>)request.getAttribute("listGoods");
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>商品-查看更多</title>
    <meta name="renderer" content="webkit">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/reset.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/more-goods.css">
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
            <div class="content-first-search">
                <div class="clear">
                    <input type="text" placeholder="商品">
                    <button>搜索</button>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="content-third">

        </div>
        <div class="content-second">
            <div class="content-third-col-1">
                <div class="class-title"><span>所有分类</span></div>
                <ul>
                   <li onclick="window.location.href='front_goodsAction_listGoodsCata?cata=1'">
                        <span class="fl">方便零食</span><span class="fr"><i class="fa fa-angle-right"></i></span>
                        <div class="clear"></div>
                       
                    </li>
                    <li onclick="window.location.href='front_goodsAction_listGoodsCata?cata=2'">
                        <span class="fl">奶蛋制品</span><span class="fr"><i class="fa fa-angle-right"></i></span>
                        <div class="clear"></div>
                    </li>
                    <li onclick="window.location.href='front_goodsAction_listGoodsCata?cata=3'">
                        <span class="fl">饮料酒水</span><span class="fr"><i class="fa fa-angle-right"></i></span>
                        <div class="clear"></div>
                    </li>
                    <li onclick="window.location.href='front_goodsAction_listGoodsCata?cata=4'">
                        <span class="fl">生活用品</span><span class="fr"><i class="fa fa-angle-right"></i></span>
                        <div class="clear"></div>
                    </li>
                    <li onclick="window.location.href='front_goodsAction_listGoodsCata?cata=5'">
                        <span class="fl">咖啡冲饮</span><span class="fr"><i class="fa fa-angle-right"></i></span>
                        <div class="clear"></div>
                    </li>
                    <li onclick="window.location.href='front_goodsAction_listGoodsCata?cata=6'">
                        <span class="fl">日用百货</span><span class="fr"><i class="fa fa-angle-right"></i></span>
                        <div class="clear"></div>
                    </li>
                    <li onclick="window.location.href='front_goodsAction_listGoodsCata?cata=7'">
                        <span class="fl">新鲜水果</span><span class="fr"><i class="fa fa-angle-right"></i></span>
                        <div class="clear"></div>
                    </li>
                    <li onclick="window.location.href='front_goodsAction_listGoodsCata?cata=8'">
                        <span class="fl">其他</span><span class="fr"><i class="fa fa-angle-right"></i></span>
                        <div class="clear"></div>
                    </li>
                </ul>
            </div>
            <div class="content-third-col-2">
            
              <%
                int sum=0;
                for(int i=0,max=listGoods.size();i<max;i++){ 
                sum=sum+1;
                %>
                <%if(i%3==0){ %>
                
                <div class="content-third-row-first">
                <%} %>
                
                    <div class="content-third-col" onclick="window.location.href='goods-detail.html'">
                        <div class="content-third-col-img">
                            <img src="<%=path%>/<%=listGoods.get(i).getImgurl() %>">

                            <div class="content-third-col-title mt-10">
                               <%=listGoods.get(i).getName() %>
                            </div>
                            <div class="content-third-col-price mt-10">
                                <i class="fa fa-jpy"></i> <%=listGoods.get(i).getPrice() %>
                            </div>
                        </div>
                        <div class="shop-car">
                            <a href="javascript:;" class="btnCart">
                                <img src="<%=path%>/img/car.png">
                            </a>
                        </div>
                    </div>
                   
                    <%if(i!=0 && i%2==0){ %>
                    <div class="clear"></div>
               		 </div>
               	 <%} %>
             <%} %>   
              	<%if(sum%3!=0){ %>
                     <div class="clear"></div>
               		 </div>
                	<%} %>  
                
            
               
            </div>
            <div class="clear">
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<%=path %>/js/jquery-1.11.3.min.js"></script>
</body>
</html>