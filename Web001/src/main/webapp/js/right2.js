var option={
	type:"post",
	url:"AnLiCtrl/anLiCtrl",
	async:false,
	data:$("#paraForm").serialize(),//参数是序列化的隐含域表单
	dataType:"json",
	success:function (result){
		$(".biaoge tr:gt(0)").remove();//移除所有的相关的元素节点
		var data=result.data;
		for (i=0;i<data.length;i++){
			$(".biaoge").append(
				'<tr onclick="lookDetil('+"'"+ data[i].anli_id+"'"+','+data[i].state+')">'
					+'<th style="background: url(img/line.gif); background-repeat: no-repeat;background-position: right;">'+(i+1)+'</th>'
					+'<th style="background: url(img/line.gif);background-repeat: no-repeat;background-position: right;">'+data[i].anli_no+'</th>'
					+'<th style="background: url(img/line.gif);background-repeat: no-repeat;background-position: right;">'+data[i].anli_name+'</th>'
					+'<th style="background: url(img/line.gif);background-repeat: no-repeat;background-position: right;">'+data[i].anzhu_name+'</th>'
					+'<th style="background: url(img/line.gif);background-repeat: no-repeat;background-position: right;">'+data[i].state+'</th>'
					+'<th style="background: url(img/line.gif);background-repeat: no-repeat;background-position: right;">'+data[i].anli_date+'</th>'
					+'<th style="background: url(img/line.gif);background-repeat: no-repeat;background-position: right;">'+data[i].fk_username+'</th>'
					+'<th><a id="deleteLink" href="javascript:void(0)" style="margin-left: 20px;" onclick="del(event,'+"'"+ data[i].anli_id+"'"+')">删除</a></th>'
				+'</tr>'
			);
		}
		SetCookie("pageCount",result.pageCount);
	},
	error:function (){
		alert("error");
	}
};


$(function(){
	//判断角色权限
	if(getCookie("role")==1){
		$(".chaxun").css("display","none");
	}else{
		$(".chaxun").css("display",null);
	}
});

$(document).ready(function (){
	//填充数据表格
	if(getCookie("minstate")!=null && getCookie("maxstate")!=null){
		$("#minstate").val(getCookie("minstate"));
		$("#maxstate").val(getCookie("maxstate"));
		//完成数据填充之后删除cookie缓存数据
		//还要改变上面的查询状态
		if(getCookie("maxstate")==6){
			$("#select_state").find("option").eq(1).attr("selected","selected");
		}else if(getCookie("maxstate")==7){
			$("#select_state").find("option").eq(2).attr("selected","selected");
		}else{
			$("#select_state").find("option").eq(3).attr("selected","selected");
		}
		option.data=$("#paraForm").serialize();
		delCookie("minstate");
		delCookie("maxstate");
	}
	$.ajax(option);
	//舒适化页面数据
	updateFenYe();
});

$("#next").click(function(){
	if((+getCookie("pageCount")==0)){
		alert("已经是最后一页");
		return;
	}
	//更改序列化表单数据
	var rowInOnePage=(+$("#rowInOnePage").val());
	var pageNum=getPageNumByOffset(+$("#offset").val(),rowInOnePage);//获取数据
	if(pageNum==(+getCookie("pageCount"))){
		alert("已经是最后一页");
		return;
	}
	$("#offset").val((pageNum)*rowInOnePage);
	option.data=$("#paraForm").serialize();
	$.ajax(option);
	updateFenYe();
});

$("#back").click(function (){
	var rowInOnePage=(+$("#rowInOnePage").val());
	var pageNum=getPageNumByOffset(+$("#offset").val(),rowInOnePage);//获取数据
	if(pageNum==1){
		alert("已经是第一页");
		return;
	}
	$("#offset").val((pageNum-2)*rowInOnePage);
	option.data=$("#paraForm").serialize();
	$.ajax(option);
	updateFenYe();
});

//查询状态改变出发
$(".chaxun form select").change(function (){
	var state = $(this).find("option:selected").val();
	var stateArr= state.split('');
	
	$("#minstate").val(stateArr[0]);
	$("#maxstate").val(stateArr[1]);
	
	option.data=$("#paraForm").serialize();
	$.ajax(option);
	updateFenYe();
});

//点击搜索根据搜索条件进行所搜
$(".cx-button").click(function(){
	//填充回传数据
	$("#bianhao").val($(".tiaojian").eq(0).val());
	$("#fk_username").val($(".tiaojian").eq(1).val());
	option.data=$("#paraForm").serialize();
	$.ajax(option);
	updateFenYe();
});

//更新页表下的分页
function updateFenYe(){
	var pageCount = getCookie("pageCount");
	if(+pageCount==0){
		$("#fenye").find("td p").text(1+"/"+1);
		return;
	}
	var offset=((+$("#offset").val()));
	var rowInOnePage=(+$("#rowInOnePage").val());
	var pageNum= getPageNumByOffset(offset,rowInOnePage);
	$("#fenye").find("td p").text(pageNum+"/"+pageCount);
}

//将ossset转为pagenum
function getPageNumByOffset(offset,rowInOnePage){
	if(offset==0){
		return 1;
	}
	return parseInt(offset/rowInOnePage)+1;
}
//点击某一个tr查看具体的，情况
function lookDetil(anli_id,state){
	SetCookie("anli_id",anli_id);
	window.parent.rightFrame.location="right3.html";
}
//假删除某一个案例
function del(event,anli_id){
	event.stopPropagation(); 
	$.ajax({
		type:"post",
		async:false,
		url:"AnLiCtrl/anLiCtrl",
		data:{
			"method":"delete",
			"anli_id":anli_id,
			"fk_userid":getCookie("userid")
		},
		dataType:"json",
		success:function (result){
			alert(result.message);
		},
		error:function (){
			window.location.href="error.html"
		}
	});
	//重新初始页面数据
	$.ajax(option);
	updateFenYe();
}

