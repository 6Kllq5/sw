package sw.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sw.ctrl.ctrl_interface.CtrlFun;
import sw.service.FenXiService;
import swutil.RequestTool;

public class FenXiCtrl implements CtrlFun{
	@Resource(name="FenXiService")
	private FenXiService fenXiService;
	public void setFenXiService(FenXiService fenXiService) {
		this.fenXiService = fenXiService;
	}
	
	@RequestMapping(value="fenXiCtrl")
	@ResponseBody
	public Map fenXiCtrl(HttpServletRequest request){
		Map paraMap = new HashMap();
		Map resultMap=new HashMap();
		paraMap=RequestTool.getParameterMap(request);
		String method=(String) paraMap.get("method");
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
	
	
	
	
	
}
