//获取绝对上下文路径
function getRealPath(){
   	var curWwwPath=window.document.location.href;
   	//获取主机地址之后的目录，如： myproj/view/my.jsp
  	var pathName=window.document.location.pathname;
  	var pos=curWwwPath.indexOf(pathName);
  	//获取主机地址，如： http://localhost:8083
 	var localhostPaht=curWwwPath.substring(0,pos);
  	//获取带"/"的项目名，如：/myproj
  	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
 	//得到了 http://localhost:8083/myproj
 	var realPath=localhostPaht+projectName;
	return realPath;
}

$("#quantian").change(function() {
	if ($("input[type='checkbox']").eq(0).is(':checked')) {
		document.getElementById("shijian").style.display = "none";
		document.getElementById("middle").style.height = "260px";
		$("#startTime").val("00:00:00");
		$("#endTime").val("23:59:59");
	} else {
		document.getElementById("shijian").style.display = "block";
		document.getElementById("middle").style.height = "330px";
		$("#startTime").val("");
		$("#endTime").val("");
	}
});

$("#quantian1").change(function() {
	if ($("input[type='checkbox']").eq(1).is(':checked')) {
		document.getElementById("shijian1").style.display = "none";
		document.getElementById("middle1").style.height = "260px";
	} else {
		document.getElementById("shijian1").style.display = "block";
		document.getElementById("middle1").style.height = "330px";
	}
});

// 添加层点击确定按钮
$("#okButton").click(function() {
	var title = $('#rcTitle').val();
	var startDay = new Date($("#startDay").val());
	var endDay = new Date($("#endDay").val());
	var week = $("#week").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var anli_id=sessionStorage.getItem("anli_id");
	/*while (uom <= endDay) {
		var w1 = getWeek(uom.getDay());
		if (w1 == week) {
			var year = uom.getFullYear();
			var month = parseInt(uom.getMonth()) + 1;
			var day = uom.getDate();
			var eventData = {
				title : title,
				start : moment(year + "-" + month + "-" + day
						+ " " + startTime,
						"YYYY-MM-DD HH:mm:ss"),
				end : moment(year + "-" + month + "-" + day
						+ " " + endTime, "YYYY-MM-DD HH:mm:ss")
			};
			$('#calendar').fullCalendar('renderEvent',
					eventData, true);
			$('#calendar').fullCalendar('unselect');
		}
		uom = showdate(uom, 1);
	}*/
	document.getElementById("middle").style.display = "none";
	document.getElementById("shishi").style.display = "none";
	//添加事件使用ajax添加
	var shijian_sdate=formatDate(startDay);
	var shijian_edate=formatDate(endDay);
	var option={
		url:getRealPath()+"/addEventCtrl/addEvent",
		type:"post",
		data:{
			"shijian_biaoti":title,
			"shijian_xinqi":week,
			"shijian_sdate":shijian_sdate,
			"shijian_edate":shijian_edate,
			"shijian_stime":startTime,
			"shijian_etime":endTime,
			"anli_id":anli_id
		},
		dataType:"json",
		success:function(result){
			alert("添加成功");
			//成功之后消息所有的填写表单
		},
	   error: function(XMLHttpRequest, textStatus, errorThrown) {
           alert(XMLHttpRequest.status);
           alert(XMLHttpRequest.readyState);
           alert(textStatus);
       },
	};
	$.ajax(option);
});


// 点击取消按钮
$("#cancleButton").click(function() {
	document.getElementById("middle").style.display = "none";
	document.getElementById("shishi").style.display = "none";
});


// 从日期获取星期几
function getWeek(date) {
	var weekArray = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
	var week = weekArray[date];// 老师这个就是你想要的结果吧
	return week;
}
// 日期的增加
function showdate(date, n) {
	var uom = new Date(date - 0 + n * 86400000);
	return uom;
}
$("#deleteBtn").click(function() {
	document.getElementById("middle1").style.display = "none";
	document.getElementById("shishi").style.display = "none";
})
$("#okBtn1").click(function() {
	document.getElementById("middle1").style.display = "none";
	document.getElementById("shishi").style.display = "none";
})
$("#cancleBtn1").click(function() {
	document.getElementById("middle1").style.display = "none";
	document.getElementById("shishi").style.display = "none";
});

//将中国标准时间装换成标准时间格式
function formatTen(num) { 
	return num > 9 ? (num + "") : ("0" + num); 
}

function formatDate(date) { 
	var year = date.getFullYear(); 
	var month = date.getMonth() + 1; 
	var day = date.getDate(); 
	var hour = date.getHours(); 
	var minute = date.getMinutes(); 
	var second = date.getSeconds(); 
	return year + "-" + formatTen(month) + "-" + formatTen(day); 
} 


