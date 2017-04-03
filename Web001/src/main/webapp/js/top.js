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
