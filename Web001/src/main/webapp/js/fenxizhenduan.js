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
	
	
	
	
	
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="content1"]', {
			cssPath: 'kindeditor-v4.1.7/kindeditor-4.1.7/plugins/code/prettify.css',
			resizeType: 0,
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

//定义提交ajax 集合
var option={
	url:"",
	data:{},
	type:"post",
	dataType:"json",
	success:function(){},
	error:function(){}
};

//点击提交
$("#save").click(function (){
	option.success=function(result){
		alert(result.message);
		SetCookie("chuzhi_id", result.jihua_id);
	};
	if(getCookie("chuzhi_id")!=null){
		update();
	}else{
		add();
	}
	//$.ajax(option);
});

//点击保存并且跳转
$("#saveAndStep").click(function (){
	option.success=function(result){
		alert(result.message);
		window.location.href="shishichuzhi.html";
	};
	if(getCookie("chuzhi_id")!=null){
		update();
	}else{
		add();
	}
	window.location.href="shishichuzhi.html";
	//$.ajax(option);
});

//监听页面离开时间
$(window).bind('beforeunload',function(){ 
	delCookie("chuzhi_id");
});



