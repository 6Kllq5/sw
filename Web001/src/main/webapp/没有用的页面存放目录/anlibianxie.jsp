<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="java.util.Map" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/reset.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/anlibianxie.css" />
		<script src="<%=request.getContextPath() %>/js/liebiao.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/fullcalendar-3.0.1/lib/jquery.min.js" ></script>
		<title></title>
	</head>
	<body>
		<form id="addAnLiForm" method="post">
		<div class="anlibianxie">
			<p class="huanyingyu">Hi,<b style="color: red;">admin</b>,欢迎进行案例填写</p>
			<div>
				<p class="bba">个案
					<p style="color: red;">*</p>
				</p>
			</div>
			<!--个案-->
			<div class="zuobian">
				<!--1-->
				<div style="margin: 10px 0 10px -10px; ">

					<div class="xia">
						<p class="bba1" >编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					<c:choose>
						<c:when test="${anli!=null}">
							<input type="text" style="float: left;" class="shuru" value="${anli.anli_no}" name="anli_no"/>
						</c:when>
						<c:otherwise>
							<input type="text" style="float: left;" class="shuru"  name="anli_no"/>
						</c:otherwise>
					</c:choose>
				</div>
				<!--1-->
				<div style="margin: 20px 0 10px -10px; clear: both;">
					<div class="xia">
						<p class="bba1">个案标题
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					
					<c:choose>
						<c:when test="${anli!=null }">
							<input type="text" style="float: left;" class="shuru" value="${anli.anli_name}" name="anli_name"/>
						</c:when>
						<c:otherwise>
							<input type="text" style="float: left;" class="shuru" name="anli_name"/>
						</c:otherwise>
					</c:choose>
				</div>
				
				<!--1-->
				<div style="margin: 30px 0 10px -10px; clear: both;">
					<div class="xia">
						<p class="bba1">日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					<c:choose>
						<c:when test="${anli!=null }">
							<input type="text" style="float: left;" value="${anli.anli_date}" disabled="disabled" class="shuru"/>
						</c:when>
						<c:otherwise>
							<input type="text" style="float: left;" disabled="disabled" class="shuru"/>
						</c:otherwise>
					</c:choose>
					
				</div>
				<!--end-->
				<!--1-->
				<div style="margin: 30px 0 10px -10px; clear: both;">

					<div class="xia">
						<p class="bba1">工&nbsp; 作&nbsp;者
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					<c:choose>
						<c:when test="${anli!=null} ">
							<input type="text" style="float: left;" disabled="disabled" value="${anli.fk_username}" class="shuru" />
						</c:when>
						<c:otherwise>
								<input type="text" style="float: left;" disabled="disabled" class="shuru" />
						</c:otherwise>
					</c:choose>
				</div>
				<!--end-->
			</div>
			<div>
				<p class="bba">案主
					<p style="color: red;">*</p>
				</p>
			</div>
			<!--案主-->
			<div class="zuobian1">
				<!--1-->
				<div style="margin: 10px 0 10px -10px; ">
					<div class="xia">
						<p class="bba1">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					<c:choose>
						<c:when test="${anli!=null }">
							<input type="text" style="float: left;" class="shuru" value="${anli.anzhu_name}" name="anzhu_name"/>
						</c:when>
						<c:otherwise>
							<input type="text" style="float: left;" class="shuru" name="anzhu_name"/>
						</c:otherwise>
					</c:choose>
				</div>
				<!--1-->
				<div style="margin: 30px 0 10px -10px; clear: both;">

					<div class="xia">
						<p class="bba1">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					<c:choose>
						<c:when test="${anli!=null }">
							<input type="text" style="float: left;" class="shuru" value="${anli.anzhu_gender }" name="anzhu_gender"/>
						</c:when>
						<c:otherwise>
							<input type="text" style="float: left;" class="shuru"  name="anzhu_gender"/>
						</c:otherwise>
					</c:choose>
				</div>
				<!--end-->
				<!--1-->
				<div style="margin: 30px 0 10px -10px; clear: both;">
					<div class="xia">
						<p class="bba1">出生日期
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					<c:choose>
						<c:when test="${anli!=null }">
							<input type="text" style="float: left;" value="${anli.anzhu_birthday}" class="shuru" name="anzhu_birthday"/>
						</c:when>
						<c:otherwise>
							<input type="text" style="float: left;" class="shuru" name="anzhu_birthday"/>
						</c:otherwise>
					</c:choose>
				</div>
				
				<!--end-->
				<!--1-->
				<div style="margin: 30px 0 10px -10px; clear: both;">

					<div class="xia">
						<p class="bba1">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					<c:choose>
						<c:when test="${anli!=null }">
							<input type="text" style="float: left;" class="shuru" value="${anli.anzhu_phoneno }" name="anzhu_phoneno"/>
						</c:when>
						<c:otherwise>
							<input type="text" style="float: left;" class="shuru" name="anzhu_phoneno"/>
						</c:otherwise>
					</c:choose>
					
				</div>
				<!--end-->
			</div>
				<p class="bba">联系人
					<p style="color: red;">*</p>
				</p>
			</div>
			<!--联系人-->
			<div class="zuobian4">
				<!--1-->
				<div style="margin: 10px 0 10px -10px; ">
					<div class="xia">
						<p class="bba1">案主关系
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					<c:choose>
						<c:when test="${anli!=null }">
							<input type="text" style="float: left;" value="${anli.anzhu_guanxi}" class="shuru" name="anzhu_guanxi" />
						</c:when>
						<c:otherwise>
							<input type="text" style="float: left;" class="shuru" name="anzhu_guanxi" />
						</c:otherwise>
					</c:choose>
					
				</div>
				<!--1-->
				<div style="margin: 30px 0 10px -10px; clear: both;">
					<div class="xia">
						<p class="bba1">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					<c:choose>
						<c:when test="${anli!=null }">
							<input type="text" style="float: left;" value="${anli.lianxiren_name }" class="shuru" name="lianxiren_name"/>
						
						</c:when>
						<c:otherwise>
							<input type="text" style="float: left;"  class="shuru" name="lianxiren_name"/>
						</c:otherwise>
					</c:choose>
				</div>
				<!--end-->
				
				<!--1-->
				<div style="margin: 30px 0 10px -10px; clear: both;">

					<div class="xia">
						<p class="bba1">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					<c:choose >
						<c:when test="${anli!=null }">
							<input type="text" style="float: left;" value="${anli.lianxiren_phoneno}" class="shuru" name="lianxiren_phoneno"/>
						</c:when>
						<c:otherwise>
							<input type="text" style="float: left;" class="shuru" name="lianxiren_phoneno"/>
						</c:otherwise>
					</c:choose>
					
				</div>
				<!--end-->
			</div>
			<p class="bba">案主问题概述
				<p style="color: red;">*</p>
			</p>
			<!--案主问题概述-->
			<div class="zuobian2">
				<!--1-->
				<div style="margin: 10px 0 10px -10px; ">
					<div class="xia">
						<p class="bba1">生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;理
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					<c:choose>
						<c:when test="${anli!=null }">
							<textarea style="float: left;" class="shuru1"  name="wenti_shengli">${anli.wenti_shengli}</textarea>
						</c:when>
						<c:otherwise>
							<textarea style="float: left;" class="shuru1" name="wenti_shengli"></textarea>
						</c:otherwise>
					</c:choose>
				</div>

				<!--1-->
				<div style="margin: 30px 0 10px -10px; clear: both;">
					<div class="xia">
						<p class="bba1">心&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;理
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					<c:choose>
						<c:when test="${anli!=null }">
							<textarea style="float: left;" class="shuru1" name="wenti_xinli" >${anli.wenti_xinli}</textarea>
						</c:when>
						<c:otherwise>
							<textarea style="float: left;" class="shuru1" name="wenti_xinli"></textarea>
						</c:otherwise>
					</c:choose>
					
				</div>
				<!--end-->
				<!--1-->
				<div style="margin: 30px 0 10px -10px; clear: both;">
					<div class="xia">
						<p class="bba1">社会环境
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					
					<c:choose>
						<c:when test="${ anli!=null}">
							<textarea style="float: left;" class="shuru1"  name="wenti_shehui">${anli.wenti_shehui}</textarea>
						</c:when>
						<c:otherwise>
							<textarea style="float: left;" class="shuru1"  name="wenti_shehui"></textarea>
						</c:otherwise>
					</c:choose>
					
					
				</div>
				<!--end-->
				<!--1-->
				<div style="margin: 30px 0 10px -10px; clear: both;">
					<div class="xia">
						<p class="bba1">家庭环境
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					
					<c:choose>
						<c:when test="${anli!=null }">
							<textarea style="float: left;" class="shuru1"  name="wenti_jiating">${anli.wenti_jiating}</textarea>
						</c:when>
						<c:otherwise>
							<textarea style="float: left;" class="shuru1" name="wenti_jiating"></textarea>
						</c:otherwise>
					</c:choose>
					
				</div>
				<!--end-->
				<!--1-->
				<div style="margin: 30px 0 10px -10px; clear: both;">
					<div class="xia">
						<p class="bba1">其&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;他
							<p style="color: red;float: left;line-height: 23px;">*</p>
						</p>
					</div>
					
					<c:choose>
						<c:when test="${anli!=null }">
							<textarea style="float: left;" class="shuru1" name="wenti_qita">${anli.wenti_qita}</textarea>
						</c:when>
						<c:otherwise>
							<textarea style="float: left;" class="shuru1" name="wenti_qita"></textarea>
						</c:otherwise>
					</c:choose>
					
				</div>
				<!--end-->
			</div>
			<!--

            	作者：2292281407@qq.com

            	时间：2016-12-06

            	描述：点击不结案后出现一堆的文本框

            -->
            <div id="bja" style="display: none;">
	            <p class="bba" >不结案处理描述
					<p style="color: red;">*</p>
				</p>
			</div>
			<div class="bujiean">
		    	<input type="checkbox" name="chooseFs" style="margin-left: -70px;" value="求助其他机构" id="qiuzhu"/><label for="qiuzhu">求助其他机构</label>
		    	<input type="text"  placeholder="请输入机构名称" disabled="disabled" name="qiuzhu_jigou" style="border:1px solid lightskyblue;margin-left: 5px;margin-top: 20px;height: 20px;width: 40%">
		    	<br><br>
		    	<input type="checkbox" name="chooseFs"  style="margin-left: 12px;" value="转介" id="zhuanjie" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="zhuanjie">转介</label>
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    	<input type="text" placeholder="请输入转介机构名称" disabled="disabled" name="zhuanjie_jigou" style="border:1px solid lightskyblue;margin-left: 5px;height: 20px;width: 40%">
				<textarea style="width: 98%;margin-top: 10px;margin-left: 1%;height: 60%;" name="bujiean_miaoshu" id="bujiean_miaoshu" placeholder="请在此处添加相关的描述"></textarea>
			</div>
			<!-- 用于展示数据 -->
			<c:if test="${anli!=null and anli.state=='8'}">
				<div id="bja" style="display: block;">
		            <p class="bba" >不结案处理描述
						<p style="color: red;">*</p>
					</p>
				</div>
				<div class="bujiean" style="display: block;">
			    	<input type="checkbox" name="chooseFs" checked="checked" style="margin-left: -70px;" value="求助其他机构" id="qiuzhu"/><label for="qiuzhu">求助其他机构</label>
			    	<input type="text"  placeholder="请输入机构名称" value="${anli.qiuzhu_jigou }" name="qiuzhu_jigou" style="border:1px solid lightskyblue;margin-left: 5px;margin-top: 20px;height: 20px;width: 40%">
			    	<br><br>
			    	<input type="checkbox" name="chooseFs" checked="checked"  style="margin-left: 12px;" value="转介" id="zhuanjie" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="zhuanjie">转介</label>
			    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	<input type="text" placeholder="请输入转介机构名称" value="${anli.zhuanjie_jigou }" name="zhuanjie_jigou" style="border:1px solid lightskyblue;margin-left: 5px;height: 20px;width: 40%">
					<textarea style="width: 98%;margin-top: 10px;margin-left: 1%;height: 60%;" name="bujiean_miaoshu"  placeholder="请在此处添加相关的描述">${anli.bujiean_miaoshu}</textarea>
				</div>
			</c:if>
			<div class="btn-zu">
				 <c:choose>
					<c:when test="${anli!=null}">
						<c:choose>
							<c:when test="${session_anli!=null and  session_anli.state==1}">
								<button type="button" style="margin-left: 40%;" id="updateBtn">保存</button>
								<button type="button" id="updateAndStep">保存并下一步</button>
							</c:when>
							<c:otherwise>
								<button type="button" style="margin-left: 80%;" id="updateBtn">保存</button>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<button type="button" style="margin-left: 40%;" id="bujieanBtn">不接案</button>
						<button type="button" id="saveBtn">保存</button>
						<button type="button" id="saveAndStepBtn">保存并下一步</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<!--右边提示部分-->
		<div class="youbian">
			<p class="tishi">!!提示</p>
			<div class="row" id="row">
				<ul style="margin-left: 5%;">
					<li>SOLER</li>
					<li>鼓励</li>
					<li>转移话题</li>
				</ul>
				<ul>
					<li onclick="tiaozhuan()">倾听</li>
					<li>询问</li>
					<li>关系技巧</li>
				</ul>
				<ul>
					<li>澄清</li>
					<li>自我表达</li>
					<li>环境设置</li>
				</ul>
			</div>
			<div class="shuoming" id="qingting">
				<p>
					倾听 <br/>（1）接收信息 <br/>•倾听话语信息，分辨叙述中的经验、行为和情感 •观察身体语言信息 <br/>（2）加工信息 <br/>•解读案主的生活、行动及与其问题相关内容 <br/>（3）传递信息 •在求助者反复强调的信息中归纳出主题并聚焦于此。
				</p>
				<button style="background: #3e97c9;position: absolute;right: 5%;top: 250px;border: none;color: #FFFFFF;" onclick="fanhui()">返回</button>
			</div>
		</div>
		<!-- 用于存放 -->
		<input type="hidden" id="userid" name="fk_userid"/>
		<input type="hidden" id="username" name="fk_username"/>
		<input type="hidden" id="anli_date" name="anli_date"/>
		<!-- 编写和查看两种 -->
		<c:choose>
			<c:when test="${anli!=null}">
				<input type="hidden" id="anli_state" value="${anli.state}" name="state">
			</c:when>
			<c:otherwise>
				<input type="hidden" id="anli_state" value="1" name="state">
			</c:otherwise>
		</c:choose>
		
		<input type="hidden" id="anli_id" value="${anli.anli_id}" name="anli_id">
			
		<!-- 标示是点击了保存还是点击了保存并且下一步，默认是点击保寸-->
		<input type="hidden" id="isJump" name="isJump" value="0"/>
		
		<!-- 表示点击了下一步之前是否点击了保存 ,默认是没有点击-->
		<input type="hidden" id="markClickSaveBtn" value="0" />
		</div>
		</form>
	<script>
		//填写默认的日期
		var date=new Date();
		var year=date.getFullYear();
		var month=parseInt(date.getMonth())+1;
		var day=date.getDate();
		$(".shuru").eq(2).val(year+"-"+month+"-"+day);
		$(".shuru").eq(3).val("<%=((Map)session.getAttribute("userMap")).get("loginname")%>");
		//填充数据表单
		$("#userid").val("<%=((Map)session.getAttribute("userMap")).get("userid")%>");
		//alert($("#userid").val())
		$("#username").val("<%=((Map)session.getAttribute("userMap")).get("loginname")%>");
		$("#anli_date").val(year+"-"+month+"-"+day);
	</script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/anlibianxie.js"></script>
	</body>
	<%
		//清空session中的数据
		if(session.getAttribute("anli")!=null){
			session.removeAttribute("anli");
		}
	%>
</html>