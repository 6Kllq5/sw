package sw.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sw.service.AddEventService;
import swutil.UUIDUtil;
@Controller
@RequestMapping("addEventCtrl")
public class AddEventCtrl {
	@Resource(name="addEventService")
	private AddEventService addEventService;
	
	public void setAddEventService(AddEventService addEventService) {
		this.addEventService = addEventService;
	}

	@RequestMapping("/addEvent")
	public ModelAndView addEvent(HttpServletRequest req){
		ModelAndView mv=new ModelAndView();
		
		String shijian_id=UUIDUtil.getRandom();
		
		String title=req.getParameter("title");
		String startDay=req.getParameter("startDay");
		String endDay=req.getParameter("endDay");
		String week=req.getParameter("week");
		String startTime=req.getParameter("startTime");
		String endTime=req.getParameter("endTime");
		
		String fkuserid=req.getParameter("userid");
		
		Map paramMap=new HashMap();
		paramMap.put("shijian_id", shijian_id);
		paramMap.put("shijian_biaoti", title);
		paramMap.put("shijian_xinqi",week);
		paramMap.put("shijian_sdate", startDay);
		paramMap.put("shijian_edate", endDay);
		paramMap.put("shijian_stime", startTime);
		paramMap.put("shijian_etime", endTime);
		paramMap.put("fkuserid", fkuserid);
		paramMap.put("fk_anli_id", 1);
		
		try {
			addEventService.excuteAddEvent(paramMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
}
