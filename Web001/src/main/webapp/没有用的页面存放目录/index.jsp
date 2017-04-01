<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
	    <title>首页</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
  	</head>
	<frameset rows="90px,50px,75%" frameborder="no">
		<frame name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" src="<%=request.getContextPath() %>/top.jsp">
		<frame name="top2Frame" scrolling="no" noresize="noresize" id="daohang" title="daohangFrame" src="<%=request.getContextPath() %>/nav.jsp">
		<frameset cols="10%,90%">
			<frame src="<%=request.getContextPath() %>/left1.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" >
			<frame src="<%=request.getContextPath() %>/right1.jsp" name="rightFrame" id="rightFrame" title="rightFrame">
		</frameset>
	</frameset>
</html>