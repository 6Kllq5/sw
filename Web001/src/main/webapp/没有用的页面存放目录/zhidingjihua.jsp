<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/reset.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/zhidingjihua.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/anlibianxie.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/right1.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/kindeditor-v4.1.7/kindeditor-4.1.7/themes/default/default.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/kindeditor-v4.1.7/kindeditor-4.1.7/plugins/code/prettify.css" />


<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/right1.css" />
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/fullcalendar-3.0.1/lib/cupertino/jquery-ui.min.css' />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/jquery-confirm-v3.0.1/jquery-confirm-master/dist/jquery-confirm.min.css" />
<link
	href='<%=request.getContextPath()%>/fullcalendar-3.0.1/fullcalendar.css'
	rel='stylesheet' />
<link
	href='<%=request.getContextPath()%>/fullcalendar-3.0.1/fullcalendar.print.css'
	rel='stylesheet' media='print' />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
<script
	src='<%=request.getContextPath()%>/fullcalendar-3.0.1/lib/moment.min.js'></script>
<script
	src="<%=request.getContextPath()%>/js/jquery-confirm-v3.0.1/jquery-confirm-master/dist/jquery-confirm.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src='<%=request.getContextPath()%>/fullcalendar-3.0.1/fullcalendar.min.js'></script>
<script charset="utf-8"
	src="<%=request.getContextPath()%>/kindeditor-v4.1.7/kindeditor-4.1.7/kindeditor.js"></script>
