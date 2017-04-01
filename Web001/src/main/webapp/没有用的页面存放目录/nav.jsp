<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@page import="swutil.UrlKit" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/nav.css" />
		<link rel="stylesheet" type="text/css" href="css/reset.css" />
		<title></title>
	</head>
	<body>
		<div class="nav">
			<ul>
				<li>
					<a href="javascript:void(0)" onclick="window.parent.leftFrame.location='<%=request.getContextPath() %>/left1.jsp';window.parent.rightFrame.location='<%=request.getContextPath() %>/right1.jsp';">首页</a>
				</li>
				<li>
					<a href="javascript:void(0)" onclick="getAllAnLi()">个案工作</a>
				</li>
				<li>
					<a href="javascript:void(0)">小组工作</a>
				</li>
				<li>
					<a href="javascript:void(0)">社区工作</a>
				</li>
				<li>
					<a href="javascript:void(0)">设置</a>
				</li>
			</ul>
		</div>
	</body>
	
	<script type="text/javascript">
		function getAllAnLi(){
			sessionStorage.minstate=1;
			sessionStorage.maxstate=8;
			window.parent.leftFrame.location="<%=request.getContextPath() %>/left2.jsp";
			window.parent.rightFrame.location="<%=UrlKit.getDomain(request)%>/getAllAnLiCtrl/getAllAnLi?minstate=1&maxstate=8&startNum=0&rowInOnePage=10&fk_userid=${userMap['userid']}";
		}
	</script>
</html>