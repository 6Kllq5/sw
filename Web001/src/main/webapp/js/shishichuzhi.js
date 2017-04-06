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

//初始化页面
$(document).ready(function (){
	//填充id值
	$("#fk_userid").val(getCookie("userid"));
	$("#fk_anli_id").val(getCookie("anli_id"));
	//查询数据填充表单
	$.ajax({
		type:"post",
		url:"ChuZhiCtrl/chuZhiCtrl",
		data:{
			"method":"select",
			"fk_userid":getCookie("userid"),
			"fk_anli_id":getCookie("anli_id")
		},
		async:false,
		dataType:"json",
		success:function (result){
			var data=result.data;
			if(data==null){
				return;
			}
			//填充数据
			$("#zdsj_content").val(data.zhengduan_shijian);
			$("#miaoshu_content").val(data.zhixing_miaoshu);//获取的是文本编辑器中的内容
			$("#beizhu").val(data.beizhu);
			$("#saveAndStep").css("display","none");
			SetCookie("chuzhi_id", data.chuzhi_id);
		},
		error:function(){
			window.location.href="error.html";
		}
	});
});

//定义ajax 
var option={
	url:"ChuZhiCtrl/chuZhiCtrl",
	type:"post",
	data:$("#paramForm").serialize(),
	async:false,
	success:function (result){
		
	},
	error:function (){
		window.location.href="error.html";
	}
};

//填提交表单必要的参数
function insertParaForm(){
	$("#zhengduan_shijian").val($("#zdsj_content").val());
	$("#zhixing_miaoshu").val($("#miaoshu_content").val());
	$("#beizhu").val($("#beizhu_content").val());
}

//添加
function add(){
	insertParaForm();
	option.data=$("#paraForm").serialize();
}

//修改
function update(){
	$("#method").val("update");
	$("#chuzhi_id").val(getCookie("chuzhi_id"));
	insertParaForm();
	option.data=$("#paraForm").serialize();
}

//点击提交
$("#save").click(function (){
	option.success=function(result){
		alert(result.message);
		alert(result.chuzhi_id);
		SetCookie("chuzhi_id",result.jihua_id);
	};
	alert(getCookie("chuzhi_id"));
	if(getCookie("chuzhi_id")!=null){
		$("#state").val(getCookie("state"));
		
		update();
	}else{
		$("#state").val(5);
		add();
	}
	$.ajax(option);
});

//点击提交并且跳转
$("#saveAndStep").click(function (){
	$("#state").val(6);
	option.success=function(result){
		alert(result.message);
		SetCookie("state", 6);
		window.location.href="jieanpinggu.html";
		window.parent.contentTop.location.href="biaoti.html";
	};
	if(getCookie("chuzhi_id")!=null){
		update();
	}else{
		add();
	}
	$.ajax(option);
});

//监听页面离开时间
$(window).bind('beforeunload',function(){ 
	delCookie("chuzhi_id");
});





