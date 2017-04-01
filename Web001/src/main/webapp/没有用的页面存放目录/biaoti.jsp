<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/biaoti.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/reset.css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/fullcalendar-3.0.1/lib/jquery.min.js" ></script>
		<title></title>
	</head>
	<body>
		<!-- 本页只是在为了方便查看有效果 -->
		<div class="zhengti">
			<ul>
				<a href="javascript:void(0)" style="border-top: 3px solid #66c9f3;border-left: 1px solid #C3C3C3;">案例填写
					<li></li>
				</a>
				<a href="javascript:void(0)">搜集资料
					<li></li>
				</a>
				<a href="javascript:void(0)">分析诊断
					<li></li>
				</a>
				<a href="javascript:void(0)">制定计划
					<li></li>
				</a>
				<a href="javascript:void(0)">实施过程
					<li></li>
				</a>
				<a href="javascript:void(0)">结案评估
					<li></li>
				</a>
			</ul>
		</div>
		<!-- 用于提交数据的隐藏表单 -->
		<form></form>
		<script>
			//用于查看使用点击判断当前的state和页面对应的state的大小情况
			//获取绝对上下文路径
		function getRealPath(){
		   	var curWwwPath=window.document.location.href;
		   	//获取主机地址之后的目录，如： myproj/view/my.jsp
		  	var pathName=window.document.location.pathname;
		  	var pos=curWwwPath.indexOf(pathName);
		  	//获取主机地址，如： http://localhost:8083
		 	var localhostPaht=curWwwPath.substring(0,pos);
		  	//获取带"/"的项目名，如：/myproj
		  	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
		 
		 	//得到了 http://localhost:8083/myproj
		 	var realPath=localhostPaht+projectName;
			return realPath;
			}
			$("a").click(function(){
				var anli_id=sessionStorage.getItem("anli_id");
				if($(this).index()==0){
					if(sessionStorage.markSatate>0){
						$($(this)).css("borderTop","3px solid #66c9f3");
						$($(this)).css("borderLeft","1px solid #C3C3C3");
						$(this).siblings().css("borderTop","");
						$(this).siblings().css("borderLeft","");
						window.parent.contentButtom.location=getRealPath()+"/getAnLiCtrl/getAnLi?fk_userid=${userMap['userid']}&anli_id="+anli_id+"&markBTStep=1";
					}else{
						alert("尚未编辑该页面数据，不可查看");
					}
				}else if($(this).index()==1){
					if(sessionStorage.markSatate>1 && sessionStorage.markSatate<8){
						$($(this)).css("borderTop","3px solid #66c9f3");
						$($(this)).css("borderLeft","1px solid #C3C3C3");
						$(this).siblings().css("borderTop","");
						$(this).siblings().css("borderLeft","");
						window.parent.contentButtom.location=getRealPath()+"/getAllZhiLiaoCtrl/getAllZhiLiao?fk_userid=${userMap['userid']}&anli_id="+anli_id+"&markBTStep=1";
					}else{
						alert("尚未编辑该页面数据，不可查看");
					}
				}else if ($(this).index()==2){
					
					if(sessionStorage.markSatate>2 && sessionStorage.markSatate<8){
						$($(this)).css("borderTop","3px solid #66c9f3");
						$($(this)).css("borderLeft","1px solid #C3C3C3");
						$(this).siblings().css("borderTop","");
						$(this).siblings().css("borderLeft","");
						window.parent.contentButtom.location=getRealPath()+"/getFenXiResultCtrl/getFenXiResult?fk_userid=${userMap['userid']}&anli_id="+anli_id+"&markBTStep=1";
					}else{
						alert("尚未编辑该页面数据，不可查看");
					}
				}else if ($(this).index()==3){
					if(sessionStorage.markSatate>3 && sessionStorage.markSatate<8){
						$($(this)).css("borderTop","3px solid #66c9f3");
						$($(this)).css("borderLeft","1px solid #C3C3C3");
						$(this).siblings().css("borderTop","");
						$(this).siblings().css("borderLeft","");
						window.parent.contentButtom.location=getRealPath()+"/getJiHuaCtrl/getJiHua?fk_userid=${userMap['userid']}&anli_id="+anli_id+"&markBTStep=1";
					}else{
						alert("尚未编辑该页面数据，不可查看");
					}
				}else if($(this).index()==4){
					if(sessionStorage.markSatate>4 && sessionStorage.markSatate<8){
						$($(this)).css("borderTop","3px solid #66c9f3");
						$($(this)).css("borderLeft","1px solid #C3C3C3");
						$(this).siblings().css("borderTop","");
						$(this).siblings().css("borderLeft","");
						window.parent.contentButtom.location=getRealPath()+"/getChuZhiCtrl/getChuZhi?fk_userid=${userMap['userid']}&anli_id="+anli_id+"&markBTStep=1";
					}else{
						alert("尚未编辑该页面数据，不可查看");
					}
				}else if($(this).index()==5){
					if(sessionStorage.markSatate>5 && sessionStorage.markSatate<8){
						$($(this)).css("borderTop","3px solid #66c9f3");
						$($(this)).css("borderLeft","1px solid #C3C3C3");
						$(this).siblings().css("borderTop","");
						$(this).siblings().css("borderLeft","");
						window.parent.contentButtom.location=getRealPath()+"/getPingGuCtrl/getPingGu?fk_userid=${userMap['userid']}&anli_id="+anli_id+"&markBTStep=1";
					}else{
						alert("尚未编辑该页面数据，不可查看");
					}
				}
			});
			//初始化该页面
			$(function(){
				//用于记录当前的案例进行到第几不，并且同步标题
				var markBTState=sessionStorage.markSatate;
				if(8==markBTState){
					alert();
					$("a").eq(0).css("borderTop","3px solid #66c9f3");
					$("a").eq(0).css("borderLeft","1px solid #C3C3C3");
					$("a").not($("a")[0]).css("backgroundColor","gray");
					$("a").not($("a")[0]).css("backgroundColor","gray");
					return;
				}
				//同步标题标亮
				$("a").eq(markBTState-1).css("borderTop","3px solid #66c9f3");
				$("a").eq(markBTState-1).css("borderLeft","1px solid #C3C3C3");
				$("a").not($("a")[markBTState-1]).css("borderTop","");
				$("a").not($("a")[markBTState-1]).css("borderLeft","");
				//这是在标题中判定state，比state大的将会成灰色不可用状态,
				for(i=0;i<6;i++){
					if(i>markBTState-1){
						$("a").eq(i).css("backgroundColor","gray");
					}
				}
			});
		</script>
	</body>
</html>