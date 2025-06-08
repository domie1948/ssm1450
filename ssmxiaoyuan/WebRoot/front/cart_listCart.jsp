<%@page import="com.zs.test.paramEntity.FullCart"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<FullCart> fullCartList=(List<FullCart>)request.getAttribute("fullCartList");
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>购物车-结算</title>
    <meta name="renderer" content="webkit">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/reset.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/shop-car.css">
</head>
<body>
<!--***header***-->
<%@include file="index_header.jsp" %>
<!--***main-->
<div class="main">
    <div class="common">
        <div class="content-first clear">
            <div class="content-first-logo">
                <div class="logo-img">
                    <img src="<%=path%>/img/logo.png">
                </div>
            </div>
           <!-- <div class="content-first-search">
                <div class="clear">
                    <input type="text" placeholder="商品">
                    <button>搜索</button>
                </div>
            </div>-->
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
                        <th>单价</th>
                        <th>数量</th>
                        <th>小计</th>
                        <th>操作</th>
                    </tr>
                    <%
                     int sum=0;
                    if(fullCartList!=null &&fullCartList.size()>0){
                   
                     %>
                    <%for(int i=0,max=fullCartList.size();i<max;i++){ %>
                    <tr>
                        <td><%=fullCartList.get(i).getGoods().getName() %></td>
                        <td>&yen;<%=fullCartList.get(i).getGoods().getPrice() %></td>
                        <td>
                            <div class="first-right-middle-text-btn">
                                <button class="first-right-middle-sub">-</button><input type="text" value="<%=fullCartList.get(i).getCart().getSum() %>"/><button class="first-right-middle-add">+</button>
                            </div>
                        </td>
                        <%int m=fullCartList.get(i).getGoods().getPrice() *fullCartList.get(i).getCart().getSum();
                        sum=sum+m;
                         %>
                        <td style="color: red">&yen;<%=m %></td>
                        <td><a class="delete" onclick="delcart(<%=fullCartList.get(i).getCart().getId() %>)">删除</a></td>
                    </tr>
                    
                    <%} }%>
                   
                    </tbody>
                </table>
            </div>
            <div class="content-second-last clear mt-20">
                <div class="content-second-last-left fl">
                    总价： <span>&yen;<%=sum %></span>
                </div>
                <div class="content-second-right fr" onclick="window.location.href='front_cartAction_confirmCart'">
                    <span>结算</span>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    $(".first-right-middle-sub").click(function(){
        var value = parseInt($(this).next().val());
        if(value!=0){
            $(this).next().val(value-1);
        }
    });
    $(".first-right-middle-add").click(function(){
        var add =$(this);
        var value = parseInt($(this).prev().val());
        var first_num =$(".first-num").html();
        $(add).prev().val(value+1);

    });
    function delcart(id){
    	if(confirm("确定要从购物车删除该商品吗？")){
    		$.post("front_cartAction_delcart",{cartId:id},function(data){
    			if(data=="success"){
    				alert("删除成功！");
    				window.location.reload();
    			}else{
    				alert("删除失败！");
    			}
    		},"text");
    	}
    }
</script>
</body>
</html>