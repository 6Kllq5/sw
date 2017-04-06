//加载页面处理  -- 记住密码功能
$(document).ready(function(){
	var username = getCookie("username");
	if((password=getCookie(username))!=null){
		$(".shurukuang").eq(0).val(username);
		$(".shurukuang").eq(1).val(password);
		$("#ap").attr("checked","checked");
	}
});




//点击登录
$("#loginBtn").click(function (){
	var loginname=$(".shurukuang").eq(0).val();
	var password=$(".shurukuang").eq(1).val();
	
	if(loginname==''){
		alert("请填写用户名");
		return;
	}
	if(password==''){
		alert("请填写密码");
		return;
	}
	
	md5password=hex_md5(password);
	
	$.ajax({
		type:"post",
		url:"UserCtrl/userCtrl",
		dataType:"json",
		async:false,
		data:{
			"method":"login",
			"loginname":loginname,
			"password":md5password,
			"date":$.now()
		},
		success:function (result){
			if(result.statu==0){
				alert(result.message);
			}else{
				SetCookie("username",loginname);
				SetCookie("role",result.user.role);
				SetCookie("userid",result.user.userid);
				if($("#ap").is(":checked")){
					SetCookie(loginname, password);
				}
			}
			alert(result.message);
			window.location.href="index.html";
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			 alert(XMLHttpRequest.status);
			 alert(XMLHttpRequest.readyState);
			 alert(textStatus);
		}
	});
});

//缓存cookie
$("#ap").change(function (){
	if(this.checked){
		return;
	}else{
		$(".shurukuang").eq(0).val("");
		$(".shurukuang").eq(1).val("");
		var key=getCookie("username");
		delCookie(key);
	}
});







