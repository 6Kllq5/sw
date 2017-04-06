/***********************************d定义的全局变量********************************************/
//ajax option
var option = {
	url:"AnLiCtrl/anLiCtrl",
 	type:"post",
 	data:$("#paraForm").serialize(),
 	dataType:"json",
 	async:false,
 	success:function (){},
 	error:function (){
 		window.location.href="error.html";
 	}
};

/*********************************页面加载*********************************************/

$(document).ready(function (){
	$("#one_user").text(getCookie("username"));
	$("#one_anli_user").val(getCookie("username"));
	$("#anli_id").val(getCookie("anli_id"));
	$("#fk_userid").val(getCookie("userid"));
	$("#fk_username").val(getCookie("username"));
	var date=new Date();
	var year=date.getFullYear();
	var month=parseInt(date.getMonth())+1;
	var day=date.getDate();
	$("#one_anli_date").val(year+"-"+month+"-"+day);
	initHtml();
});

/*********************************封装的功能函数*********************************************/

//获取上下文路径
function getRealPath(){
	var curWwwPath=window.document.location.href;
	var pathName=window.document.location.pathname;
	var pos=curWwwPath.indexOf(pathName);
	var localhostPaht=curWwwPath.substring(0,pos);
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	var realPath=localhostPaht+projectName;
	return realPath;
}

//添加一个案例
function add(){
	
	insertParaForm();
	
}

//修改一个案例
function update(){
	$("#anli_id").val(getCookie("anli_id"));
	$("#method").val("update");
	insertParaForm();
}


//填充参数表单
function insertParaForm(){
	$("#anli_no").val($("#one_anli_no").val());
	$("#anli_name").val($("#one_anli_name").val());
	$("#anli_date").val($("#one_anli_date").val());
	$("#anzhu_name").val($("#one_anzhu_name").val());
	$("#anzhu_gender").val($("#one_anzhu_gender").val());
	$("#anzhu_birthday").val($("#one_anzhu_birthday").val());
	$("#anzhu_phoneno").val($("#one_anzhu_phoneno").val());
	$("#anzhu_guanxi").val($("#one_anzhu_guanxi").val());
	$("#lianxiren_name").val($("#one_lianxiren_name").val());
	$("#lianxiren_phoneno").val($("#one_lianxiren_phoneno").val());
	$("#wenti_shengli").val($("#one_wenti_shengli").val());
	$("#wenti_xinli").val($("#one_wenti_xinli").val());
	$("#wenti_shehui").val($("#one_wenti_shehui").val());
	$("#wenti_jiating").val($("#one_wenti_jiating").val());
	$("#wenti_qita").val($("#one_wenti_qita").val());
	$("#qiuzhu_jigou").val($("#one_qiuzhu_jigou").val());
	$("#zhuanjie_jigou").val($("#one_zhuanjie_jigou").val());
	$("#bujiean_miaoshu").val($("#one_bujiean_miaoshu").val());
}

//加载页面的时候进行页面的数据查询加载
function initHtml(){
	$.ajax({
		url:"AnLiCtrl/anLiCtrl",
		type:"post",
		async:false,
		data:{
			"method":"selectOne",
			"anli_id":getCookie("anli_id"),
			"fk_userid":getCookie("userid")
		},
		dataType:"json",
		success:function (result){
			var data=result.data;
			if(data!=null){
				$("#one_anli_no").val(data.anli_no);
				$("#one_anli_name").val(data.anli_name);
				$("#one_anli_date").val(data.anli_date);
				$("#one_anzhu_name").val(data.anzhu_name);
				$("#one_anzhu_gender").val(data.anzhu_gender);
				$("#one_anzhu_birthday").val(data.anzhu_birthday);
				$("#one_anzhu_phoneno").val(data.anzhu_phoneno);
				$("#one_anzhu_guanxi").val(data.anzhu_guanxi);
				$("#one_lianxiren_name").val(data.lianxiren_name);
				$("#one_lianxiren_phoneno").val(data.lianxiren_phoneno);
				$("#one_wenti_shengli").val(data.wenti_shengli);
				$("#one_wenti_xinli").val(data.wenti_xinli);
				$("#one_wenti_shehui").val(data.wenti_shehui);
				$("#one_wenti_jiating").val(data.wenti_jiating);
				$("#one_wenti_qita").val(data.wenti_qita);
				$("#one_qiuzhu_jigou").val(data.qiuzhu_jigou);
				$("#one_zhuanjie_jigou").val(data.zhuanjie_jigou);
				$("#one_bujiean_miaoshu").val(data.bujiean_miaoshu);
				$("#bja_btn").css("display","none");
				$("#saveAndStep_btn").css("display","none");
			}
		},
		error:function(){
			window.location.href="error.html";
		}
	});
}

/*******************************************页面js动态效果代码*****************************************/

//点击不不接案
$("#bja_btn").click(function(){
	$("#bja").css("display","block");
	$(".bujiean").css("display","block");
	if($(this).text()=="不接案"){
		$(this).text("接案");
		$("#bja").css("display","block");
		$(".bujiean").css("display","block");
		$("#saveAndStep_btn").hide();
		$("#state").val(8);
	}else{
		$(this).text("不接案");
		$("#bja").css("display","none");
		$(".bujiean").css("display","none");
		$("#saveAndStep_btn").show();
		$("#state").val("");
		$("#qiuzhu").attr("checked",null);
		$("#one_qiuzhu_jigou").val("");
		$("#zhuanjie").attr("checked",null);
		$("#one_zhuanjie_jigou").val("");
		$("#one_bujiean_miaoshu").val("");
	}
});

//点击具体某一件事情之后
$("#qiuzhu").click(function (){
	if($(this).is(':checked')){
		$(this).next().next().attr("disabled",null);
	}else{
		$(this).next().next().attr("disabled","disabled");
	}
});

$("#zhuanjie").click(function (){
	if($(this).is(':checked')){
		$(this).next().next().attr("disabled",null);
	}else{
		$(this).next().next().attr("disabled","disabled");
	}
});

/*******************************************点击按钮事件****************************************************/

//点击保存按钮
$("#save_btn").click(function (){
	if(getCookie("anli_id")==null){
		if($("#state").val()=='8'){
			$("#state").val(8);
		}else{
			$("#state").val(1);
		}
		option.success=function(result){
			alert(result.message);
			SetCookie("anli_id", result.anli_id);
			SetCookie("state", 1);
		};
		add();
	}else{
		if($("#state").val()=='8'){
			$("#state").val(8);
		}else{
			$("#state").val(getCookie("state"));
		}
		$("#anli_id").val(getCookie("anli_id"));
		option.success=function(result){
			alert(result.message);
		};
		update();
	}
	option.data=$("#paraForm").serialize();
	$.ajax(option);
});

//点击并且跳转
$("#saveAndStep_btn").click(function (){
	$("#state").val(2);
	if(getCookie("anli_id")==null){
		option.success=function(result){
			alert(result.message);
			SetCookie("anli_id", result.anli_id);
			SetCookie("state", 2);
			window.parent.contentTop.location.href="biaoti.html";
			window.location.href="soujiziliao.html";
		};
		add();
	}else{
		$("#anli_id").val(getCookie("anli_id"));
		option.success=function(result){
			
			if(result.statu==1){
				alert(result.message);
				window.parent.contentTop.location.href="biaoti.html";
				SetCookie("state", 2);
				window.location.href="soujiziliao.html";
			}else{
				alert(result.message);
			}
			
		};
		update();
	}
	option.data=$("#paraForm").serialize();
	$.ajax(option);
});
