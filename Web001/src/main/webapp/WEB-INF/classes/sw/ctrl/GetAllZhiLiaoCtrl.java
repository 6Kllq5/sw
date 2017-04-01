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

import sw.service.GetAllZhiKLiaoService;
import sw.service.GetAnLiService;
@Controller
@RequestMapping("getAllZhiLiaoCtrl")
public class GetAllZhiLiaoCtrl {
	@Resource(name="getAllZhiKLiaoService")
	private GetAllZhiKLiaoService getAllZhiKLiaoService;
	public void setGetAllZhiKLiaoService(GetAllZhiKLiaoService getAllZhiKLiaoService) {
		this.getAllZhiKLiaoService = getAllZhiKLiaoService;
	}
	@Resource(name="getAnLiService")
	private GetAnLiService anLiService;
	public void setAnLiService(GetAnLiService anLiService) {
		this.anLiService = anLiService;
	}
	@RequestMapping(value="getAllZhiLiao")
	public ModelAndView getAllZhiLiao(HttpServletRequest req,HttpSession session){
		ModelAndView mv=new ModelAndView();
		String fk_userid=req.getParameter("fk_userid");
		String anli_id=req.getParameter("anli_id");
		String markBTStep =req.getParameter("markBTStep");
		Map paramMap=new HashMap();
		paramMap.put("fk_userid", fk_userid);
		paramMap.put("fk_anli_id", anli_id);
		paramMap.put("anli_id", anli_id);
		List resultList=new ArrayList<>();
		List resultList2=new ArrayList<>();
		try {
			resultList=getAllZhiKLiaoService.excuteGetAllZhiKLiaoService(paramMap);
			resultList2=anLiService.excuteGetAnLi(paramMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(resultList!=null){
			session.setAttribute("list", resultList);
		}
		
		
		session.setAttribute("session_anli", resultList2.get(0));
		if(markBTStep==null){
			mv.setViewName("right3");
		}else {
			mv.setViewName("soujiziliao");
		}
		return mv;
	}
	
}
