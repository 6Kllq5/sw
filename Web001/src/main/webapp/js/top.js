/**
 * 填充页面和启动一个计时器
 * 
 */
$(document).ready(function(){
	$(".span p").text(getCookie("username"));
	the_timeout = setInterval("checkUserCookie()", 100000);
});


/**
 * 
 * 
 * 退出登录
 * 
 */
$("#logOut").click(function (){
	window.parent.location.href="denglu.html";
});



/**
 * 判断是否还有cookie值
 * 
 */
function checkUserCookie(){
	if(getCookie("userid")==null){
		window.parent.location.href="denglu.html";
	}else{
		return;
	}
}


