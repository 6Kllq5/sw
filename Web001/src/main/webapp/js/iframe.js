$(document).ready(function (){
	var state =getCookie("state");
	var url=getUrl(state);
	$("frameset").find("frame").eq(1).attr("src",url);
});

function getUrl(index){
	
	if(index==null){
		return "anlibianxie.html";
	}
	switch (+index) {
		case 1:
			return "anlibianxie.html";
			break;
		case 2:
			return "soujiziliao.html";
			break;
		case 3:
			return "fenxizenduan.html";
			break;
		case 4:
			return "zhidingjihua.html";
			break;
		case 5:
			return "shishichuzhi.html";
			break;
		case 6:
			return "jieanpinggu.html";
			break;
		case 7:
			return "anlibianxie.html";
			break;	
		case 8:
			return "anlibianxie.html";
			break;	
	}
}
