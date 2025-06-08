<%@page import="com.zs.test.entity.Goods"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Goods tempGoods=(Goods)request.getAttribute("tempGoods");
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>商品详情</title>
    <meta name="renderer" content="webkit">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/reset.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/goods-detail.css">
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
          <!--  <div class="content-first-search">
                <div class="clear">
                    <input type="text" placeholder="商品">
                    <button>搜索</button>
                </div>
            </div>-->
            <div class="clear"></div>
        </div>
        <div class="content-second">
            <div class="content-second-top">
                <div class="content-second-top-box">
                    <div class="section-area-select-top">所有分类 <i class="fa fa-angle-down"></i></div>
                    <div class="section-area-select-droplist">
                        <ul>
                            <li onclick="window.location.href='front_goodsAction_listGoodsCata?cata=1'">
                                <span class="fl">奶蛋制品</span><span class="fr"><i class="fa fa-angle-right"></i></span>
                                <div class="clear"></div>
                            </li>
                            <li onclick="window.location.href='front_goodsAction_listGoodsCata?cata=2'">
                                <span class="fl">方便零食</span><span class="fr"><i class="fa fa-angle-right"></i></span>
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
                        </ul>
                    </div>
                </div>
                <div class="content-second-top-box">
                    <a href="front_indexAction_index">首页</a>
                </div>
            </div>
            <div class="content-second-wrap clear">
                <div class="content-second-wrap-left">
                    <img class="shop-img" src="<%=path%>/<%=tempGoods.getImgurl()%>">
                    <div class="section-area-first-foot mt-30 clear">
                        <div class="first-foot-shop-img"><img class="shop-img-list" src="<%=path%>/<%=tempGoods.getImgurl()%>" alt=""/></div>
                        <div class="first-foot-shop-img"><img class="shop-img-list" src="<%=path%>/<%=tempGoods.getImgurl()%>" alt=""/></div>
                       <!--  <div class="first-foot-shop-img"><img class="shop-img-list" src="<%=path%>/img/bread.png" alt=""/></div>
                        <div class="first-foot-shop-img"><img class="shop-img-list" src="<%=path%>/img/bread.png" alt=""/></div>
                        <div class="first-foot-shop-img"><img class="shop-img-list" src="<%=path%>/img/bread.png" alt=""/></div>
                        <div class="first-foot-shop-img"><img class="shop-img-list" src="<%=path%>/img/bread.png" alt=""/></div>
                         -->
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="content-second-wrap-right">
                    <div class="content-second-wrap-right-top">
                        <%=tempGoods.getName() %>
                    </div>
                    <div class="content-second-wrap-right-content clear">
                        <div class="content-second-wrap-right-left fl">
                       
                            <div>
                                <span class="content-second-wrap-right-left-attr">价格:</span>
                                <span class="content-second-wrap-right-left-sale">￥<%=tempGoods.getPrice() %></span>
                            </div>
                        </div>
                        <div class="content-second-wrap-right-right fr">
                            
                            <div class="content-second-wrap-right-right-list1"></div>
                            <div class="content-second-wrap-right-right-list">
                                <span><%=tempGoods.getSalesum()%></span>
                                <span>总销量</span>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="content-second-wrap-right-middle">
                        <div class="content-second-wrap-right-middle-num"><span>数量 :</span></div>
                        <div class="content-second-wrap-right-middle-text-btn">
                            <button class="content-second-wrap-right-middle-sub">-</button><input type="text" value="1"/><button class="content-second-wrap-right-middle-add">+</button>
                        </div>
                        <div class="content-second-wrap-right-middle-num"><span>（库存 : <span class="first-num"><%=tempGoods.getSum() %></span>）</span></div>
                    </div>
                    <div class="section-area-first-right-foot">
                        <button class="first-right-foot-add-car" onclick="addToCart(<%=tempGoods.getId() %>,1)">加入购物车</button>
                    </div>
                </div>

                <div class="clear"></div>
            </div>
        </div>
        
    </div>
</div>

<script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">

    $(function(){
        $(".content-second-top-box").hover(function(){
            $(".section-area-select-droplist").show();
        },function(){
            $(".section-area-select-droplist").hide();
        });
    });
//数量加减
    $(function(){
        $(".shop-img-list").hover(function(){
            var img = $(this).attr("src");
            $(this).parent().parent().prev().attr("src",img);
        });
        $(".content-second-wrap-right-middle-sub").click(function(){
            var value = parseInt($(this).next().val());
            if(value!=0){
                $(this).next().val(value-1);
            }
        });
        $(".content-second-wrap-right-middle-add").click(function(){
            var value = parseInt($(this).prev().val());
            var first_num =$(".first-num").html();
            if(value < first_num){
                $(".content-second-wrap-right-middle-add").prev().val(value+1);
            }
        });
    })
  function addToCart(goodid,sum){
    
    	$.ajax({
		type : "POST",
		url : "front_cartAction_addCart?goodId="+goodid+"&cart.sum="+sum,
		dataType : 'text',
		success : function(data) {
			if(data=="success"){
				alert("加入购物车成功");
				
			}else{
				alert("加入购物车成功失败");
			}
			
		}
	});
    }
</script>

</body>
</html>
