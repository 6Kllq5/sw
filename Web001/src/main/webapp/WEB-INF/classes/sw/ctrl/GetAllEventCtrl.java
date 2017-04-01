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
	public ModelAndView getAllEvent(@ModelAttribute("turnPage") TurnPage turnPage,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		
		Map paraMap=RequestTool.getParameterMap(request);

		paraMap.put("turnPage", turnPage);
		try {
			Map resultMap=getAllEventService.excuteGetAllEvent(paraMap);
			List list=(List)resultMap.get("list");
			mv.addObject("list", list);
			mv.addObject("turnPage", turnPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("right2");
		return mv;
	}
}
