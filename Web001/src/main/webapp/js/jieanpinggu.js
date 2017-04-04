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


//定义ajax 
var option={
	url:"JiHuaCtrl/jiHuaCtrl",
	type:"post",
	data:$("#paramForm").serialize(),
	async:false,
	success:function (){
	},
	error:function (){
		window.location.href="error.html";
	}
};


$(document).ready(function(){
	$.ajax({
		type:"get",
		url:"",
		async:true
	})
});


//点击保存并且跳转
$("#save").click(function(){
	
});


