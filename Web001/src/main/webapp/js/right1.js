//初始化event事件
function initEvent(){
	$('#calendar').fullCalendar({
		theme: true,
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month'
		},
		defaultDate: '2016-09-12',
		selectable: true,
		selectHelper: true,
		//单击某一天--页面展示没有操作
		select: function(start, end) {
			
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
		events: function(start,end,timezone,callback) {
			var fk_userid="";
			if(getCookie("role")==0){
				fk_userid=getCookie("userid");
			}else{
				fk_userid=null;
			}
	        $.ajax({
	        	url:"DateEventCtrl/dateEventCtrl",
	            dataType: 'json',
	            type:"post",
	            data:{
	            	"fk_userid":fk_userid,
	            	"method":"selectAll"
	            },
	            success: function(result) { // 获取当前月的数据
            	 	var events = [];
					for (i = 0;i<result.length;i++){
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
							w1=weekArray[w1];
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
		}
	});
	$('#calendar').find('.fc-prev-button,.ui-button,.ui-state-default,.ui-corner-left').click(function(){alert($(this).hasClass('fc-button-prev')?'prev':'next')});
}
$(document).ready(function(){
	initEvent();
});