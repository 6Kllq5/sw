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
import org.springframework.web.servlet.ModelAndView;

import sw.service.GetAnLiService;
import sw.service.GetPingGuService;

@Controller
@RequestMapping("getPingGuCtrl")
public class GetPingGuCtrl {
	@Resource(name="getPingGuService")
	private GetPingGuService getPingGuService;
	public void setGetPingGuService(GetPingGuService getPingGuService) {
		this.getPingGuService = getPingGuService;
	}
	
	@Resource(name="getAnLiService")
	private GetAnLiService anLiService;
	public void setAnLiService(GetAnLiService anLiService) {
		this.anLiService = anLiService;
	}
	@RequestMapping("getPingGu")
	public ModelAndView getPingGu (HttpServletRequest req,HttpSession session){
		ModelAndView mv=new ModelAndView();
		String fk_userid=req.getParameter("fk_userid");
		String anli_id=req.getParameter("anli_id");
		Map paramMap=new HashMap<>();
		List resultList=new ArrayList();
		List resultList2=new ArrayList();
		paramMap.put("fk_userid", fk_userid);
		paramMap.put("fk_anli_id", anli_id);
		paramMap.put("anli_id", anli_id);
		String markBTStep=req.getParameter("markBTStep");
		try {
			resultList=getPingGuService.excuteGetPingGu(paramMap);
			resultList2=anLiService.excuteGetAnLi(paramMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("session_anli", resultList2.get(0));
		
		if(resultList!=null){
			session.setAttribute("pinggu", resultList.get(0));
		}else{
			session.setAttribute("pinggu", null);
		}
		if(markBTStep==null){
			mv.setViewName("right3");
		}else {
			mv.setViewName("jieanpinggu");
		}
		return mv;
		
	}
	
	
}
