package sw.ctrl;

import java.util.HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
//这个是日程时间
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sw.ctrl.ctrl_interface.TableCtrlFun;
import sw.service.DateEventService;
import swutil.RequestTool;
import swutil.UUIDUtil;

@Controller
@RequestMapping("DateEventCtrl")
public class DateEventCtrl implements TableCtrlFun{
	@Resource(name="DateEventService")
	private DateEventService dateEventService;
	public void setDateEventService(DateEventService dateEventService) {
		this.dateEventService = dateEventService;
	}

	@RequestMapping("dateEventCtrl")
	@ResponseBody
	public Map dateEventCtrl(HttpServletRequest request){
		Map resultMap=new HashMap();
		Map paraMap=new HashMap();
		paraMap=RequestTool.getParameterMap(request);
		String method=resultMap.get("method").toString();
		if(method.equals("select")){
			resultMap=selectAll_C(paraMap);
		}else if(method.equals("add")){
			String shijian_id=UUIDUtil.getRandom().toString();
			paraMap.put("shijian_id", shijian_id);
			resultMap=addOne_C(paraMap);
		}else if(method.equals("update")){
			resultMap=updateOne_C(paraMap);
		}else if(method.equals("delete")){
			resultMap=deleteOne_C(paraMap);
		}
		return resultMap;
		
	}
	
	@Override
	public Map selectOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map updateOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map addOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		return null;
	}
	//查询所有的事件
	@Override
	public Map selectAll_C(Map paraMap) {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		List tempList=new ArrayList();
		try {
			tempList=dateEventService.executSelectAll_S(paraMap);
			resultMap.put("data", tempList);
			resultMap.put("statu", 1);
			resultMap.put("message", "查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public Map deleteBunch_C(List paraList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map deleteOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		return null;
	}
}
