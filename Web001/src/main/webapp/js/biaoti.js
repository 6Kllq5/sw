/**
 * 
 */
$("a").click(function (){
	$(this).css("borderTop","3px solid #66c9f3")
	$(this).css("borderLeft","1px solid #C3C3C3");
	$(this).siblings().each(function (){
		$(this).css("borderTop","");
		$(this).css("borderTop","");
	})
	var url=strUrl($(this).index())
	window.parent.contentButtom.location=url;
});

function strUrl(index){
	var url="";
	switch (index) {
		case 0:
			url="anlibianxie.html";
			break;
		case 1:
			url="soujiziliao.html";
			break;
		case 2:
			url="fenxizenduan.html";
			break;
		case 3:
			url="zhidingjihua.html";
			break;
		case 4:
			url="shishichuzhi.html";
			break;
		case 5:
			url="jieanpinggu.html";
			break;
	}
	return url;
}

