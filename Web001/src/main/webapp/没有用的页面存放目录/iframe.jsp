<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/reset.css" />
		<title></title>
		<script type="text/javascript">
			alert("${session_anli.anli_id}");
		</script>
	</head>
	<frameset rows="55px,95%" frameborder="no" framespacing="no">
		<frame name="contentTop" src="<%=request.getContextPath()%>/biaoti.jsp">
		<!-- 存在两种情况是，查看和添加 -->
		<c:choose>
			<c:when test="${session_anli==null or session_anli.state==1 or session_anli.state==7 or session_anli.state==8}">
				<frame name="contentButtom" src="<%=request.getContextPath() %>/anlibianxie.jsp" >
			</c:when>
			<c:otherwise>
				<c:if test="${session_anli.state==2 }">
					<frame name="contentButtom" src="<%=request.getContextPath() %>/soujiziliao.jsp" >
				</c:if>
				<c:if test="${session_anli.state==3 }">
					<frame name="contentButtom" src="<%=request.getContextPath() %>/fenxizenduan.jsp" >
				</c:if>
				<c:if test="${session_anli.state==4 }">
				
					<frame name="contentButtom" src="<%=request.getContextPath() %>/zhidingjihua.jsp" >
				</c:if>
					<c:if test="${session_anli.state==5 }">
					<frame name="contentButtom" src="<%=request.getContextPath() %>/shishichuzhi.jsp" >
				</c:if>
				<c:if test="${session_anli.state==6  }">
					<frame name="contentButtom" src="<%=request.getContextPath() %>/jieanpinggu.jsp" >
				</c:if>
			</c:otherwise>
		</c:choose>
	</frameset>

</html>