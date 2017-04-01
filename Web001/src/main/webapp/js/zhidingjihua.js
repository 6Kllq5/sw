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
	//查询数据填充表单
	$.ajax({
		type:"post",
		url:"JiHuaCtrl/jiHuaCtrl",
		data:{
			"method":"select"
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
		prettyPrint();
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
	alert("gx");
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
		alert();
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
	//$.ajax(option);
});

//监听页面离开时间
$(window).bind('beforeunload',function(){ 
	delCookie("jihua_id");
});


