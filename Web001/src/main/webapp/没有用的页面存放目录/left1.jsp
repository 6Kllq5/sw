<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/left.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/reset.css" />
		<script src="<%=request.getContextPath() %>/js/left.js" type="text/javascript" charset="utf-8"></script>
		<title></title>
	</head>

	<body>
		<div class="left">
			<img src="img/face1.gif" class="face" />
			<div class="liebiao">
				<ul>
					<li id="li1" style="background: url(img/libg.png);" onclick="a()" onmouseup="m1()"><img src="img/yuan.png" class="jiantou" id="jiantou1" />
						<p class="wenzi" id="wenzi1">通知编辑</p>
					</li>
					<ul id="xiabian">
						<li>开始</li>
						<li>结束</li>
					</ul>
					<li id="li2" onclick=" b()" onmouseup="m2()"><img src="img/hz.png" class="jiantou" id="jiantou2" />
						<p class="wenzi1" id="wenzi2">学生信息列表</p>
					</li>
					<ul id="xiabian1">
						<li>开始</li>
						<li>结束</li>
					</ul>
					<li id="li3" onclick="c()" onmouseup="m3()"><img src="img/hz.png" class="jiantou" id="jiantou3" />
						<p class="wenzi1" id="wenzi3">案例库</p>
					</li>
					<ul id="xiabian2">
						<li>开始</li>
						<li>结束</li>
					</ul>
				</ul>
			</div>
		</div>
	</body>

</html>