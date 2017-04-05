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


function xianshi()
{
	document.getElementById("tishiyi").style.display="block";
}
function likai()
{
	document.getElementById("tishiyi").style.display="none";
}
function xianshi1()
{
	document.getElementById("tishiyi1").style.display="block";
}
function likai1()
{
	document.getElementById("tishiyi1").style.display="none";
}
function xianshi2()
{
	document.getElementById("tishiyi2").style.display="block";
}
function likai2()
{
	document.getElementById("tishiyi2").style.display="none";
}
function xianshi3()
{
	document.getElementById("tishiyi3").style.display="block";
}
function likai3()
{
	document.getElementById("tishiyi3").style.display="none";
}
function xianshi4()
{
	document.getElementById("tishiyi4").style.display="block";
}
function likai4()
{
	document.getElementById("tishiyi4").style.display="none";
}
function xianshi5()
{
	document.getElementById("tishiyi5").style.display="block";
}
function likai5()
{
	document.getElementById("tishiyi5").style.display="none";
}
function xianshi6()
{
	document.getElementById("tishiyi6").style.display="block";
}
function likai6()
{
	document.getElementById("tishiyi6").style.display="none";
}
function xianshi7()
{
	document.getElementById("tishiyi7").style.display="block";
}
function likai7()
{
	document.getElementById("tishiyi7").style.display="none";
}




$(document).ready(function (){
	//加载富文本插件
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="content1"]', {
			cssPath: 'kindeditor-v4.1.7/kindeditor-4.1.7/plugins/code/prettify.css',
			resizeType: 0,
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
	
	//填充页面数据
	$.ajax({
		url:"",
		type:"post",
		dataType:"json",
		data:{
			"method":"select",
			"fk_userid":getCookie("userid"),
			"fk_anli_id":getCookie("anl_id")
		},
		success:function (result){
			var data=result.data;
			if(data!=null){
				SetCookie("zhenduan_id", data.zhenduan_id);
			}
		},
		error:function (){
			window.location.href="error.html";
		}
	});
	
	//悬浮显示提示
	$(".mark").hover(function (){
		$(".tishixinxi").eq($(this).index(".mark")).css("display","block");
	},function(){
		$(".tishixinxi").eq($(this).index(".mark")).css("display","none");
	});
});	

	
	
	

//定义提交ajax 集合
var option={
	url:"",
	data:{},
	type:"post",
	dataType:"json",
	success:function(){},
	error:function(){}
};

//填充提交数据表单
function insertForm(){
	
}

//点击提交
$("#save").click(function (){
	option.success=function(result){
		alert(result.message);
		SetCookie("zhenduan_id", result.jihua_id);
	};
	if(getCookie("zhenduan_id")!=null){
		update();
	}else{
		add();
	}
	$.ajax(option);
});

//点击保存并且跳转
$("#saveAndStep").click(function (){
	option.success=function(result){
		alert(result.message);
		window.location.href="shishichuzhi.html";
	};
	if(getCookie("zhenduan_id")!=null){
		update();
	}else{
		add();
	}
	window.location.href="zhidingjihua.html";
	$.ajax(option);
});

//监听页面离开时间
$(window).bind('beforeunload',function(){ 
	delCookie("zhenduan_id");
});





