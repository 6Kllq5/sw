<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="css/right1.css"/>
	<link rel="stylesheet" type="text/css" href="css/right3.css"/>
</head>
<body>
		<!--上方的提示栏-->
			<div class="tishilan">
				<p class="tishilan-p">位置：</p>
				<ul>
					<li class="tishilan-li">
						<a href="#">首页</a><img src="img/icon_fenge.png" /></li>
					<li class="tishilan-li">
						<a href="#">此处显示开始和未开始</a><img src="img/icon_fenge.png" /></li>
						<li class="tishilan-li">
						<a href="#">案例编写</a><img src="img/icon_fenge.png" /></li>
					<li class="tishilan-li">此处显示具体的案例编号：<编号></li>

				</ul>
			</div>
	</body>
</html>