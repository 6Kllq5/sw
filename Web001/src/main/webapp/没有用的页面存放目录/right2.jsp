<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="swutil.UrlKit" %>
<%
//在该页面中清空session中的数据
if(session.getAttribute("session_anli")!=null){
	//如果存在session数据就清空数据
	session.removeAttribute("session_anli");
}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/reset.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/right2.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/right1.css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
		<title>案例列表</title>
	</head>
	<body>
		<div class="right1">
			<!--上方的提示栏-->
			<div class="tishilan">
				<p class="tishilan-p">位置：</p>
				<ul>
					<li class="tishilan-li">
						<a href="#">首页</a><img src="<%=request.getContextPath() %>/img/icon_fenge.png" /></li>
					<li class="tishilan-li">
						<a href="#">系统设置</a><img src="<%=request.getContextPath() %>/img/icon_fenge.png" /></li>
					<li class="tishilan-li">未开始
					</li>
				</ul>
			</div>
			<!--查询部分,只有role不等于0的情况才可以进行查看-->
			<c:if test="${userMap['role']!=0}">
				<div class="chaxun">
					<form method="post">
						<label>状态查询:</label>
						<!-- 转台查询并做参数回显 -->
						<select onchange="selectChange()">
							<c:choose>
								<c:when test="${selectParam.minstate==1 and selectParam.maxstate==8}">
									<option value="18" selected="selected">全部</option>
								</c:when>
								<c:otherwise>
									<option value="18">全部</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${selectParam.minstate==7 and selectParam.maxstate==7}">
									<option value="77" selected="selected">已结案</option>
								</c:when>
								<c:otherwise>
									<option value="77">已结案</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${selectParam.minstate==1 and selectParam.maxstate==6}">
									<option value="16" selected="selected">未结案</option>
								</c:when>
								<c:otherwise>
									<option value="16">未结案</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${selectParam.minstate==8 and selectParam.maxstate==8}">
									<option value="88" selected="selected">转介</option>
								</c:when>
								<c:otherwise>
									<option value="88">转介</option>
								</c:otherwise>
							</c:choose>
						</select>
					</form>
					
					<form method="post">
						<label>按学号/班级查找:</label>
						<input type="text" name="bianhao" placeholder="请输入学号/班级" value="${selectParam.bianhao}" class="tiaojian" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label>姓名:</label>
						<input type="text" name="loginname" placeholder="请输入工作者姓名" value="${selectParam.loginname}" class="tiaojian" />
					</form>
					<form method="post">
						<input type="button" value="查询" class="cx-button" onclick="cx()"/>
					</form>
				</div>
			</c:if>
			<div class="right-nav">
				<p>案例列表</p>
			</div>
			<form id="turnPagefm" action="<%=UrlKit.getDomain(request) %>/getAllAnLiCtrl/getAllAnLi" method="post">
			<table  class="biaoge" >
				<tr style="background:#f0f5f7 ; border-bottom: 1px solid #C3C3C3;">
					<th>序号</th>
					<th>编号</th>
					<th>标题</th>
					<th>案主名</th>
					<th>案件状态</th>
					<th>发布时间</th>
					<th>是否审核</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${list}" var="data" varStatus="vs">
					<!-- 默认是编辑 -->
					<tr id="tr" class="zhenda" onclick="stepLook('${userMap['userid']}','${data.anli_id }',${data.state})">
						<td style="background: url(<%=request.getContextPath() %>/img/line.gif);background-repeat: no-repeat;background-position: right;">${vs.count }</td>
						<td style="background: url(<%=request.getContextPath() %>/img/line.gif);background-repeat: no-repeat;background-position: right;">${data.anli_no }</td>
						<td style="background: url(<%=request.getContextPath() %>/img/line.gif);background-repeat: no-repeat;background-position: right;">${data.anli_name }</td>
						<td style="background: url(<%=request.getContextPath() %>/img/line.gif);background-repeat: no-repeat;background-position: right;">${data.anzhu_name }</td>
						<c:if test="${data.state <=6 && data.state >=1  }">
							<td style="background: url(<%=request.getContextPath() %>/img/line.gif);background-repeat: no-repeat;background-position: right;">未结案</td>
						</c:if>
						<c:if test="${data.state ==7 }">
							<td style="background: url(<%=request.getContextPath() %>/img/line.gif);background-repeat: no-repeat;background-position: right;">已结案</td>
						</c:if>
						<c:if test="${data.state ==8 }">
							<td style="background: url(<%=request.getContextPath() %>/img/line.gif);background-repeat: no-repeat;background-position: right;">转介</td>
						</c:if>
						<td style="background: url(<%=request.getContextPath() %>/img/line.gif);background-repeat: no-repeat;background-position: right;">${data.anli_date }</td>
						<td style="background: url(<%=request.getContextPath() %>/img/line.gif);background-repeat: no-repeat;background-position: right;">已审核</td>
						<td><a id="deleteLink" href="javascript:void(0)" onclick="event.stopPropagation();deleteAnLi('${userMap['userid']}','${data.anli_id }')" style="margin-left: 10px;">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<%-- <%@include file="turnPage.jsp"%> --%>
			</form>
			<br><br><br>
		</div>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/right2.js"></script>
	</body>
</html>