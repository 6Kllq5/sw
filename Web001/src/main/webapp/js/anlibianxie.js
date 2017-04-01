var option = {
	url:"AnLiCtrl/anLiCtrl",
 	type:"post",
 	data:$("#paramForm").serialize(),
 	dataType:"json",
 	async:false,
 	success:function (){},
 	error:function (){
 		window.location.href="error.html";
 	}
};
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

//点击进行添加案例
function add(){
	if($("#state")=='8'){
		$("#state").val(8);
	}else{
		$("#state").val(1);
	}
	$("#state").val(1);
	insertParaForm();
	option.data=$("#paramForm").serialize();
}


//点击进行案例修改
function update(){
	$("#anli_id").val(getCookie("anli_id"));
	$("#state").val(getCookie("state"));
	$("#method").val("update");
	insertParaForm();
	option.data=$("#paramForm").serialize(),
	option.success=function(result){
		alert(result.message);
		//缓存anli_id
		SetCookie("anli_id", result.anli_id);
	};
}

//填充数据表格
function insertParaForm(){
	$("#anli_no").val(getCookie("one_anli_no"));//案例编号
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


//初始化加载
$(document).ready(function (){
	$("#one_user").text(getCookie("username"));
	$("#one_anli_user").val(getCookie("username"));
	$("#anli_id").val(getCookie("anli_id"));
	$("#fk_userid").val(getCookie("userid"));
	var date=new Date();
	var year=date.getFullYear();
	var month=parseInt(date.getMonth())+1;
	var day=date.getDate();
	$("#one_anli_date").val(year+"-"+month+"-"+day);
});



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

//点击保存按钮
$("#save_btn").click(function (){
	//以是否为空来进行判断只在第一个填写页面，其他页面使用是否对应某个值进行判断
	if(getCookie("state")==null){
		option.success=function(result){
			alert(result.message);
			SetCookie("anli_id", result.anli_id);
			SetCookie("state", 1);
		};
		add();
	}else{
		$("#anli_id").val(getCookie("anli_id"));
		option.success=function(result){
			alert(result.message);
		};
		update();
	}
	$.ajax(option);
});

//点击并且跳转
$("#saveAndStep_btn").click(function (){
	if(getCookie("anli_id")==null){
		option.success=function(result){
			alert(result.message);
			SetCookie("anli_id", result.anli_id);
			SetCookie("state", 1);
			window.location.href="soujiziliao.html";
		};
		add();
	}else{
		$("#anli_id").val(getCookie("anli_id"));
		option.success=function(result){
			alert(result.message);
		};
		update();
		window.location.href="soujiziliao.html";
	}
	$.ajax(option);
});








