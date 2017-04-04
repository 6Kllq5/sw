/**
 * 
 */
//点击个案工作
$(".nav li").eq(1).click(function (){
	window.parent.leftFrame.location="left2.html";
	window.parent.rightFrame.location="right2.html";
});
$(".nav li").eq(5).click(function (){
	window.parent.leftFrame.location="left2.html";
	window.parent.rightFrame.location="test.html";
});



