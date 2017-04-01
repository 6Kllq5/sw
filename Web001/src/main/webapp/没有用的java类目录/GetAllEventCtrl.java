package sw.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sw.service.GetAllEventService;
import swutil.RequestTool;
import swutil.TurnPage;

@Controller 
@RequestMapping(value="getAllEventCtrl")
public class GetAllEventCtrl {
	@Resource(name="getAllEventService")
	private GetAllEventService getAllEventService;

	public void setGetAllEventService(GetAllEventService getAllEventService) {
		this.getAllEventService = getAllEventService;
	}
	@RequestMapping(value="getAllEvent")
	@ResponseBody  //处理ajax数据并返回json数据,要求返回json数据格式
	public List getAllEvent(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		String fk_userid=request.getParameter("fk_userid");
		Map paramMap=new HashMap();
		paramMap.put("fk_userid", fk_userid);
		List resultList=null;
		try {
			resultList=getAllEventService.excuteGetAllEvent(paramMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}
}
