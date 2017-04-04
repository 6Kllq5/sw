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
$(document).ready(function (){
	
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
			if(data!=null){
				//填充页面数据
				
				
				//缓存cookie 
				SetCookie("chuzhi_id",result.jihua_id);
			}
		},
		error:function(){
			
			window.location.href="error.html";
		}
	});
	//初始化页面数据
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="content1"]', {
			cssPath: 'kindeditor-v4.1.7/kindeditor-4.1.7/plugins/code/prettify.css',
			resizeType:0,
			//				uploadJson : '../jsp/upload_json.jsp',
			//				fileManagerJson : '../jsp/file_manager_json.jsp',
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
});



//定义ajax 
var option={
	url:"ChuZhiCtrl/chuZhiCtrl",
	type:"post",
	data:$("#paramForm").serialize(),
	async:false,
	success:function (){
		
	},
	error:function (){
		window.location.href="error.html";
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
	$("#method").val("update");
	insertParaForm();
	option.data=$("#paraForm").serialize();
}

//点击提交
$("#save").click(function (){
	option.success=function(result){
		alert(result.message);
		SetCookie("chuzhi_id",result.jihua_id);
	};
	alert(getCookie("chuzhi_id"));
	if(getCookie("chuzhi_id")!=null){
		alert();
		update();
	}else{
		add();
	}
	$.ajax(option);
});

//点击提交并且跳转
$("#saveAndStep").click(function (){
	option.success=function(result){
		alert(result.message);
		window.location.href="jieanpinggu.html";
	};
	if(getCookie("chuzhi_id")!=null){
		update();
	}else{
		add();
	}
	window.location.href="jieanpinggu.html";
	$.ajax(option);
});

//监听页面离开时间
$(window).bind('beforeunload',function(){ 
	delCookie("chuzhi_id");
});


