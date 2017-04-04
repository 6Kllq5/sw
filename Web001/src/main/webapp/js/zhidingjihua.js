//获取绝对上下文路径
function getRealPath(){
	var curWwwPath=window.document.location.href;
	var pathName=window.document.location.pathname;
	var pos=curWwwPath.indexOf(pathName);
	var localhostPaht=curWwwPath.substring(0,pos);
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	var realPath=localhostPaht+projectName;
	return realPath;
}



//页面加载的时候进行的数据处理
$(document).ready(function (){
	//查询数据填充页面
	$.ajax({
		type:"post",
		url:"JiHuaCtrl/jiHuaCtrl",
		data:{
			"method":"select",
		},
		async:false,
		dataType:"json",
		success:function (result){
			var data=result.data;
			if(data!=null){
				//填充页面数据
				
				
				
				//缓存cookie --- id 值以后点击就是修改操作
				SetCookie("jihua_id",result.jihua_id);
			}
		},
		error:function(){
			window.location.href="error.html";
		}
	});
	
	//初始化插件
	KindEditor.ready(function(K) {
		
		
		var editor1 = K.create('textarea[name="content1"]', {
			cssPath: 'kindeditor-v4.1.7/kindeditor-4.1.7/plugins/code/prettify.css',
			resizeType:0,
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
	});
	
	
	
	//初始化日历控件
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
			var startDay=moment(event.start).format('YYYY-MM-DD');
			var endDay = moment(event.end).format('YYYY-MM-DD');
			
			var startTime= moment(event.start).format('HH:mm:ss');
			var endTime= moment(event.end).format('HH:mm:ss');
			
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
	        	url:"DateEventCtrl/dateEventCtrl",
	            dataType: 'json',
	            data:{
	            	"fk_userid":getCookie("userid"),
	            	"method":"selectAll"
	            },
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
							//w1=weekArray[w1];
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
								});
							}
							uom = new Date(uom - 0 + 1 * 86400000);
						}
					}
					callback(events);
	            }
	        });
		},
	});
	
	$("#fk_userid").val(getCookie("userid"));
	$("#fk_anli_id").val(getCookie("anli_id"));
});


//定义ajax 
var option={
	url:"JiHuaCtrl/jiHuaCtrl",
	type:"post",
	dataType:"json",
	data:$("#paraForm").serialize(),
	async:false,
	success:function (){},
    error: function(XMLHttpRequest, textStatus, errorThrown) {
        alert(XMLHttpRequest.status);
        alert(XMLHttpRequest.readyState);
        alert(textStatus);
    }
};

//填提交表单必要的参数
function insertParaForm(){
	
	
}



function add(){
	insertParaForm();
	option.data=$("#paraForm").serialize();
}

function update(){
	$("#method").val("update");
	insertParaForm();
	option.data=$("#paraForm").serialize();
}


//点击提交
$("#save").click(function (){
	option.success=function(result){
		alert(result.message);
		SetCookie("jihua_id",result.jihua_id);
	};
	alert(getCookie("jihua_id"));
	if(getCookie("jihua_id")!=null){
		update();
	}else{
		add();
	}
	$.ajax(option);
});

$("#saveAndStep").click(function (){
	option.success=function(result){
		alert(result.message);
		window.location.href="shishichuzhi.html";
	};
	if(getCookie("jihua_id")!=null){
		update();
	}else{
		add();
	}
	window.location.href="shishichuzhi.html";
	$.ajax(option);
});

//监听页面离开时间
$(window).bind('beforeunload',function(){ 
	delCookie("jihua_id");
});


