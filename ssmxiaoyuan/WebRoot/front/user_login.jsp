<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>登录</title>
    <meta name="renderer" content="webkit">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/reset.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/login.css">
</head>
<body>
<div class="top">
    <div class="common">
        <div class="top-wrap">
            <div class="top-wrap-logo">
                <img src="<%=path %>/img/logo.png">
            </div>
        </div>
    </div>
</div>
<div class="main-content">
    <div class="common">
        <div class="main-content-login fr">
            <div class="login-top">
                用户登录
            </div>
            <div class="login-content">
                <div class="login-content-input">
                    <input type="text" placeholder="手机号" id="phone">
                </div>
                <div class="login-content-input mt-30">
                    <input type="password" placeholder="密码" id="password">
                </div>
                <div class="login-content-last clear mt-30">
                    <div class="login-content-pass fl">
                        <input type="checkbox"><span>记住我</span>
                    </div>
                    <div class="login-content-reg fr">
                        <a href="front_userAction_reg">免费注册</a>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="login-button mt-20" onclick="login()">
                    <button type="button">登录</button>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
<script src="<%=path %>/js/jquery-1.11.3.min.js"></script>
<script>
function login(){
	var phone=$("#phone").val();
	var password=$("#password").val();
	
	var re=true;
	if(phone==""){
		re=false;
		alert("手机号码不能为空！");
	}
	if(password==""){
		re=false;
		alert("密码不能为空！");
	}
	if(re){
		$.ajax({
		type : "POST",
		url : "front_userAction_dologin?user.phone="+phone+"&user.password="+password,
		dataType : 'text',
		success : function(data) {
			if(data=="success"){
				alert("登录成功");
				window.location.href="front_indexAction_index";
			}else{
				alert("登录失败");
			}
			
		}
	});
	}
}
</script>