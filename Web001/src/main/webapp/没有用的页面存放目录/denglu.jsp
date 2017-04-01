<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="swutil.UrlKit" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/denglu.css" />
		<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
		<title></title>
	</head>
	<body style="background: url(img/bg123.png);">
		<div class="denglu" >
			<p>信息管理系统界面</p>
			<form class="biaodan" id="loginForm" action="<%=UrlKit.getDomain(request) %>/loginCtrl/login" method="post">
				<label class="labe1">用 户 名</label><input type="text" placeholder="请输入您的用户名" class="shurukuang" name="loginname" />
				<br />
				<label class="labe1">密&nbsp;&nbsp;码</label><input type="password" placeholder="请输入您的密码" class="shurukuang" name="password"/>
			</form>
			<input type="checkbox" id="jzmm"><label for="jzmm">记住密码</label>
			<a href="jaavscript:void(0)">忘记密码</a>
			<button type="button" id="loginBtn">登录</button>
		</div>
	</body>
	<script src="<%=request.getContextPath()%>/js/login.js"></script>
</html>