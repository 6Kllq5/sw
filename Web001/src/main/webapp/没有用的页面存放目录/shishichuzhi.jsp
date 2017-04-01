<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/reset.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/zhidingjihua.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/anlibianxie.css" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/kindeditor-v4.1.7/kindeditor-4.1.7/themes/default/default.css" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/kindeditor-v4.1.7/kindeditor-4.1.7/plugins/code/prettify.css" />
		<script charset="utf-8" src="<%=request.getContextPath() %>/kindeditor-v4.1.7/kindeditor-4.1.7/kindeditor.js"></script>
		<script charset="utf-8" src="<%=request.getContextPath() %>/My97DatePicker/lang/zh-cn.js"></script>
		<script charset="utf-8" src="<%=request.getContextPath() %>/kindeditor-v4.1.7/kindeditor-4.1.7/plugins/code/prettify.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js" ></script>
		<script>
			KindEditor.ready(function(K) {
				var editor1 = K.create('textarea[name="content1"]', {
					cssPath: "<%=request.getContextPath() %>/kindeditor-v4.1.7/kindeditor-4.1.7/plugins/code/prettify.css",
					resizeType:0,
					//				uploadJson : '../jsp/upload_json.jsp',
					//				fileManagerJson : '../jsp/file_manager_json.jsp',
					allowFileManager: true,
					afterCreate: function() {
						var self = this;
						K.ctrl(document, 13, function() {
							self.sync();
							document.forms['example'].submit();
						});
						K.ctrl(self.edit.doc, 13, function() {
							self.sync();
							document.forms['example'].submit();
						});
					}
				});
				prettyPrint();
			});
		</script>
		<title>制定计划</title>
	</head>

	<body>
		<div class="zhidingjihua">
			<p class="huanyingyu">Hi,<b style="color: red;">admin</b>!</p>
			<!--1-->
			<div style="margin: 0 0 10px 0; ">

				<div class="xia">
					<p class="bba1">诊断时间
						<p style="color: red;float: left;line-height: 23px;">*</p>
					</p>
				</div>
				<c:choose>
					<c:when test="${chuzhi!=null}">
						<input type="text" style="float: left;" class="shuru" value="${chuzhi.zhengduan_shijian }"/>
					</c:when>
					<c:otherwise>
						<input type="text" style="float: left;" class="shuru" />
					</c:otherwise>
				</c:choose>
				
			</div>

			<div class="xia" style="clear: both;">
				<p class="bba1">执行情况描述
					<p style="color: red;float: left;line-height: 23px;">*</p>
				</p>
			</div>
			<!--kindEdit-->
			<form name="example" method="post" style="margin-top: 20px;">
				<c:choose>
					<c:when test="${chuzhi!=null }">
						<textarea name="content1" cols="100" rows="8" style="width:97%;height:250px;resize:none;position: relative;top: 15px;">${chuzhi.zhixing_miaoshu}</textarea>
					</c:when>
					<c:otherwise>
						<textarea name="content1" cols="100" rows="8" style="width:97%;height:250px;resize:none;position: relative;top: 15px;"></textarea>
					</c:otherwise>
				</c:choose>
				
			</form>
			<div class="xia" style="clear: both;">
				<p class="bba1">备注
					<p style="color: red;float: left;line-height: 23px;">*</p>
				</p>
			</div>
			<div style="clear: both;">
				<c:choose>
					<c:when test="${chuzhi!=null }">
						<textarea id="bz" style="width: 97%;height: 200px;border:1px solid #C3C3C3 ;resize:none;">${chuzhi.beizhu}</textarea>
					</c:when>
					<c:otherwise>
						<textarea id="bz" style="width: 97%;height: 200px;border:1px solid #C3C3C3 ;resize:none;"></textarea>
					</c:otherwise>
				</c:choose>
				
			</div>
			<div class="aiya">
				<c:choose>
					<c:when test="${ chuzhi!=null}">
						<c:choose>
							<c:when test="${session_anli!=null and  session_anli.state!=5}">
								<button id="update" type="button" style="position: relative;right:-2%;margin-bottom: 30px;">保存</button>
							</c:when>
							<c:otherwise>
								<button id="update" type="button" style="position: relative;right:-2%;margin-bottom: 30px;">保存</button>
								<button id="updateAndStep" type="button" style="position: relative;right:-8%;margin-bottom: 30px;">结案评估</button>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<button id="save" type="button" style="position: relative;right:-2%;margin-bottom: 30px;">保存</button>
						<button id="saveAndStep" type="button" style="position: relative;right:-8%;margin-bottom: 30px;">结案评估</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<!-- 隐藏表单用于提交数据 -->
		<form id="shishiForm">
			<!-- 诊断时间 -->
			<input type="hidden" name="zhengduan_shijian" id="zhengduan_shijian">
			
			<!-- 执行描述情况 -->
			<input type="hidden" name="zhixing_miaoshu" id="zhixing_miaoshu"/>
			
			<!-- 备注 -->
			<input type="hidden" id="beizhu" name="beizhu"/>
			
			<!--用于存放两个外键  -->
			<input type="hidden" name="fk_userid" value="${userMap['userid']} "/>
			<input type="hidden" id="fk_anli_id" name="fk_anli_id"/>
			
			<!-- 用于标示是否在点击保存并且下一步的时候已经点击了保存 ,默认是没有点击-->
			<input type="hidden" id="markClickSaveBtn" value="0" />
			
				<!-- 用于存放state -->
			<c:choose>
				<c:when test="${session_anli!=null }">
					<input type="hidden" id="anli_state" value="${sesssion_anli.state}" name="state"/>
				</c:when>
				<c:otherwise>
					<input type="hidden" id="anli_state" value="5" name="state"/>
				</c:otherwise>
			</c:choose>
			
		</form>
		
		<!--右边提示部分-->
		<div class="youbian">
			<p class="tishi">!!提示</p>
		</div>
		
		<script src="<%=request.getContextPath() %>/js/shishichuzhi.js"></script>
	
		<%
		//清空session中的数据
			if(session.getAttribute("chuzhi")!=null){
				session.removeAttribute("chuzhi");
			}
		%>
		
	</body>
</html>