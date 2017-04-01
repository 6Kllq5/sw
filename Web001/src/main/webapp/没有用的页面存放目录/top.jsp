<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/reset.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/top.css" />
		<title></title>
	</head>

<body>
		<!--实现背景-->
		<div class="beijing">
			<img src="<%=request.getContextPath()%>/img/logo1.png" />
			<img src="<%=request.getContextPath()%>/img/topright.jpg" style="position: absolute;right: 0;top: 0;z-index: 0;"/>
		</div>
		<!--右侧部分-->
		<div class="youce">
			<ul class="top">
				<li style="padding-right: 8px;"><img src="<%=request.getContextPath() %>/img/help.png" style="float: left;"/>帮助</li>
				<li>关于</li>
				<li style="border: none;">退出</li>
			</ul>
			<div class="bottom">
				<img src="<%=request.getContextPath() %>/img/admin.png" class="admin"/>
				<span class="span">
					<p>${userMap['loginname']}</p>
				</span>
				<span class="xiaoxi">
					消息
				</span>
				<p class="top-p">
				</p>
			</div>
		</div>
	</body>
</html>