<script>
	$(document).ready(function() {
		$('#calendar').fullCalendar({
			theme: true,
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month'
			},
			defaultDate: '2016-09-12',
			//navLinks: true, // can click day/week names to navigate views
			selectable: true,
			selectHelper: true,
			//单击某一天
			select: function(start, end) {
				document.getElementById("shishi").style.display = "block";
				document.getElementById("shishi").style.position = "absolute";
				document.getElementById("shishi").style.right = "0";
				document.getElementById("shishi").style.height = "1600px";
				document.getElementById("shishi").style.top = "0";
				document.getElementById("shishi").style.zIndex = "50";
				document.getElementById("middle").style.zIndex = "100";
				document.getElementById("middle").style.position = "absolute";
				document.getElementById("middle").style.top = "120px";
				document.getElementById("middle").style.right = "35%";
				document.getElementById("middle").style.border = "2px";
				document.getElementById("middle").style.borderColor = "#000000";
				document.getElementById("middle").style.borderRadius = "20px";
				document.getElementById("middle").style.height = "260px";
				document.getElementById("middle").style.width = "350px";
				document.getElementById("middle").style.display = "block";
				//全天为不可选择状态
				$("input[type='checkbox']").eq(0).attr("checked","checked");
				//清空之前的数据
				$('#rcTitle').val("");
				$("#startDay").val("");
				$("#endDay").val("");
				$("#week").val("");
				$("#startTime").val("");
				$("#endTime").val("");
				if($("input[type='checkbox']").eq(0).is(':checked')) {
					document.getElementById("shijian").style.display = "none";
					document.getElementById("middle").style.height = "260px";
					//重置时间段
					$("#startTime").val("00:00:00");
					$("#endTime").val("23:59:59");
				} else {
					document.getElementById("shijian").style.display = "block";
					document.getElementById("middle").style.height = "260px";
				}
			},
			eventClick: function(event, jsEvent, view) {
			
				if($("input[type='checkbox']").eq(1).is(':checked')) {
					document.getElementById("shijian1").style.display = "block";
					document.getElementById("middle1").style.height = "330px";
				}else {
					document.getElementById("shijian1").style.display = "block";
					document.getElementById("middle1").style.height = "330px";
				}
				var startDay=moment(event.start).format('YYYY-MM-DD')
				var endDay = moment(event.end).format('YYYY-MM-DD')
				
				var startTime= moment(event.start).format('HH:mm:ss')
				var endTime= moment(event.end).format('HH:mm:ss')
				
				$('#rcTitle1').val(event.title);
		
				$("#startDay1").val(startDay);
				
				$("#endDay1").val(endDay);
				
				$("#week").val(getWeek((new Date(startDay)).getDay()));
				
				document.getElementById("shishi").style.display = "block";
				document.getElementById("shishi").style.position = "absolute";
				document.getElementById("shishi").style.right = "0";
				document.getElementById("shishi").style.top = "0";
				document.getElementById("shishi").style.zIndex = "50";
				document.getElementById("middle1").style.zIndex = "100";
				document.getElementById("middle1").style.position = "absolute";
				document.getElementById("middle1").style.top = "80px";
				document.getElementById("middle1").style.right = "30%";
				document.getElementById("middle1").style.border = "2px";
				document.getElementById("middle1").style.borderColor = "#000000";
				document.getElementById("middle1").style.borderRadius = "20px";
				document.getElementById("middle1").style.height = "260px";
				document.getElementById("middle1").style.width = "350px";
				document.getElementById("middle1").style.display = "block";
			},
			events: function(start,end,timezone, callback) {
		        $.ajax({
		        	url:getRealPath()+"/getAllEventCtrl/getAllEvent",
		            dataType: 'json',
		            data:{"fk_userid":"${userMap['userid']}"},
		            success: function(result) { // 获取当前月的数据
		            	var events = [];
						for (i=0;i<result.length;i++){
							var s_date_str =result[i].shijian_sdate;
							var e_date_str=result[i].shijian_edate;
							//得到中国时间标准
							var s_date = eval('new Date(' + s_date_str.replace(/\d+(?=-[^-]+$)/, 
				            		   function (a) { return parseInt(a, 10) - 1; }).match(/\d+/g) + ')');
							var e_date = eval('new Date(' + e_date_str.replace(/\d+(?=-[^-]+$)/, 
				            		   function (a) { return parseInt(a, 10) - 1; }).match(/\d+/g) + ')'); 
							var uom=s_date;
							var week = result[i].shijian_xinqi;
							var weekArray = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
							var s_time= result[i].shijian_stime.trim();
							var e_time= result[i].shijian_etime.trim();
							while (uom <= e_date) {
								var w1 = getWeek(uom.getDay());
								if (w1 == week) {
									var year = uom.getFullYear();
									var month = parseInt(uom.getMonth()) + 1;
									var day = uom.getDate();
									events.push({
										title :  result[i].shijian_biaoti,
										start : moment(year + "-" + month + "-" + day
												+ " " + s_time,
												"YYYY-MM-DD HH:mm:ss"),
										end : moment(year + "-" + month + "-" + day
												+ " " + e_time, "YYYY-MM-DD HH:mm:ss")
									})
								}
								uom = new Date(uom - 0 + 1 * 86400000);
							}
						}
						callback(events);
		            }
		        });
			},
		});
	});
