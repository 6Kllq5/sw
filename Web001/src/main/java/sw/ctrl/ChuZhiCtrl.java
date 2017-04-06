package sw.ctrl;

import java.util.HashMap;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sw.ctrl.ctrl_interface.CtrlFun;
import sw.service.ChuZhiService;
import swutil.RequestTool;
import swutil.UUIDUtil;
@Controller
@RequestMapping("ChuZhiCtrl")
public class ChuZhiCtrl implements CtrlFun{
	@Resource(name="ChuZhiService")
	private ChuZhiService chuZhiService;
	
	public void setChuZhiService(ChuZhiService chuZhiService) {
		this.chuZhiService = chuZhiService;
	}

	@RequestMapping("chuZhiCtrl")
	@ResponseBody
	public Map ChuZhiCtrl(HttpServletRequest request){
		Map resultMap=new HashMap();
		Map paraMap=new HashMap();
		paraMap=RequestTool.getParameterMap(request);
		String method=(String) paraMap.get("method");
		if(method.equals("select")){
			resultMap=selectOne_C(paraMap);
		}else if(method.equals("add")){
			String chuzhi_id=UUIDUtil.getRandom().toString();
			paraMap.put("chuzhi_id", chuzhi_id);
			resultMap=addOne_C(paraMap);
		}else if(method.equals("update")){
			resultMap=updateOne_C(paraMap);
		}
		return resultMap;
	}
	
	@Override
	public Map selectOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		Map resultMap =new HashMap(); 
		Map tempMap=new HashMap();
		try {
			tempMap=chuZhiService.executSelectOne_S(paraMap);
			if(tempMap==null)
			{
				resultMap.put("data",null);
				resultMap.put("statu", 0);
				resultMap.put("message", "查询失败");
				return resultMap;
			}
			if(tempMap.size()>0){
				resultMap.put("data",tempMap);
				resultMap.put("statu", 1);
				resultMap.put("message", "查询成功");
			}else{
				resultMap.put("data",null);
				resultMap.put("statu", 0);
				resultMap.put("message", "查询失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public Map updateOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		Map resultMap =new HashMap();
		int resultInt=0;
		try {
			resultInt=chuZhiService.executUpdateOne_S(paraMap);
			if(resultInt==0){
				resultMap.put("statu", 0);
				resultMap.put("message", "更新失败");
			}else{
				resultMap.put("statu", 1);
				resultMap.put("message", "更新成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
	
	@Override
	public Map addOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		Map resultMap =new HashMap();
		int resultInt=0;
		try {
			resultInt=chuZhiService.executAddOne_S(paraMap);
			if(resultInt==0){
				resultMap.put("statu", 0);
				resultMap.put("message", "添加失败");
			}else{
				resultMap.put("statu", 1);
				resultMap.put("message", "添加成功");
				resultMap.put("chuzhi_id", paraMap.get("chuzhi_id"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}

}
