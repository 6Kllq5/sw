<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/left.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/reset.css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.1.1.min.js" ></script>
		<title></title>
	</head>
	<body>
		<div class="left">
			<img src="<%=request.getContextPath() %>/img/face1.gif" class="face" />
			<div class="liebiao">
				<ul>
					<li id="li1" style="background: url(<%=request.getContextPath() %>/img/libg.png);" onclick="a()" onmouseup="m1()"><img src="<%=request.getContextPath() %>/img/yuan.png" class="jiantou" id="jiantou1" />
						<p class="wenzi" id="wenzi1">案例列表</p>
					</li>
					<ul id="xiabian">
						<li>未结案</li>
						<li>已结案</li>
						<li>转&nbsp; 介</li>
					</ul>
					<li id="li2" onclick="b()" onmouseup="m2()"><img src="<%=request.getContextPath()%>/img/hz.png" class="jiantou" id="jiantou2" />
						<p class="wenzi1" id="wenzi2">案例编写</p>
					</li>
					
					<li id="li3" onclick="c()" onmouseup="m3()"><img src="<%=request.getContextPath() %>/img/hz.png" class="jiantou" id="jiantou3" />
						<p class="wenzi1" id="wenzi3">案例进展</p>
					</li>
				</ul>
			</div>
		</div>
		<script src="<%=request.getContextPath()%>/js/left2.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		//获取绝对上下文路径
		
		
		//点击分类查询
		$("#xiabian").children("li").eq("0").click(function(){
			window.parent.rightFrame.location=getRealPath()+"/getAllAnLiCtrl/getAllAnLi?minstate=1&maxstate=6&startNum=0&rowInOnePage=10&fk_userid=${userMap['userid']}";
			sessionStorage.minstate=1;
			sessionStorage.maxstate=6;
		})
		
		$("#xiabian").children("li").eq("1").click(function(){
			window.parent.rightFrame.location=getRealPath()+"/getAllAnLiCtrl/getAllAnLi?minstate=7&maxstate=7&startNum=0&rowInOnePage=10&fk_userid=${userMap['userid']}";
			sessionStorage.minstate=7;
			sessionStorage.maxstate=7;
		})
		
		$("#xiabian").children("li").eq("2").click(function(){
			window.parent.rightFrame.location=getRealPath()+"/getAllAnLiCtrl/getAllAnLi?minstate=8&maxstate=8&startNum=0&rowInOnePage=10&fk_userid=${userMap['userid']}";
			sessionStorage.minstate=8;
			sessionStorage.maxstate=8;
		})
		function b() {
			
			alert("okddd")
			document.getElementById("li2").style.background = "url(img/libg.png)";
			document.getElementById("wenzi2").style.color = "#FFFFFF";
			document.getElementById("jiantou2").src = "img/yuan.png";
			document.getElementById("li1").style.background = "none";
			document.getElementById("wenzi1").style.color = "#000";
			document.getElementById("jiantou1").src = "img/hz.png";
			document.getElementById("li3").style.background = "none";
			document.getElementById("wenzi3").style.color = "#000";
			document.getElementById("jiantou3").src = "img/hz.png";
			//清除session中的数据
			var option={
			    url: getRealPath()+'/deleteSessionAnLiCtrl/deleteSessionAnLi',
			    type: 'post',
			    dataType: 'json',
			    success: function (data) {
			    	sessionStorage.markSatate=1;
			    	window.parent.rightFrame.location=getRealPath()+"/right3.jsp";
			    },
			    error:function(){
			    	alert("error");
			    }
			};
			$.ajax(option);
			
		}
		</script>
	
	</body>
</html>