<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
/* int state =Integer.parseInt(request.getParameter("state")) ; */

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/right1.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/right3.css"/>
		<title></title>
	</head>
	<frameset rows="55px,95%" frameborder="no" framespacing="no">
		<frame name="contentTop" src="<%=request.getContextPath()%>/mn.jsp" >
		<frame name="contentButtom" src="<%=request.getContextPath() %>/iframe.jsp" width="100%" height="1000px" frameborder="0" marginwidth="30px">
		<!-- 存在两种情况是，查看和添加 -->
	</frameset>
</html>
