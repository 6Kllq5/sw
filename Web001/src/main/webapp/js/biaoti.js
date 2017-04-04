/**
 * 
 */
$("a").click(function (){
	$(this).css("borderTop","3px solid #66c9f3")
	$(this).css("borderLeft","1px solid #C3C3C3");
	$(this).siblings().each(function (){
		$(this).css("borderTop","");
		$(this).css("borderTop","");
	});
	var url=strUrl($(this).index());
	if(url==null){
		alert("您还未对该页面进行编写!!");
		return;
	}else{
		window.parent.contentButtom.location=url;
	}
});

function strUrl(index){
	var state=getCookie("state");
	alert(state);
	var url="";
	switch (index) {
		case 0:
			url="anlibianxie.html";
			break;
		case 1:
			if(state<2){
				url=null;
			}else{
				url="soujiziliao.html";
			}
			break;
		case 2:
			if(state<3){
				url=null;
			}else{
				url="fenxizenduan.html";
			}
			break;
		case 3:
			if(state<4){
				url=null;
			}else{
				url="zhidingjihua.html";
			}
			break;
		case 4:
			if(state<5){
				url=null;
			}else{
				url="shishichuzhi.html";
			}
			break;
		case 5:
			if(state<6){
				url=null;
			}else{
				url="jieanpinggu.html";
			}
			break;
	}
	return url;
}



