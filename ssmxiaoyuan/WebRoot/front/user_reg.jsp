<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>注册</title>
    <meta name="renderer" content="webkit">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/reset.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/register.css">
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
                用户注册
            </div>
            <div class="login-content">
                <div class="login-content-input">
                    <input type="text" placeholder="手机号" id="phone">
                </div>
                <div class="login-content-input mt-30">
                    <input type="password" placeholder="密码" id="password">
                </div>
                <div class="login-content-input mt-30">
                    <input type="password" placeholder="确认密码" id="repassword">
                </div>

                <div class="login-button mt-20" onclick="doreg();">
                    <button type="button">注册</button>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>

<script src="<%=path %>/js/jquery-1.11.3.min.js"></script>
<script>
function doreg(){
	var res=true;
	var phone=$('#phone').val();
	var password=$("#password").val();
	var repassword=$("#repassword").val();
	if(phone==""){
	res=false;
	alert("手机号码不能为空");
	
	}else{
		var pattern=/^1[34578]\d{9}$/;
		if(!phone.match(pattern)){
		res=false;
		alert("手机号码格式不正确!");
		}
	}
	
	if(password==""){
		res=false;
		alert("密码不能为空");
	}else{
		if(password!=repassword){
		res=false;
		alert("两次密码不一致！");
		}
	}
	if(res){
		$.ajax({
		type : "POST",
		url : "front_userAction_doreg?user.phone="+phone+"&user.password="+password,
		dataType : 'text',
		success : function(data) {
			if(data=="success"){
				alert("注册成功！请登录");
				window.location.href="front_userAction_login";
			}else{
				alert("密码错误或者用户名不存在！");
			}
			
		}
	});
	}
	
	
	
}
</script>