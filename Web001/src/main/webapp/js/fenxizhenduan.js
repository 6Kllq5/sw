/***********************************定义的全局变量********************************************/
//定义提交ajax 集合
var option={
	url:"FenXiCtrl/fenXiCtrl",
	data:$("#paraForm").serialize(),
	type:"post",
	async:false,
	dataType:"json",
	success:function(){},
	error:function(){}
};

var lcpg="";
var dcwj="";
var xzlx="";
var gtmslx="";
var jtjgt="";
var jtjgt="";
var stjgt="";
var shwlt="";

/*********************************页面加载*********************************************/

$(document).ready(function (){
	//填充id 外键数据
	$("#fk_userid").val(getCookie("userid"));
	$("#fk_anli_id").val(getCookie("anli_id"));
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
	//加载页面
	initHtml();

});	

/*********************************封装的功能函数*********************************************/

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

//填充提交数据表单
function insertParaForm(){
	
	
	
	
}

//添加
function add(){
	insertParaForm();
}

//修改
function update(){
	$("#zhenduan_id").val(getCookie("zhenduan_id"));
	
	$("#method").val("update");
	
	insertParaForm();
}

//加载页面
function initHtml(){
	$.ajax({
		url:"FenXiCtrl/fenXiCtrl",
		type:"post",
		dataType:"json",
		data:{
			"method":"select",
			"fk_userid":getCookie("userid"),
			"fk_anli_id":getCookie("anli_id")
		},
		success:function (result){
			var data=result.data;
			if(data==null){
				return;
			}
			
			//填充页面
			var linchuang_pinggu = data.linchuang_pinggu;
			var diaocha_wenjuan = data.diaocha_wenjuan;
			var diaocha_wenjuan = data.diaocha_wenjuan;
			
			$("#saveAndStep").css("display","none");
			
			//缓存id值
			SetCookie("zhenduan_id", data.zhenduan_id);
		},
		error:function (){
			window.location.href="error.html";
		}
	});
}

//监听页面离开时间
$(window).bind('beforeunload',function(){ 
	delCookie("zhenduan_id");
});

/*********************使用js 实现的页面动态效果**********************************/

//悬浮
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

/*******************************************点击按钮事件****************************************************/

//点击提交
$("#save").click(function (){
	if(getCookie("zhenduan_id")!=null){
		$("#state").val(getCookie("state"));
		option.success=function (result){
			alert(result.message);
		};
		update();
	}else{
		option.success=function (result){
			alert(result.message);
			SetCookie("zhenduan_id",result.zhenduan_id);
		};
		$("#state").val(3);
		add();
	}
	option.data=$("#paraForm").serialize();
	$.ajax(option);
});

//点击保存并且跳转
$("#saveAndStep").click(function (){
	$("#state").val(4);
	if(getCookie("zhenduan_id")!=null){
		update();
		option.success=function (result){
			alert(result.message);
			SetCookie("state", 4);
			window.parent.contentTop.location.href="biaoti.html";
			window.location.href="zhidingjihua.html";
		};
	}else{
		add();
		option.success=function (result){
			alert(result.message);
			SetCookie("state", 4);
			window.parent.contentTop.location.href="biaoti.html";
			window.location.href="zhidingjihua.html";
		};
	}
	option.data=$("#paraForm").serialize();
	$.ajax(option);
});
