<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<script src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js" type="text/javascript" charset="utf-8"></script>
		<title></title>
	</head>
	<body>
		<div style="width: 550px;height: 30px;">
			<form method="post" style="margin:10px 0;">
				<label style="font-family: '微软雅黑';font-size: 13px;font-weight: bold;">日程标题:</label>
				<input type="text" style="width: 180px;" />
			</form>
			<form method="post">
				<label style="font-family: '微软雅黑';font-size: 13px;font-weight: bold;">起始日期:</label>
				<input class="Wdate" type="text" id="d15" onFocus="WdatePicker({isShowClear:false,readOnly:true})" style="width: 180px;" />
			</form>
			<form method="post" style="margin-top: 10px;">
				<label style="font-family: '微软雅黑';font-size: 13px;font-weight: bold;">结束日期:</label>
				<input class="Wdate" type="text" id="d16" onFocus="WdatePicker({isShowClear:false,readOnly:true})" style="width: 180px;" />
			</form>
			<form method="post" style="margin-top: 10px;">
				<label style="font-family: '微软雅黑';font-size: 13px;font-weight: bold;">开始时间:</label>
				<input type="text" id="d242" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm:ss'})" class="Wdate" style="width: 180px;" />
			</form>
			<form method="post" style="margin-top: 10px;">
				<label style="font-family: '微软雅黑';font-size: 13px;font-weight: bold;">结束时间:</label>
				<input type="text" id="d242" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm:ss'})" class="Wdate" style="width: 180px;" />
			</form>
			<form method="post" style="margin-top: 10px;">
				<label style="font-family: '微软雅黑';font-size: 13px;font-weight: bold;">选择星期:</label>
				<select style="width: 180px;">
					<option value="星期一">星期一</option>
					<option value="星期二">星期二</option>
					<option value="星期三">星期三</option>
					<option value="星期四">星期四</option>
					<option value="星期五">星期五</option>
					<option value="星期六">星期六</option>
					<option value="星期日">星期日</option>
				</select>
			</form>
		</div>
	</body>

</html>