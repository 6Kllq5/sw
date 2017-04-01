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
@Controller
@RequestMapping("getAnLiCtrl")
public class GetAnLiCtrl {
	@Resource(name="getAnLiService")
	private GetAnLiService anLiService;
	public void setAnLiService(GetAnLiService anLiService) {
		this.anLiService = anLiService;
	}
	@RequestMapping("getAnLi")
	public ModelAndView getAnLi(HttpServletRequest req,HttpSession session){
		ModelAndView mv=new ModelAndView();
		Map paramMap=new HashMap();
	    String fk_userid = req.getParameter("fk_userid");
	    String anli_id=req.getParameter("anli_id");
	    String markBTStep=req.getParameter("markBTStep");
	    List resultList=new ArrayList();
	    paramMap.put("fk_userid", fk_userid);
	    paramMap.put("anli_id", anli_id);
	    try {
	    	resultList=anLiService.excuteGetAnLi(paramMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(resultList!=null){
	    	session.setAttribute("session_anli", resultList.get(0));
	    	session.setAttribute("anli", resultList.get(0));
	    }
	    else{
	    	 session.setAttribute("session_anli",null);
	    	 session.setAttribute("anli", null);
	    }
		if(markBTStep==null){
			mv.setViewName("right3");
		}else if(markBTStep.equals("1")){
			mv.setViewName("anlibianxie");
		}
		return mv;
	}
}
