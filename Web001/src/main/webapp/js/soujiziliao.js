var option={
	url:"FileCtrl/uploadfileCtrl",
	type:"post",
	async:false,
	dataType:"json",
	success:function (result){
		
	},
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

//清空form表单中的file 文件
function clearFileInput(){
	var file = $("#file");
	file.after(file.clone().val("")); 
	file.remove();  
}

//验证是否选择了文件
function isHaveFile(){
	var file = $("#file").val();
	if(file==''){
		return false;
	}else{
		return true;
	}
}


//添加页面数据
function insertTable(){
	//移除
	$("#wenjian_table tr:gt(0)").remove();
	//填充
	$.ajax({
		url:"FileCtrl/fileCtrl",
		data:{
			"fk_anli_id":getCookie("anli_id"),
			"fk_userid":getCookie("userid"),
			"method":"select_all"
		},
		dataType:"json",
		async:false,
		success:function (result){
			var dataList=result.data;
			for (i = 0;i<dataList.length;i++){
			$("#wenjian_table").append(
					'<tr class="bianse">'
						+'<td style="width: 10%;">'+(i+1)+'</td>'
						+'<td style="width: 15%;">'+dataList[i].wenjian_name+'</td>'
						+'<td style="width: 15%;">'+dataList[i].wenjian_gengxinshijian+'</td>'
						+'<td style="width: 25%;">'+(getCookie("username"))+'</td>'
						+'<td class="bianji">'
							+'<ul>'
								+'<a href="javascript:void(0)" onclick="del('+"'"+dataList[i].wenjian_id+"'"+')">'
									+'<li>删除</li>' 
								+'</a>'
								+'<a href="FileCtrl/downloadfile?filepath='+dataList[i].wenjian_lujing+'">'
									+'<li >下载</li>'
								+'</a>'
								+'<a href="javascript:void(0)" onclick="addNote('+"'"+dataList[i].wenjian_id+"'"+','+"'"+dataList[i].wenjian_jianjie+"'"+','+"'"+dataList[i].wenjian_name+"'"+')"  style="border: none;">'
									+'<li >添加简介</li>'
								+'</a>'
							+'</ul>'
						+'</td>'
					+'</tr>'
				);
			}
			alert(result.message);
		},
		error:function (){
		}
	});
}


//删除文件
function deleteWj(wenjian_id){
	$.ajax({
		url:"FileCtrl/fileCtrl",
		dataType:"json",
		async:false,
		data:{
			"wenjian_id":wenjian_id,
			"method":"delete",
			"fk_userid":getCookie("userid"),
			"fk_anli_id":getCookie("anli_id")
		},
		success:function (result){
			//删除回来提示删除情况
			alert(result.message);
		},
		error:function (){
			window.location.href="error.html";
		}
	});
}



//更新事件简介
function updateJianJie(){
	//获取更新文本的内容
	var wenjian_jianjie=$("#wjjj").val();
	alert(wenjian_jianjie);
	$.ajax({
		url:"FileCtrl/fileCtrl",
		async:false,
		type:"post",
		data:{
			"wenjian_id":getCookie("temp_wenjian_id"),
			"fk_userid":getCookie("userid"),
			"fk_anli_id":getCookie("anli_id"),
			"wenjian_jianjie":wenjian_jianjie,
			"method":"update"
		},
		dataType:"json",
		success:function (result){
			alert(result.message);
			delCookie("temp_wenjian_id");
			insertTable();
		},
		error:function (){
			window.location.href="error.html";
		}
	});
}

//删除事件
function del(wenjian_id){
	deleteWj(wenjian_id);
	insertTable();
}

//下载事件
function dwd(wenjian_path){
	alert(wenjian_path);
	wenjian_path=wenjian_path.replace(/\+/g, "\\");
	alert(wenjian_path);
	downloadFile(wenjian_path);
}


//显示添加简介事件弹窗
function addNote(wenjian_id,wenjian_jianjie,wenjian_name){
	SetCookie("temp_wenjian_id", wenjian_id);
	$("#file_name").html(wenjian_name);
	$("#fuc").css("display","block");
	$("#wjjj").val(wenjian_jianjie);
}


$(document).ready(function (){
	$("#fk_userid").val(getCookie("userid"));
	$("#fk_anli_id").val(getCookie("anli_id"));
	if((anli_id=getCookie("anli_id"))!=null){
		insertTable(anli_id);
	}
	//点击上传文件
	$("#save_btn").click(function (){
		if(!isHaveFile()){
			alert("请选择要上传的文件");
			return;
		}
		option.success=function(result){
			alert(result.message);
		};
		$("#state").val(getCookie("state"));
		$("#fileForm").ajaxSubmit(option);
		clearFileInput();
		insertTable();
	});
	
	
	//点击上传文件并且跳转
	$("#saveAndStep").click(function (){
		if(!isHaveFile()){
			//发送一个请求更新state,没有办法只能这么做了
			$.ajax({
				url:"FileCtrl/updateState",
				type:"post",
				dataType:"json",
				data:{
					"anli_id":getCookie("anli_id"),
					"fk_userid":getCookie("userid"),
					"state":2
				},
				async:false,
				success:function (result){
					
					window.location.href="fenxizenduan.html";
				},
				error:function (){
				}
			});
			return;
		}else{
			option.success=function(result){
				alert(result.message);
				window.location.href="fenxizenduan.html";
			};
			$("#wenjian_jianjie").val($("wjjj").text());
			$("#state").val(2);
			$("#fileForm").ajaxSubmit(option);
			clearFileInput();
			insertTable();
		};
	});
	
	//点击天添加简介事件
	$("#commit").click(function(){
		updateJianJie();
		$("#fuc").css("display","none");
	});
});






