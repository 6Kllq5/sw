<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--引入jstl 库函数包 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="swutil.UrlKit"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/reset.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/soujizilia.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/anlibianxie.css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.1.1.min.js" ></script>
		<title>收集资料</title>
	</head>
	<body>
		<p class="huanyingyu">Hi,<b style="color: red;">admin</b>,欢迎进行案例填写</p>
		<div class="shangchuanxinxi">
			<p> 用户上传文件列表</p>
			<table border="0" class="biaobiao">
				<tr style="background:#f0f5f7 ; border-bottom: 1px solid #C3C3C3;">
					<th style="width: 10%;">序号</th>
					<th style="width: 15%;overflow: hidden;">文件名</th>
					<th style="width: 15%;">更新时间</th>
					<th style="width: 25%;">上传者</th>
					<th>操作</th>
				</tr>
				<!--内容-->
				<%-- <c:forEach var="每个变量名字" items="要迭代的list" varStatus="每个对象的状态"
                           begin="循环从哪儿开始" end="循环到哪儿结束" step="循环的步长">
                </c:forEach> --%>
				<c:forEach items="${list}" var="data" varStatus="vs">
					<tr class="bianse">
						<td style="width: 10%;">${vs.count}</td>
						<td style="width: 15%;">${data['wenjian_name'] }</td>
						<td style="width: 15%;">${data['wenjian_gengxinshijian']}</td>
						<td style="width: 25%;">${userMap['loginname']}</td>
						<td class="bianji">
							<ul>
								<a href="<%=UrlKit.getDomain(request)%>/deleteFileCtrl/deleteFile?fk_userid=${userMap['userid']}&fk_anli_id=${session_anli.anli_id}&wenjian_id=${data.wenjian_id}">
									<li>删除</li>
								</a>
								<!-- 此处要使用jstl进行字符串的反斜杠替换 -->
							 	<c:set var="vEnter" value="\\" scope="request"></c:set>
								<c:set var="vEnter2" value="_" scope="request"></c:set>
								<c:set var="filepath" value="${fn:replace(data.wenjian_lujing,vEnter,vEnter2)}"></c:set>  
								<a href="<%=UrlKit.getDomain(request)%>/downLoadFileCtrl/downLoadFile?filepath=${filepath}">
									<li>下载</li>
								</a>
								<a href="javascript:void(0)" style="border: none;">
									<li onclick="xianshi()">添加简介</li>
								</a>
							</ul>
						</td>
					</tr>
				</c:forEach>
				<!--end-->
			</table>
			<div class="shangchuanwenjin">
			<p class="lk-p" style="margin-left: 20px;text-align: left;margin-top: 15px;float: left;font-weight: normal;font-size: 13px;">上传文件
				<p style="color: red;text-align: left;margin-top: 15px;float: left;font-size: 13px;">*</p>
			</p>
			<!-- 提交文件 -->
			<form enctype="multipart/form-data" id="file_upload" method="post" action="<%=request.getContextPath()%>/uploadFileCtrl/upload">
				<input type="file" style="margin-top: 10px;margin-left: 10px;" name="file" id="file"/>
				<!-- 隐藏表单，用于完善案例文件的信息 -->
				<input type="hidden" name="fk_anli_id" id="upload_anliFolder" >
				<input type="hidden" name="fk_userid" id="upload_userFolder" value="${userMap['userid']} "> 
				<!-- 设定当前的案例id值 -->
				<input type="hidden" value="" id="fk_anli_id" name="fk_anli_id">
				<!-- 标定是否点击按钮之后进行跳转,默认是不进行跳转 -->
				<input id="isJump" type="hidden" value="0" name="isJump"> 
				
				<!-- 用于存放state -->
				<c:choose>
					<c:when test="${session_anli!=null}">
						<input type="hidden" id="anli_state" value="${session_anli.state}" name="state"/>
					</c:when>
					<c:otherwise>
						<input type="hidden" value="2" id="anli_state" name="state"/>
					</c:otherwise>
				</c:choose>
			</form>
			</div>
			<!--Button-->
			<div class="queding">
			<!-- 能够进入该页面说明可以不可能是不结案 -->
				<c:choose>
					<c:when test="${list!=null}">
						<c:choose>
							<c:when test="${session_anli!=null and session_anli.state!=2  }">
									<button id="update">保存</button>
							</c:when>
							<c:otherwise>
								<button id="update" type="button" style="position: relative;right:-2%;margin-bottom: 30px;">保存</button>
								<button id="updateAndStep" type="button" style="position: relative;right:-8%;margin-bottom: 30px;">分析诊断</button>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${session_anli!=null and session_anli.state>2}">
								<button id="update">保存</button>
							</c:when>
							<c:otherwise>
								<button id="save">保存</button>
								<button id="saveAndStep">分析诊断</button>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<!--右边提示部分-->
		<div class="youbian">
			<p class="tishi">!!提示</p>
		</div>
		<!--添加简介的浮层-->
		<div style="display: none;" id="fuc">
			<div style="position: absolute;top: 0;left: 40%;width: 400px;height: 100%;background: #FFFFFF;z-index: 50;">
				<p style="text-align: center;width: 100%;height: 30px;font-size: 16px;line-height:25px;margin-top: 10px;border-bottom: 1px solid #0099CC;">文件简介</p>
				<div style="width: 100%;font-size: 15px;padding: 30px 20%;"><span style="color: red;">文件名:</span><span>文件名</span></div>
				<div style="width: 60%;font-size: 15px;padding: 0px 20%;"><span style="color: red;">简介:</span><span>文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名文件名</span></div>
				<button style="margin: 20px 45%;width: 60px;height: 30px;line-height: 22px;color: #FFFFFF;background: #03537D;border-radius: 8px;border: 0;" onclick="xiaoshi()">提交</button>
			</div>
			<div style="position: absolute;top: 0;left: 0;width: 100%;height: 100%;background: #000000;opacity: 0.6;">
			</div>
		</div>
		<script src="<%=request.getContextPath()%>/js/soujiziliao.js"></script>
		<%
			if(session.getAttribute("list")!=null){
				//在填充完本页面数据之后session中的数据就无效了
				session.removeAttribute("list");
			}
		%>
	</body>
</html>