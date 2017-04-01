package sw.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@ResponseBody
	@RequestMapping("/addEvent")
	public Map addEvent(HttpServletRequest req){
		Map resultMap=new HashMap();
		String shijian_id=UUIDUtil.getRandom();
		String title=req.getParameter("shijian_biaoti");
		String startDay=req.getParameter("shijian_sdate");
		String endDay=req.getParameter("shijian_edate");
		String week=req.getParameter("shijian_xinqi");
		String startTime=req.getParameter("shijian_stime");
		String endTime=req.getParameter("shijian_etime");
		String anli_id=req.getParameter("anli_id");
		
		Map userMap= (Map) req.getSession().getAttribute("userMap");
		String userid=(String) userMap.get("userid");
	
		Map paramMap=new HashMap();
		paramMap.put("shijian_id", shijian_id);
		paramMap.put("shijian_biaoti", title);
		paramMap.put("shijian_xinqi",week);
		paramMap.put("shijian_sdate", startDay);
		paramMap.put("shijian_edate", endDay);
		paramMap.put("shijian_stime", startTime);
		paramMap.put("shijian_etime", endTime);
		paramMap.put("fk_userid", userid);
		paramMap.put("fk_anli_id", anli_id);
		int resultInt=0;
		try {
			resultInt=addEventService.excuteAddEvent(paramMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMap.put("addEvent", resultInt);
		return resultMap;
	}
}
