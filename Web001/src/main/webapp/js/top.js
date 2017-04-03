/**
 * 
 */
//填充页面数据
$(".span p").text(getCookie("username"));
//退出登录
$("#logOut").click(function (){
	clearCookie();//清除所有的缓存
	window.parent.location.href="denglu.html";
});




//使用轮询遍历是否cookie是够还有纸
function checkUserCookie(){
	if(getCookie("userid")==null){
		window.parent.location.href="denglu.html";
	}else{
		return;
	}
}

//开启一个计时器
$(document).ready(function(){
	the_timeout = setInterval("checkUserCookie()", 100000);
});
