package sw.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sw.service.GetAllZhiLiaoService;
import sw.service.GetAnLiService;
import swutil.RequestTool;
@Controller
@RequestMapping("getAllZhiLiaoCtrl")
public class GetAllZhiLiaoCtrl {
	@Resource(name="getAllZhiLiaoService")
	private GetAllZhiLiaoService getAllZhiLiaoService;
	public void setGetAllZhiKLiaoService(GetAllZhiLiaoService getAllZhiLiaoService) {
		this.getAllZhiLiaoService = getAllZhiLiaoService;
	}
	@ResponseBody
	@RequestMapping(value="getAllZhiLiao")
	public Map getAllZhiLiao(HttpServletRequest req,HttpSession session){
		Map paraMap=new HashMap();
		Map resultMap=new HashMap();
		List resutList=new ArrayList<>();
		paraMap=RequestTool.getParameterMap(req);
		try {
			resutList=getAllZhiLiaoService.excuteGetAllZhiLiaoService(paraMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMap.put("ziliao", resultMap);
		return resultMap;
	}
}
