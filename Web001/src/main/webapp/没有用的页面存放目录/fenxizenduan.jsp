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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/fenxizenduan.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/reset.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/anlibianxie.css" />

		<link rel="stylesheet" href="<%=request.getContextPath() %>/kindeditor-v4.1.7/kindeditor-4.1.7/themes/default/default.css" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/kindeditor-v4.1.7/kindeditor-4.1.7/plugins/code/prettify.css" />
		<script charset="utf-8" src="<%=request.getContextPath() %>/kindeditor-v4.1.7/kindeditor-4.1.7/kindeditor.js"></script>

		<script charset="utf-8" src="<%=request.getContextPath() %>/My97DatePicker/lang/zh-cn.js"></script>
		<script charset="utf-8" src="<%=request.getContextPath() %>/kindeditor-v4.1.7/kindeditor-4.1.7/plugins/code/prettify.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/fullcalendar-3.0.1/lib/jquery.min.js" ></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.1.1.min.js" ></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-form.js" ></script>
		<script>
			KindEditor.ready(function(K) {
				//用于异步上传文件
				var editor1 = K.create('textarea[name="content1"]', {
					cssPath: '<%=request.getContextPath() %>/kindeditor-v4.1.7/kindeditor-4.1.7/plugins/code/prettify.css',
					resizeType: 0,
					//				uploadJson : '../jsp/upload_json.jsp',
					//				fileManagerJson : '../jsp/file_manager_json.jsp',
					allowFileManager: true,
					afterCreate: function() {
						var self = this;
						K.ctrl(document, 13, function() {
							self.sync();
							document.forms['example'].submit();
						});
						K.ctrl(self.edit.doc, 13, function() {
							self.sync();
							document.forms['example'].submit();
						});
					}
				});
				prettyPrint();
			});
		</script>
		<title>分析诊断</title>
	</head>
	<body>
		<p class="huanyingyu">Hi,<b style="color: red;">admin</b>,欢迎进行分析诊断</p>
		<div class="fenxi">
			<div class="zhongjian">
				<div class="rows1">
					<p>临床评估*</p>
					<p>调查问卷*</p>
					<p>沟通模式*</p>
				</div>

				<div class="rows2">
					<div class="col1">
					<div class="tishixinxi" id="tishiyi">
						<p>1、心理社会评估模式</p>
						<p>理论基础：</p>
						<p>倡导以“人在环境中”的观点来看人的功能，强调个体内在心理、人际与环境等因素的交互影响</p>
						<p>评估技巧：</p>
						<p>（1）案主的问题是来自于所承受的压力吗？</p>
						<p>（2）有其他长期未解决的问题 吗？</p>
						<p>（3）案主有自我功能上的问题吗？</p>
						<p>（4）缺乏环境的支持吗？</p>
						<p>（5）案主拥有多少环境支持以及自我能力的情形？</p>
					</div>
					<div class="tishixinxi" id="tishiyi1">
						<p>2、问题解决模式</p>
						<p>理论基础：</p>
						<p>源自自我心理学、角色理论、符号互动理论以及理性问题解决过程，强调个体潜能的成长与机构功能的发挥</p>
						<p>评估技巧：</p>
						<p>（1）珀尔曼的4P评估：person、problem、place、process（整合式的问题评估架构）。</p>
						<p>（2）德利默斯（Doremus）的4R评估：roles、reactions、relationships、resources（就案主的个别状况进行评估）</p>
						<p>（3）谢弗（Sheafor）等人的4M评估：motivation、meanings、management、monitoring，乃是就机构的功能进行评估</p>

					</div>
					<div class="tishixinxi" id="tishiyi2">
						<p>3、行为评估模式</p>
						<p>理论基础：</p>
						<p>采自行为心理学，认为行为是学习来的</p>
						<p>评估技巧：</p>
						<p>有量化测量特点，分9个评估步骤：</p>
						<p>（1）将问题一一列出；</p>
						<p>（2）标定主要问题并签订同意接受服务的契约；</p>
						<p>（3）获得案主的承诺与合作；</p>
						<p>（4）详述目标行为；</p>
						<p>（5）设定目标行为的基准线；</p>
						<p>（6）界定可能控制的条件；</p>
						<p>（7）评估环境资源；</p>
						<p>（8）详述行为目标；</p>
						<p>（9）形成行为修正的计划</p>
					</div>
					<div class="tishixinxi" id="tishiyi3">
						<p>4、任务中心评估模式</p>
						<p>理论基础：</p>
						<p>源自不同的理论与技术取向，整合了行为认知、学习理论、家族治疗等理论派别的理论预设与治疗技术。着重于指导性以及协助性的角色，协助案主厘清问题并拟定改变方向，重视治疗关系，并将案主视为是有解决问题能力的人</p>
						<p>评估技巧：</p>
						<p>评估目的在于界定所存在的问题，及其所想达到的改善结果，包括：</p>
						<p>（1）了解案主对于问题的感受及看法；</p>
						<p>（2）社工借由探索、澄清、界定问题来协助案主厘清其所遭遇的问题</p>

					</div>
					<div class="tishixinxi" id="tishiyi4">
						<p>5、生活模式的评估系统</p>
						<p>理论基础：</p>
						<p>整合了一般系统理论、生态学观点、增权等理论来源，建构了综合性的生态系统观点</p>
						<p>评估技巧：</p>
						<p>（1）人格特质；</p>
						<p>（2）微观系统；</p>
						<p>（3）中层系统；</p>
						<p>（4）宏观系统</p>
					</div>
					<div class="tishixinxi" id="tishiyi5">
						<p>6、家庭结构评估模式</p>
						<p>理论基础：</p>
						<p>理论焦点在于家庭的结构，包括家庭行为模式、家庭系统与次系统、家庭生活循环</p>
						<p>评估技巧：</p>
						<p>（1）谁是家庭中的主事者？</p>
						<p>（2）家庭成员是如何处理其冲突的？</p>
						<p>（3）在家庭中是否有被谴责的“已被认定的病人”？</p>
						<p>（4）画出家庭的世代图有助于对案主在家庭世代中所处脉络的了解</p>

					</div>
					<div class="tishixinxi" id="tishiyi6">
						<p>7、多重评估模式</p>
						<p>理论基础：</p>
						<p>拉扎勒斯根据班杜拉的社会学习理论、一般系统理论、团体及沟通理论等发展出来的一套完整的理论。它是一种非常个人化的治疗，根据每个人的个别性而采取不同的介入方法</p>
						<p>评估技巧：</p>
						<p>B:行为（behavior）</p>
						<p>A:情感（affect）</p>
						<p>S:知觉（sensation）</p>
						<p>C:认知（cognition）</p>
						<p>I:人际关系（interpersonal relationships）</p>
						<p> D:药物与生理因素（drugs/biology） </p>
					</div>
					<div class="tishixinxi" id="tishiyi7">
						<p>8、综融式评估模式</p>
						<p>理论基础：</p>
						<p>受系统理论、问题解决派社会工作理论的影响。采纳的是系统观或者环境中的人这一观点，倡导综合管理</p>
						<p>评估技巧：</p>
						<p>（1）基本资料；</p>
						<p>（2）目前问题的本质；</p>
						<p>（3）案主（包括案主自身、家庭、学校/工作单位、朋友/同僚/同学）；</p>
						<p>（4）脉络与社会支持网络；</p>
						<p>（5）心理测量或评估量表；</p>
						<p>（6）摘要</p>
					</div>
						<form method="post">
							<input type="checkbox"  id="ms0" value="0" name="ms"/><label for="ms0" >心理社会评估模式</label><img src="<%=request.getContextPath() %>/img/icon_tshi.png" style="width: 25px;height: 25px;float: right;position: relative;left: -25px;top: -3px;" onmouseover="xianshi()" onmouseout="likai()" />
						</form>
						<form method="post">
							<input type="checkbox" id="ms1" value="1" name="ms"/><label for="ms1">问题解决模式</label><img src="<%=request.getContextPath() %>/img/icon_tshi.png" style="width: 25px;height: 25px;float: right;position: relative;left: -25px;top: -3px;" onmouseover="xianshi1()" onmouseout="likai1()" />
						</form>
						
						<form method="post">
							<input type="checkbox" id="ms2" value="2" name="ms"/><label for="ms2">行为评估模式</label><img src="<%=request.getContextPath() %>/img/icon_tshi.png" style="width: 25px;height: 25px;float: right;position: relative;left: -25px;top: -3px;" onmouseover="xianshi2()" onmouseout="likai2()" />
						</form>
						
						<form method="post">
							<input type="checkbox" id="ms3" value="3" name="ms"/><label for="ms3">任务中心评估模式</label><img src="<%=request.getContextPath() %>/img/icon_tshi.png" style="width: 25px;height: 25px;float: right;position: relative;left: -25px;top: -3px;" onmouseover="xianshi3()" onmouseout="likai3()" />
						</form>
						<form method="post">

							<input type="checkbox" id="ms4" value="4" name="ms"/><label for="ms4">生活模式的评估系统</label><img src="<%=request.getContextPath() %>/img/icon_tshi.png" style="width: 25px;height: 25px;float: right;position: relative;left: -25px;top: -3px;" onmouseover="xianshi4()" onmouseout="likai4()" />
						</form>
						<form method="post">

							<input type="checkbox" id="ms5" value="5" name="ms"/><label for="ms5">家庭结构评估模式</label><img src="<%=request.getContextPath() %>/img/icon_tshi.png" style="width: 25px;height: 25px;float: right;position: relative;left: -25px;top: -3px;" onmouseover="xianshi5()" onmouseout="likai5()" />
						</form>
						<form method="post">

							<input type="checkbox" id="ms6" value="6" name="ms"/><label for="ms6">多重评估模式</label><img src="<%=request.getContextPath() %>/img/icon_tshi.png" style="width: 25px;height: 25px;float: right;position: relative;left: -25px;top: -3px;" onmouseover="xianshi6()" onmouseout="likai6()" />
						</form>
						<form method="post">

							<input type="checkbox" id="ms7" value="7" name="ms"/><label for="ms7">综融式评估模式</label><img src="<%=request.getContextPath() %>/img/icon_tshi.png" style="width: 25px;height: 25px;float: right;position: relative;left: -25px;top: -3px;" onmouseover="xianshi7()" onmouseout="likai7()" />
						</form>

					</div>

					<div class="col2">
						<div class="qishi">
							<div class="every">
								
							<label  style="width: 70px;height: auto;text-align: left;display: block;float: left;">情续等级</label>
							<select style="width: 50px;display: block;float: left;height: auto;float: left;">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
							</select>
							</div>
						</div>
						<p id="add" style="text-align: center;font-weight: bold;font-size: 18px;" onmouseover="$(this).css('cursor','pointer')">+</p>
					</div>
					
					<div class="col2">
						<div class="qishi">
							<label>选择类型</label>
							<select style="width: 100px;margin: 0 5px;" id="gtms">
								<option value="0">责备型</option>
								<option value="1">讨好型</option>
								<option value="2">打岔型</option>
								<option value="3">超理智型</option>
							</select>
						</div>
						<div style="margin-top: 5px;" >
							<form method="post" style="margin-top:10px;" id="tijiaoBD" enctype="multipart/form-data">
								<img alt="图片无法加载" src="">
								<input type="checkbox"  class="jgms" /><label>家庭结构图</label><input type="file" name="files" disabled="disabled"/>
								
								<img alt="图片无法加载" src="">
								<input type="checkbox" class="jgms" /><label>生态结构图</label><input type="file" name="files" disabled="disabled"/>

								<img alt="图片无法加载" src="">
								<input type="checkbox" class="jgms" /><label>社会网络图</label><input type="file" name="files" disabled="disabled"/>
								
								<!-- 用于存放的是评估 -->
								<input type="hidden" value="" id="pingguRQ" name="linchuang_pinggu"/>	
								<!-- 用于存放沟通模式 -->
								<input type="hidden" value="" id="moshiRQ" name="goutong_moshi"/>
								<!-- 获取下面那个文本框的数据 -->
								<input type="hidden" value="" id="wenbenRQ" name="diaocha_miaoshu"/>
								<!-- 用于存放调查问卷--存放拼接得到代码片段 -->
								<input type="hidden" id="dcwj" name="diaocha_wenjuan"/>
								<input type="hidden" name="fk_userid" value="${userMap['userid']} "/>
								
								<input type="hidden" id="fk_anli_id" name="fk_anli_id"/>
								
								<!-- 用于标示是否在点击保存并且下一步的时候已经点击了保存 ,默认是没有点击-->
								<input type="hidden" id="markClickSaveBtn" value="0" />
								<c:choose>
									<c:when test="${session_anli!=null and  session_anli!=null }">
										<input type="hidden" id="anli_state" name="state" value="${session_anli.state}"/>
									</c:when>
									<c:otherwise>
										<input type="hidden" id="anli_state" name="state" value="3"/>
									</c:otherwise>
								</c:choose>
								
 							</form>
						</div>
					</div>
				</div>
			</div>
			<!--kindEdit-->
			<form name="example" method="post" style="margin-top: 20px;">
				<c:choose>
					<c:when test="${fenxi!=null }">
						<textarea name="content1" cols="100" rows="8" style="width:97%;height:200px;">${fenxi.diaocha_miaoshu}</textarea>
					</c:when>
					<c:otherwise>
						<textarea name="content1" cols="100" rows="8" style="width:97%;height:200px;"></textarea>
					</c:otherwise>
				</c:choose>
			</form>
		</div>
		<div class="anniu">
			<c:choose>
				<c:when test="${fenxi!=null }">
					<c:choose>
						<c:when test="${session_anli.state!=3}">
							<button type="button" id="update" style="margin-bottom: 30px">保存</button>
						</c:when>
						<c:otherwise>
							<button type="button" id="update" style="margin-bottom: 30px">保存</button>
							<button type="button" id="updateAndStep" style="margin-bottom: 30px">制定计划</button>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
						<button type="button" id="save"  style="margin-bottom: 30px">保存</button>
						<button type="button" id="saveAndStep"  style="margin-bottom: 30px">制定计划</button>
				</c:otherwise>
			</c:choose>
		</div>
		<!--右边提示部分-->
		<div class="youbian">
			<p class="tishi">!!提示</p>
		</div>
		<div id="xuantian">
			<form method="post" style="margin-top: 10px;">

				<label>名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称</label>
				<input type="text" style="width: 120px;margin: 10px ;" maxlength="5" placeholder="长度不能超过5" id="biaoname"/>
			</form>
			<form method="post" style="margin-top: 10px;">

				<label>最低级别</label>
				<input type="text" style="width: 120px;margin: 8px ;"placeholder="填写最低级别" id="zddj"/>

			</form>
			<form method="post" style="margin-top: 10px;">

				<label >最高级别</label>
				<input type="text" style="width: 120px;margin: 8px ;" placeholder="填写最高级别" id="zgdj"/>

			</form>
			
			<div class="button">
				<button type="button">确定</button>
				<button type="button">取消</button>
			</div>
		</div>
		<div class="zz" id="zz">
		</div>
		<!-- 加载页面初始化数据 -->
		<script type="text/javascript">
			//加载页面拼装数据
			$(function(){
				if(typeof(fenxiREsult)!=undefined){
					var linchuang_pinggu='${fenxi.linchuang_pinggu}';
					alert(linchuang_pinggu)
					var linchuang_pinggu_array=linchuang_pinggu.split("");//获取数组其中内容为下标
					var diaocha_wenjuan='${fenxi.diaocha_wenjuan}';
					var diaocha_wenjuan_array=diaocha_wenjuan.split(",");//获取option数组
					var goutong_moshi='${fenxi.goutong_moshi}';
					//三张图片的链接
					var jiating_tupian_lianjie='${fenxi.jiating_tupian_lianjie}';
					var shengtai_tupian_lianjie='${fenxi.shengtai_tupian_lianjie}';
					var shehui_tupian_lianjie='${fenxi.shehui_tupian_lianjie}';
					//调查描述
					var diaocha_miaoshu="${fenxi.diaocha_miaoshu}";
					//进行拼装数据
					for (i=0;i<linchuang_pinggu_array.length;i++){
						
						var index =parseInt(linchuang_pinggu_array[i]);
						$("input[name='ms']").eq(index).attr("checked","checked");
					}
					
					for (i=0;i<diaocha_wenjuan_array.length-1;i++){
						optionStr=diaocha_wenjuan_array[i];
						tempop=diaocha_wenjuan_array[i].split("-");
						$(".col2").eq(0).children(".qishi").append('<div class="every">'+
							'<label  style="width: 70px;height: auto;text-align: left;display: block;float: left;">'+
							tempop[0]+
							'</label>'+
							'<select style="width: 50px;display: block;float: left;height: auto;float: left;">'+
							tempop[1]+
							'</select>'+
							'<p style="width: 10px;height: 20px;text-align: center;line-height: 20px;font-weight: bold;float: left;font-size: 25px;margin-left: 15px;" onmouseover="$(this).css('+'"cursor","pointer")'+'">-</p>'+
							'</div>'
						);
					}
					$("#gtms").children("option").eq(parseInt(goutong_moshi)).attr("selected","selected")
				}
			})
		</script>
		<script src="<%=request.getContextPath()%>/js/fenxizhenduan.js"></script>
		<%
			//加载完数据之后清空session中的数据
			if(session.getAttribute("fenxi")!=null){
				session.removeAttribute("fenxi");
			}
		%>
	</body>
</html>