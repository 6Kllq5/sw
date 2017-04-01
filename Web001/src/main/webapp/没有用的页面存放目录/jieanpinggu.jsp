<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/reset.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/jieanpinggu.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/anlibianxie.css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/fullcalendar-3.0.1/lib/jquery.min.js" ></script>
		<title></title>
	</head>
	<body>
		<div class="jieanpinggu">
			<p class="huanyingyu">Hi,<b style="color: red;">admin</b>欢迎进行结案评估</p>
			<div class="zuo">
				<!--是否达到目标-->
				<div class="zuo1">
					<p style="color: red;font-weight: bold;position: relative;left: 28%;">!!是否达到目标</p>
					<c:choose>
						<c:when test="${pinggu!=null }">
							<c:if test="${pinggu.daoda_mubiao==''}">
								<form method="post" style="margin: 10px 30%;">
									
									<input type="radio" name="zx" value="yes" checked="checked" id="y1"/><label for="y1">是</label>
									<input type="radio" name="zx" value="no" style="margin-left: 5px;" id="n1" /><label for="n1">否</label>
		
								</form>
								<textarea placeholder="请输入您预期想要达到的目标..." disabled="disabled" style="font-size: 12px;height: 150px;width: 80%;"></textarea>
							</c:if>
							<c:if test="${pinggu.daoda_mubiao!='' }">
								<form method="post" style="margin: 10px 30%;">
									
									<input type="radio" name="zx" value="yes"  id="y1"/><label for="y1">是</label>
									<input type="radio" name="zx" value="no" checked="checked" style="margin-left: 5px;" id="n1" /><label for="n1">否</label>
		
								</form>
								<textarea placeholder="请输入您预期想要达到的目标..."  style="font-size: 12px;height: 150px;width: 80%;">${pinggu.daoda_mubiao}</textarea>
							</c:if>
						</c:when>
						<c:otherwise>
							<form method="post" style="margin: 10px 30%;">
								<input type="radio" name="zx" value="yes" checked="checked" id="y1"/><label for="y1">是</label>
								<input type="radio" name="zx" value="no" style="margin-left: 5px;" id="n1" /><label for="n1">否</label>
		
							</form>
							<textarea placeholder="请输入您预期想要达到的目标..." disabled="disabled" style="font-size: 12px;height: 150px;width: 80%;"></textarea>
						</c:otherwise>
					</c:choose>
				</div>
				<!--工作方式是否得当-->
				<div class="zuo1" style="margin-top: 20px;">
					<p style="color: red;font-weight: bold;position: relative;left: 28%;">!!工作方式是否得当</p>
					
					<c:choose>
						<c:when test="${pinggu!=null }">
							<c:if test="${pinggu.fangshi_dedang==''}">
								<form method="post" style="margin: 10px 30%;">
									<input type="radio" name="zx" value="yes" checked="checked" id="y2"/><label for="y2">是</label>
									<input type="radio" name="zx" value="no" style="margin-left: 5px;" id="n2"/><label for="n2">否</label>
								</form>
								<textarea placeholder="请输入您预期想要达到的目标..." disabled="disabled" style="font-size: 12px;height: 150px;width: 80%;"></textarea>
							</c:if>
							<c:if test="${pinggu.fangshi_dedang!=''}">
								<form method="post" style="margin: 10px 30%;">
									<input type="radio" name="zx" value="yes"  id="y2"/><label for="y2">是</label>
									<input type="radio" name="zx" value="no" checked="checked" style="margin-left: 5px;" id="n2"/><label for="n2">否</label>
								</form>
								<textarea placeholder="请输入您预期想要达到的目标..." style="font-size: 12px;height: 150px;width: 80%;">${pinggu.fangshi_dedang}</textarea>
							</c:if>
						</c:when>
						<c:otherwise>
							<form method="post" style="margin: 10px 30%;">
								<input type="radio" name="zx" value="yes" checked="checked" id="y2"/><label for="y2">是</label>
								<input type="radio" name="zx" value="no" style="margin-left: 5px;" id="n2"/><label for="n2">否</label>
							</form>
							<textarea placeholder="请输入您预期想要达到的目标..." disabled="disabled" style="font-size: 12px;height: 150px;width: 80%;"></textarea>
						</c:otherwise>
					</c:choose>
				</div>
			</div>	
		
			<div class="you">
				<!--评定等级-->
				<div class="you1">
					<p style="color: red;font-weight: bold;position: relative;left: 28%;">!!评定等级</p>
					
					<c:choose>
						<c:when test="${pinggu!=null }">
							<form method="post" style="margin: 10px 30%;">
								<c:choose>
									<c:when test="${pinggu.pingding_dengji=='0' }">
										<input type="radio" name="pd" value="0" checked="checked" id="d1"/><label for="d1">等级一</label>
									</c:when>
									<c:otherwise>
										<input type="radio" name="pd" value="0" id="d1"/><label for="d1">等级一</label>
									</c:otherwise>
								</c:choose>
								<br />
								<c:choose>
									<c:when test="${pinggu.pingding_dengji=='1' }">
										<input type="radio" checked="checked" name="pd" value="1" id="d2"/><label for="d2">等级二</label>
									</c:when>
									<c:otherwise>
										<input type="radio" name="pd" value="1" id="d2"/><label for="d2">等级二</label>
									</c:otherwise>
								</c:choose>
								<br />
								
								<c:choose>
									<c:when test="${pinggu.pingding_dengji=='2' }">
										<input type="radio" name="pd" value="2" checked="checked" id="d3" /><label for="d3">等级三</label>
									</c:when>
									<c:otherwise>
										<input type="radio" name="pd" value="2" id="d3" /><label for="d3">等级三</label>
									</c:otherwise>
								</c:choose>
								<br />
								
								<c:choose>
									<c:when test="${pinggu.pingding_dengji=='3' }">
										<input type="radio" name="pd" value="3" checked="checked" id="d4" /><label for="d4">等级四</label>
									</c:when>
									<c:otherwise>
										<input type="radio" name="pd" value="3" id="d4" /><label for="d4">等级四</label>
									</c:otherwise>
								</c:choose>
								<br />
								<c:choose>
									<c:when test="${pinggu.pingding_dengji=='4' }">
										<input type="radio" name="pd" value="4" checked="checked" id="d5" /><label for="d5">等级五</label>
									</c:when>
									<c:otherwise>
										<input type="radio" name="pd" value="4" id="d5" /><label for="d5">等级五</label>
									</c:otherwise>
								</c:choose>
								
							</form>
						</c:when>
					
						<c:otherwise>
							<form method="post" style="margin: 10px 30%;">
								<input type="radio" name="pd" value="0" checked="checked" id="d1"/><label for="d1">等级一</label>
								<br />
								<input type="radio" name="pd" value="1" id="d2"/><label for="d2">等级二</label>
								<br />
								<input type="radio" name="pd" value="2" id="d3" /><label for="d3">等级三</label>
								<br />
								<input type="radio" name="pd" value="3" id="d4" /><label for="d4">等级四</label>
								<br />
								<input type="radio" name="pd" value="4" id="d5" /><label for="d5">等级五</label>
							</form>
						</c:otherwise>
					</c:choose>
					
				<!--提示跟进服务-->
				<div class="you2" style="margin-top: 75px;">
					<p style="color: red;font-weight: bold;position: relative;left: 28%;">!!提示跟进服务</p>
					
					<c:choose>
						<c:when test="${pinggu!=null }">
							<form method="post" style="margin: 10px 30%;width: 80%;">
								<c:choose>
									<c:when test="${pinggu.gengjing_fuwu=='0' }">
										<input type="radio" name="gjfw" value="0" checked="checked" id="dhgj"/><label for="dhgj">电话跟进</label>
									</c:when>
									<c:otherwise>
										<input type="radio" name="gjfw" value="0"  id="dhgj"/><label for="dhgj">电话跟进</label>
									</c:otherwise>
								</c:choose>
								
								<br />
								
								<c:choose>
									<c:when test="${pinggu.gengjing_fuwu=='1' }">
										<input type="radio" name="gjfw" value="1" checked="checked"  id="gbhm"/><label for="gbhm">个别会面</label>
									</c:when>
									<c:otherwise>
										<input type="radio" name="gjfw" value="1" id="gbhm"/><label for="gbhm">个别会面</label>
									</c:otherwise>
								</c:choose>
								
								<br />
								<c:choose>
									<c:when test="${pinggu.gengjing_fuwu=='2' }">
										<input type="radio" name="gjfw" checked="checked" value="2" id="jthm" /><label for="jthm">集体会面</label>
									</c:when>
									<c:otherwise>
										<input type="radio" name="gjfw" value="2" id="jthm" /><label for="jthm">集体会面</label>
									</c:otherwise>
								</c:choose>
								<br />
								<c:choose>
									<c:when test="${pinggu.gengjing_fuwu=='3' }">
										<input type="radio" name="gjfw" value="3" checked="checked" id="gjfwdxdshwl"/><label for="gjfwdxdshwl">跟进服务对象的社会支持网络</label>
									</c:when>
									<c:otherwise>
										<input type="radio" name="gjfw" value="3"  id="gjfwdxdshwl"/><label for="gjfwdxdshwl">跟进服务对象的社会支持网络</label>
									</c:otherwise>
								</c:choose>
							</form>
						</c:when>
						<c:otherwise>
							<form method="post" style="margin: 10px 30%;width: 80%;">
								<input type="radio" name="gjfw" value="0" checked="checked" id="dhgj"/><label for="dhgj">电话跟进</label>
								<br />
								<input type="radio" name="gjfw" value="1" id="gbhm"/><label for="gbhm">个别会面</label>
								<br />
								<input type="radio" name="gjfw" value="2" id="jthm" /><label for="jthm">集体会面</label>
								<br />
								<input type="radio" name="gjfw" value="3"  id="gjfwdxdshwl"/><label for="gjfwdxdshwl">跟进服务对象的社会支持网络</label>
							</form>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		</div>
		<!-- 隐藏的form表单用于提交后台数据 -->
		<form id="pingguForm">
			
			<input type="hidden" id="daoda_mubiao" name="daoda_mubiao"/>
			
			<input type="hidden" id="fangshi_dedang" name="fangshi_dedang"/>
			
			<input type="hidden" id="pingding_dengji" name="pingding_dengji"> 
		
			<input type="hidden" id="gengjing_fuwu" name="gengjing_fuwu"> 
			
			<input type="hidden" id="chengxiao_jielun" name="chengxiao_jielun">
			
			<!--用于存放两个外键  -->
			<input type="hidden" name="fk_userid" value="${userMap['userid']} "/>
			<input type="hidden" id="fk_anli_id" name="fk_anli_id"/>
			
			<c:choose>
				<c:when test="${session_anli!=null }">
					<input type="hidden" id="anli_state" value="${sesssion_anli.state}" name="state"/>
				</c:when>
				<c:otherwise>
					<input type="hidden"  id="anli_state" value="6" name="state"/>
				</c:otherwise>
			</c:choose>
			
		</form>
		
		<div class="chengxiaojielun" style="clear: both;position: relative;top: 20px;width: 50%;height:300px;margin-left: 2%">
			<p style="float: left;">成效结论<p style="color: red;float: left;">*</p>
			<br />
			<c:choose>
				<c:when test="${pinggu!=null }">
					<textarea style="width: 100%;height: 180px;clear: both;margin-top: 10px; resize:none;" cols="3" rows="2">${pinggu.chengxiao_jielun}</textarea>
				</c:when>
				<c:otherwise>
					<textarea style="width: 100%;height: 180px;clear: both;margin-top: 10px; resize:none;" cols="3" rows="2"></textarea>
				</c:otherwise>
			</c:choose>
			
			
			<c:choose>
				<c:when test="${pinggu!=null}">
					<c:choose>
						<c:when test="${session_anli!=null and session_anli.state!=6}">
							<button id="updateAndStep" type="button" style="background: #3e97c9;width: 80px;height: 30px;color: #FFFFFF;margin-left: 88%;margin-top: 20px;border-radius: 5px;border: none;margin-bottom: 20px;">完成</button>
						</c:when>
						<c:otherwise>
							<button id="updateAndStep" type="button" style="background: #3e97c9;width: 80px;height: 30px;color: #FFFFFF;margin-left: 88%;margin-top: 20px;border-radius: 5px;border: none;margin-bottom: 20px">完成</button>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<button type="button" id="saveAndStep" style="background: #3e97c9;width: 80px;height: 30px;color: #FFFFFF;margin-left: 88%;margin-top: 20px;border-radius: 5px;border: none;margin-bottom: 20px;">完成</button>
				</c:otherwise>
			</c:choose>
		</div>
		
		<!--右边提示部分-->
		<div class="youbian">
			<p class="tishi">!!提示</p>
		</div>
		<!--使用异步提交方便了在框架基础上的页面跳转 -->
		<script src="<%=request.getContextPath()%>/js/jieanpinggu.js"> </script>
		<%
			//清空session数据
			if(session.getAttribute("pinggu")!=null){
				session.removeAttribute("pinggu");
			}
		%>
	</body>
</html>