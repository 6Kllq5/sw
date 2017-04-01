

//很不情愿用了本地存储cookie,重新定位到页面表格页面
$("#xiabian").children("li").eq("0").click(function(){
	//缓存数据之后在进数据的刷新
	SetCookie("minstate",1);
	SetCookie("maxstate",6);
	parent.rightFrame.location="right2.html"; 
});
$("#xiabian").children("li").eq("1").click(function(){
	SetCookie("minstate",7);
	SetCookie("maxstate",7);
	parent.rightFrame.location="right2.html"; 
});
$("#xiabian").children("li").eq("2").click(function(){
	SetCookie("minstate",8);
	SetCookie("maxstate",8);
	parent.rightFrame.location="right2.html";
});

//悬浮颜色变化
$(".liebiao ul").find("li").hover(function (){
	$(this).css("color","#55ecb9")
},function (){
	$(this).css("color","#000")
})

//点击案例编写
$("#li1").click(function (){
	document.getElementById("li1").style.background = "url(img/libg.png)";
	document.getElementById("wenzi1").style.color = "#FFFFFF";
	document.getElementById("jiantou1").src = "img/yuan.png";
	if(document.getElementById("xiabian").style.display == "none") {
		document.getElementById("xiabian").style.display = "block";
	} else {
		document.getElementById("xiabian").style.display = "none";
	}
	document.getElementById("li2").style.background = "none";
	document.getElementById("wenzi2").style.color = "#000";
	document.getElementById("jiantou2").src = "img/hz.png";
	document.getElementById("li3").style.background = "none";
	document.getElementById("wenzi3").style.color = "#000";
	document.getElementById("jiantou3").src = "img/hz.png";
	
});

//点击案例编写 
$("#li2").click(function(){
	//关闭上面的二级
	document.getElementById("xiabian").style.display= "none";
	document.getElementById("li2").style.background = "url(img/libg.png)";
	document.getElementById("wenzi2").style.color = "#FFFFFF";
	document.getElementById("jiantou2").src = "img/yuan.png";
	document.getElementById("li1").style.background = "none";
	document.getElementById("wenzi1").style.color = "#000";
	document.getElementById("jiantou1").src = "img/hz.png";
	document.getElementById("li3").style.background = "none";
	document.getElementById("wenzi3").style.color = "#000";
	document.getElementById("jiantou3").src = "img/hz.png";
	parent.rightFrame.location="right3.html";
	//点击案例编写就要清空state
	delCookie("state");
	delCookie("anli_id");
})




