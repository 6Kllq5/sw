$("#loginBtn").click(function (){
	//获取数据
	var loginname=$(".shurukuang").eq(0).val();
	var password=$(".shurukuang").eq(1).val();
	if(loginname==null|| password==null ||loginname==''||password==''){
		return ;
	}
	$.ajax({
		type:"post",
		url:"UserCtrl/userCtrl",
		dataType:"json",
		async:false,
		data:{
			"method":"login",
			"loginname":loginname,
			"password":password,
			"date":$.now()//为了避免缓存问题
		},
		success:function (result){
			//陈功之后缓存信息
			if(result.statu==0){
			}else{
				SetCookie("username",loginname);
				SetCookie("role",result.user.role);
				SetCookie("userid",result.user.userid);
			}
			alert(result.message)
			window.location.href="index.html";
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			 alert(XMLHttpRequest.status);
			 alert(XMLHttpRequest.readyState);
			 alert(textStatus);
		}
	});
});


