package sw.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sw.ctrl.ctrl_interface.CtrlFun;
import sw.service.PingGuService;
import swutil.RequestTool;
import swutil.UUIDUtil;

@Controller
@RequestMapping("PingGuCtrl")
public class PingGuCtrl implements CtrlFun{
	@Resource(name="PingGuService")
	private PingGuService pingGuService;
	public void setPingGuService(PingGuService pingGuService) {
		this.pingGuService = pingGuService;
	}
	@RequestMapping(value="pingGuCtrl")
	@ResponseBody
	public Map pingGuCtrl(HttpServletRequest request){
		Map resultMap=new HashMap();
		Map paraMap=new HashMap();
		paraMap=RequestTool.getParameterMap(request);
		String method=paraMap.get("method").toString();
		if(method.equals("select")){
			resultMap=selectOne_C(paraMap);
		}else if(method.equals("add")){
			String pinggu_id=UUIDUtil.getRandom().toString();
			paraMap.put("pinggu_id", pinggu_id);
			resultMap=addOne_C(paraMap);
		}else if(method.equals("update")){
			resultMap=updateOne_C(paraMap);
		}
		return resultMap;
	}
	
	@Override
	public Map selectOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		Map temp=new HashMap();
		try {
			temp=pingGuService.executSelectOne_S(paraMap);
			if(temp.size()>0){
				resultMap.put("data", temp);
				resultMap.put("statu", 1);
				resultMap.put("message", "查询成功");
			}else{
				resultMap.put("data", null);
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
		Map resultMap=new HashMap();
		int resultInt=0;
		try {
			resultInt=pingGuService.executUpdateOne_S(paraMap);
			
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
		Map resultMap=new HashMap();
		int resultInt=0;
		try {
			resultInt=pingGuService.executAddOne_S(paraMap);
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

}
