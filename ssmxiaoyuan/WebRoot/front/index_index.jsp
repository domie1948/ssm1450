<%@page import="com.zs.test.entity.Goods"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Goods> listGoods=(List<Goods>)request.getAttribute("listGoods");
List<Goods> listGoodstwo=(List<Goods>)request.getAttribute("listGoodstwo");
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="renderer" content="webkit">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/reset.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/main.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/banner.css">

</head>
<style>

</style>
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
            <div class="content-first-search">
                <div class="clear">
                     
                </div>
            </div>
            <div class="clear"></div>
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
                <div id="banner_tabs" class="flexslider">
                    <ul class="slides">
                        <li>
                            <a title="" target="_blank" href="#">
                                <img width="100%" src="<%=path%>/img/banner3.png">
                            </a>
                        </li>
                        <li>
                            <a title="" href="#">
                                <img width="100%"  src="<%=path%>/img/banner2.png">
                            </a>
                        </li>
                        <li>
                            <a title="" href="#">
                                <img width="100%"  src="<%=path%>/img/banner1.png">
                            </a>
                        </li>
                    </ul>
                    <ul class="flex-direction-nav">
                        <li><a class="flex-prev" href="javascript:;">Previous</a></li>
                        <li><a class="flex-next" href="javascript:;">Next</a></li>
                    </ul>
                    <ol id="bannerCtrl" class="flex-control-nav flex-control-paging">
                        <li><a>1</a></li>
                        <li><a>2</a></li>
                        <li><a>2</a></li>
                    </ol>
                </div>
            </div>
        </div>
        <div class="content-third mt-50">
            <div class="content-third-row">
                <div class="content-third-row-top">
                    <div class="content-third-row-top-left fl">
                        新品上架
                    </div>
                    <div class="content-third-row-top-right fr">
                        <a href="front_goodsAction_moreGoods">更多<i class="fa fa-angle-double-right"></i></a>
                    </div>
                    <div class="clear"></div>
                </div>
                
                <%
                int sum=0;
                for(int i=0,max=listGoods.size();i<max;i++){ 
                sum=sum+1;
                %>
                <%if(i%4==0){ %>
                <div class="content-third-row-first mt-20">
                <%} %>
                    <div class="content-third-col" >
                        <div class="content-third-col-img" onclick="window.location.href='front_goodsAction_detail?goodsId=<%=listGoods.get(i).getId() %>'">
                            <img src="<%=path%>/<%=listGoods.get(i).getImgurl() %>">
                            <div class="content-third-col-title mt-10">
                            	<%=listGoods.get(i).getName() %>
                            </div>
                            <div class="content-third-col-price mt-10">
                                <i class="fa fa-jpy"></i> <%=listGoods.get(i).getPrice() %>
                            </div>
                        </div>
                        <div class="shop-car">
                            <a  class="btnCart" onclick="addToCart(<%=listGoods.get(i).getId() %>,1)">
                                <img src="<%=path%>/img/car.png">
                            </a>
                        </div>
                    </div>
                    
                    
                    <%if(i!=0 && i%3==0){ %>
                    
                    <div class="clear"></div>
               		 </div>
                	<%} %>           	
			<%} %>
			
					<%if(sum%4!=0){ %>
                     <div class="clear"></div>
               		 </div>
                	<%} %>

            </div>
        </div>
        <div class="content-third">
            <div class="content-third-row">
                <div class="content-third-row-top">
                    <div class="content-third-row-top-left fl">
                        促销商品
                    </div>
                    <div class="content-third-row-top-right fr">
                        <a href="front_goodsAction_moreGoods">更多<i class="fa fa-angle-double-right"></i></a>
                    </div>
                    <div class="clear"></div>
                </div>
                 <%
                int su=0;
                for(int i=0,max=listGoodstwo.size();i<max;i++){ 
                su=su+1;
                %>
                <%if(i%4==0){ %>
                <div class="content-third-row-first mt-20">
                <%} %>
                    <div class="content-third-col" >
                        <div class="content-third-col-img" onclick="window.location.href='front_goodsAction_detail?goodsId=<%=listGoodstwo.get(i).getId() %>'">
                            <img src="<%=path%>/<%=listGoodstwo.get(i).getImgurl() %>">
                            <div class="content-third-col-title mt-10">
                            	<%=listGoodstwo.get(i).getName() %><%=i %>
                            </div>
                            <div class="content-third-col-price mt-10">
                                <i class="fa fa-jpy"></i> <%=listGoodstwo.get(i).getPrice() %>
                            </div>
                        </div>
                        <div class="shop-car">
                            <a onclick="addToCart(<%=listGoods.get(i).getId() %>,1)" class="btnCart">
                                <img src="<%=path%>/img/car.png">
                            </a>
                        </div>
                    </div>
                    
                    
                    <%if(i!=0 && i%3==0){ %>
                    
                    <div class="clear"></div>
               		 </div>
                	<%} %>           	
			<%} %>
			
					<%if(su%4!=0){ %>
                     <div class="clear"></div>
               		 </div>
                	<%} %>


              
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/banner.js"></script>
<script type="text/javascript">
    $(function(){
        $(".content-third-col-1 ul li").hover(function(){
            $(this).find($(".shop-classify")).show();
        },function(){
            $(this).find($(".shop-classify")).hide();
        })
    })
    
    function addToCart(goodid,sum){
    	if(userid!=-1){
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
    	}else{
    		alert("请先登录!");
    	}
    	
	
	
	
    }
</script>

</body>
</html>