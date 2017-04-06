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

//定义ajax提交option
var option={
	url:"JiHuaCtrl/jiHuaCtrl",
	type:"post",
	data:$("#paraForm").serialize(),
	async:false,
	success:function (){
	},
	error:function (){
		window.location.href="error.html";
	}
};


$(document).ready(function(){
	//填充必须的数据
	$("#fk_userid").val(getCookie("userid"));
	$("#fk_anli_id").val(getCookie("anli_id"));
	
	$.ajax({
		type:"get",
		url:"JiHuaCtrl/jiHuaCtrl",
		data:{
			"method":"select",
			"fk_userid":getCookie("userid"),
			"fk_anli_id":getCookie("anli_id")
		},
		async:false,
		success:function (result){
			var data = result.data;
			if(data==null){
				return;
			}
			alert("gg")
			//添加  页面  数据
			if(data.daoda_mubiao!=''&&data.daoda_mubiao!=null){
				$(".zuo1").eq(0).find("input").eq(1).attr("checked","checked");
				$("#mb_content").val(data.daoda_mubiao);
			}
			if(data.fangshi_dedang!=''&&data.fangshi_dedang!=null){
				$(".zuo1").eq(1).find("input").eq(1).attr("checked","checked");
				$("#gzfs_content").val(data.daoda_mubiao);
			}
			$("input[name='pddj']").eq(+data.pingding_dengji).attr("selected","selected");
			$("input[name='gjfw']").eq(+data.gengjing_fuwu).attr("selected","selected");
			$("#cxjl").val(data.chengxiao_jielun);
			//缓存  标示
			SetCookie("pinggu_id", data.pinggu_id);
		},
		error:function(){
			window.location.href="error.html";
		}
	});
});

//添加
function add(){
	insertForm();
	option.success=function(result){
		alert(result.message);
		window.location.href="right2.html";
	};
	option.data=$("#paraForm").serialize();
}

//修改
function update(){
	$("#method").val("update");//修改方法
	insertForm();
	$("#pinggu_id").val(getCookie("pinggu_id"));
	option.data=$("#paraForm").serialize();
	option.success=function(result){
		alert(result.message);
	};
}

//填充数据
function insertForm(){
	$("#daoda_mubiao").val($("#mb_content").val());//达到目标
	$("#fangshi_dedang").val($("#gzfs_content").val());//工作方式
	$("#pingding_dengji").val($("input[name='pddj']:checked").val());
	$("#gengjing_fuwu").val($("input[name='gjfw']:checked").val());
	$("#chengxiao_jielun").val($("#cxjl").val());
}

//点击保存并且跳转
$("#save").click(function(){
	if(getCookie("pinggu_id")!=null){
		//执行修改操作
		update();
	}else{
		//执行添加操作
		add();
	}
	$.ajax(option);
});

//监听页面离开时间
$(window).bind('beforeunload',function(){ 
	delCookie("pinggu_id");
});


/**************************以下使用js实现动态页面效果*****************************/
//达到目标效果
$(".zuo1").eq(0).find("input[name='ddmb']").eq(1).change(function (){
	if($(this).checked){
		$("#mb_content").css("display","block");
	}else{
		$("#mb_content").css("display","none");
	}
});
//工作方式是否得当
$(".zuo1").eq(1).find("input[name='gzfs']").eq(1).change(function (){
	if($(this).checked){
		$("#gzfs_content").css("display","block");
	}else{
		$("#gzfs_content").css("display","none");
	}
});