</script>
<script>
KindEditor.ready(function(K) {
	var editor1 = K.create('textarea[name="content1"]', {
		cssPath: "<%=request.getContextPath()%>/kindeditor-v4.1.7/kindeditor-4.1.7/plugins/code/prettify.css",
		resizeType : 0,
			//				uploadJson : '../jsp/upload_json.jsp',
			//				fileManagerJson : '../jsp/file_manager_json.jsp',
		allowFileManager : true,
		afterCreate : function() {
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
	$('#calendar').fullCalendar({
		theme : true,
		header : {
			left : 'prev,next today',
			center : 'title',
			right : 'month'
		},
		defaultDate : '2016-09-12',
		//navLinks: true, // can click day/week names to navigate views
		selectable : true,
		selectHelper : true,
		//单击某一天
		select : function(start, end) {

		},
		eventClick : function(event, jsEvent, view) {

		},
		events : [],
	});
});
</script>

<script>
	
</script>
<title>制定计划</title>
</head>

<body>
	<form id="zhidingihuaForm" method="post">
		<div class="zhidingjihua">
			<p class="huanyingyu">
				Hi,<b style="color: red;">admin</b>,欢迎进行制定计划
			</p>
			<!--1-->
			<div style="margin: 0 0 10px 0;">
				<div class="xia">
					<p class="bba1">计划模型
					<p style="color: red; float: left; line-height: 23px;">*</p>
					</p>
				</div>
				<c:choose>
					<c:when test="${jihua!=null}">
						<input type="text" style="float: left;" class="shuru"
							value="${jihua.jihua_moxing }" />
					</c:when>
					<c:otherwise>
						<input type="text" style="float: left;" class="shuru" />
					</c:otherwise>
				</c:choose>
			</div>
			<!--2-->
			<div class="xia" style="clear: both;">
				<p class="bba1">计划时间
				<p style="color: red; float: left; line-height: 23px;">*</p>
				</p>

			</div>
			<c:choose>
				<c:when test="${jihua!=null }">
					<input type="text" style="float: left;" class="shuru"
						value="${jihua.jihua_shijian }" />
				</c:when>
				<c:otherwise>
					<input type="text" style="float: left;" class="shuru" />
				</c:otherwise>
			</c:choose>
			<div class="xia" style="clear: both;">
				<div id="calendar"></div>
				</di>
				<div class="xia" style="clear: both;">
					<p class="bba1">计划内容
					<p style="color: red; float: left; line-height: 23px;">*</p>
					</p>
				</div>
				<!--kindEdit-->
				<form name="example" method="post" style="margin-top: 20px;">
					<c:choose>
						<c:when test="${jihua!=null }">
							<textarea name="content1" cols="100" rows="10"
								style="width: 97%; height: 250px; visibility: hidden;">${jihua.jihua_neirong}</textarea>
						</c:when>
						<c:otherwise>
							<textarea name="content1" cols="100" rows="10"
								style="width: 97%; height: 250px; visibility: hidden;"></textarea>
						</c:otherwise>
					</c:choose>
				</form>

				<div class="xia" style="clear: both;">
					<p class="bba1">备注
					<p style="color: red; float: left; line-height: 23px;">*</p>
					</p>
				</div>

				<div style="clear: both;">
					<c:choose>
						<c:when test="${jihua!=null}">
							<textarea id="beizhu"
								style="width: 97%; height: 200px; border: 1px solid #C3C3C3; resize: none;">${jihua.jihua_beizhu}</textarea>
						</c:when>
						<c:otherwise>
							<textarea id="beizhu"
								style="width: 97%; height: 200px; border: 1px solid #C3C3C3; resize: none;"></textarea>
						</c:otherwise>
					</c:choose>

				</div>
				<div class="aiya1">
					<c:choose>
						<c:when test="${jihua!=null }">
							<c:choose>
								<c:when test="${session_anli.state!=4}">
									<button type="button" id="update"
										style="position: relative; right: -2%; margin-bottom: 30px;">保存</button>
								</c:when>
								<c:otherwise>
									<button type="button" id="update"
										style="position: relative; right: -2%; margin-bottom: 30px;">保存</button>
									<button type="button" id="updateAndStep"
										style="position: relative; right: -8%; margin-bottom: 30px;">实施处置</button>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<button type="button" id="save"
								style="position: relative; right: -2%; margin-bottom: 30px;">保存</button>
							<button type="button" id="saveAndStep"
								style="position: relative; right: -8%; margin-bottom: 30px;">实施处置</button>
						</c:otherwise>
					</c:choose>

				</div>
			</div>

		</div>

		<!--右边提示部分-->
		<div class="youbian">
			<p class="tishi">!!提示</p>
		</div>
	</form>

	<!-- 用于提交的隐藏表单 -->
	<form id="jihuaForm">
		<!-- 计划模型存放的值 -->
		<input type="hidden" id="jihua_moxing" name="jihua_moxing" value="" />

		<!-- 用于存放计划时间 -->
		<input type="hidden" id="jihua_shijian" name="jihua_shijian" value="" />

		<!-- 用于存放富文本编辑器中的内容 -->
		<input type="hidden" id="jihua_neirong" name="jihua_neirong" value="" />

		<!-- 用于存放备注内容 -->
		<input type="hidden" id="jihua_beizhu" name="jihua_beizhu" value="" />

		<!--用于存放两个外键  -->
		<input type="hidden" name="fk_userid" value="${userMap['userid']} " />
		<input type="hidden" id="fk_anli_id" name="fk_anli_id" />

		<c:if test="${session_anli!=null}">
			<input type="hidden" value="${session_anli.anli_id}" name="anli_id" />
		</c:if>
		<!-- 用于标示是否在点击保存并且下一步的时候已经点击了保存 ,默认是没有点击-->
		<input type="hidden" id="markClickSaveBtn" value="0" />

		<!-- 用于存放state -->
		<c:choose>
			<c:when test="${session_anli!=null}">
				<input type="hidden" id="anli_state" value="${sesssion_anli.state}"
					name="state" />
			</c:when>
			<c:otherwise>
				<input type="hidden" id="anli_state" value="4" name="state" />
			</c:otherwise>
		</c:choose>

	</form>

	<div
		style="width: 100%; height: 100%; display: none; background: #C3C3C3; opacity: 0.5;"
		id="shishi"></div>
	<div
		style="width: 500px; height: 800px; background: #FFFFFF; display: none;"
		id="middle">
		<p style="font-family: '微软雅黑'; margin: 15px 140px; font-weight: bold;">添加日程</p>
		<form method="post" style="margin: 10px 50px;">
			<label style="font-family: '微软雅黑'; font-size: 13px;">日程标题:</label> <input
				type="text" style="width: 180px;" id="rcTitle" />
		</form>
		<form method="post" style="margin: 10px 50px;">
			<label style="font-family: '微软雅黑'; font-size: 13px;">选择星期:</label> <select
				style="width: 180px;" id="week">

				<option value="星期一">星期一</option>
				<option value="星期二">星期二</option>
				<option value="星期三">星期三</option>
				<option value="星期四">星期四</option>
				<option value="星期五">星期五</option>
				<option value="星期六">星期六</option>
				<option value="星期日">星期日</option>

			</select>
		</form>
		<form method="post" style="margin: 10px 50px;">
			<label style="font-family: '微软雅黑'; font-size: 13px;">起始日期:</label> <input
				class="Wdate" type="text"
				onFocus="WdatePicker({isShowClear:false,readOnly:true})"
				style="width: 180px;" id="startDay" />
		</form>
		<form method="post" style="margin: 10px 50px;">
			<label style="font-family: '微软雅黑'; font-size: 13px;">结束日期:</label> <input
				class="Wdate" type="text"
				onFocus="WdatePicker({isShowClear:false,readOnly:true})"
				style="width: 180px;" id="endDay" />
		</form>
		<div style="display: none;" id="shijian">
			<form method="post" style="margin: 10px 50px;">
				<label style="font-family: '微软雅黑'; font-size: 13px;">开始时间:</label> <input
					type="text"
					onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm:ss'})"
					class="Wdate" style="width: 180px;" id="startTime" />
			</form>
			<form method="post" style="margin: 10px 50px;">
				<label style="font-family: '微软雅黑'; font-size: 13px;">结束时间:</label> <input
					type="text"
					onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm:ss'})"
					class="Wdate" style="width: 180px;" id="endTime" />
			</form>
		</div>
		<form method="post" style="margin: 10px 50px;">
			<input type="checkbox" checked="checked" id="quantian" /> <label
				style="font-family: '微软雅黑'; font-size: 13px;">全天</label>
		</form>

		<div style="width: 100%; margin: 20px 100px;">
			<a href="javascript:void(0)"><button
					style="float: left; background: #c2e1ef; border: 1px solid #0000FF; border-radius: 3px;"
					id="okButton">确定</button></a> <a href="javascript:void(0)"><button
					style="float: left; margin-left: 30px; background: #c2e1ef; border: 1px solid #0000FF; border-radius: 3px;"
					id="cancleButton">取消</button></a>
		</div>
	</div>
	<div
		style="width: 500px; height: 800px; background: #FFFFFF; display: none;"
		id="middle1">
		<p style="font-family: '微软雅黑'; margin: 15px 140px; font-weight: bold;">修改日程</p>
		<form method="post" style="margin: 10px 50px;">
			<label style="font-family: '微软雅黑'; font-size: 13px;">日程标题:</label> <input
				type="text" style="width: 180px;" id="rcTitle1" />
		</form>
		<form method="post" style="margin: 10px 50px;">
			<label style="font-family: '微软雅黑'; font-size: 13px;">选择星期:</label> <select
				style="width: 180px;" id="week1">
				<option value="星期一">星期一</option>
				<option value="星期二">星期二</option>
				<option value="星期三">星期三</option>
				<option value="星期四">星期四</option>
				<option value="星期五">星期五</option>
				<option value="星期六">星期六</option>
				<option value="星期日">星期日</option>
			</select>
		</form>
		<form method="post" style="margin: 10px 50px;">
			<label style="font-family: '微软雅黑'; font-size: 13px;">起始日期:</label> <input
				class="Wdate" type="text"
				onFocus="WdatePicker({isShowClear:false,readOnly:true})"
				style="width: 180px;" id="startDay1" />
		</form>
		<form method="post" style="margin: 10px 50px;">
			<label style="font-family: '微软雅黑'; font-size: 13px;">结束日期:</label> <input
				class="Wdate" type="text"
				onFocus="WdatePicker({isShowClear:false,readOnly:true})"
				style="width: 180px;" id="endDay1" />
		</form>
		<div style="display: none;" id="shijian1">

			<form method="post" style="margin: 10px 50px;">
				<label style="font-family: '微软雅黑'; font-size: 13px;">开始时间:</label> <input
					type="text" id="d242"
					onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm:ss'})"
					class="Wdate" style="width: 180px;" id="startTime1" />
			</form>
			<form method="post" style="margin: 10px 50px;">
				<label style="font-family: '微软雅黑'; font-size: 13px;">结束时间:</label> <input
					type="text" id="d242"
					onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm:ss'})"
					class="Wdate" style="width: 180px;" id="endTime1" />
			</form>
		</div>
		<form method="post" style="margin: 10px 50px;">
			<input type="checkbox" checked="checked" id="quantian1" /> <label
				style="font-family: '微软雅黑'; font-size: 13px;">全天</label>
		</form>
		<div style="width: 100%; margin: 20px 50px;">
			<a href="javascript:void(0)"><button
					style="float: left; background: #c2e1ef; border: 1px solid #0000FF; border-radius: 3px;"
					id="deleteBtn">删除</button></a> <a href="javascript:void(0)"><button
					style="float: left; background: #c2e1ef; border: 1px solid #0000FF; border-radius: 3px; margin-left: 80px;"
					id="okBtn1">确定</button></a> <a href="javascript:void(0)"><button
					style="float: left; margin-left: 15px; background: #c2e1ef; border: 1px solid #0000FF; border-radius: 3px;"
					id="cancleBtn1">取消</button></a>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/js/addEvent.js"></script>
	<script src="<%=request.getContextPath() %>//js/zhidingjihua.js"></script>
	<%
			//清空数据
			if(session.getAttribute("jihua")!=null){
				session.removeAttribute("jihua");
			}
		%>
</body>
</html>