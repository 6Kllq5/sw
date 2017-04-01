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
import sw.service.GetFenXiResultService;

@Controller
@RequestMapping(value="getFenXiResultCtrl")
public class GetFenXiResultCtrl {
	@Resource(name= "getFenXiResultService")
	private  GetFenXiResultService getFenXiResultService;
	public void setGetFenXiResultService(GetFenXiResultService getFenXiResultService) {
		this.getFenXiResultService = getFenXiResultService;
	}
	
	@Resource(name="getAnLiService")
	private GetAnLiService anLiService;
	public void setAnLiService(GetAnLiService anLiService) {
		this.anLiService = anLiService;
	}
	
	@RequestMapping("getFenXiResult")
	public ModelAndView getFenXiResult(HttpServletRequest req,HttpSession session) {
		ModelAndView mv=new ModelAndView();
		String fk_userid=req.getParameter("fk_userid");
		String anli_id=req.getParameter("anli_id");
		String markBTStep=req.getParameter("markBTStep");
		Map paramMap=new HashMap<>();
		paramMap.put("fk_userid",fk_userid);
		paramMap.put("fk_anli_id", anli_id);
		paramMap.put("anli_id", anli_id);
		List resultList=new ArrayList();
		List resultList2=new ArrayList();
		try {
			resultList=getFenXiResultService.excuteGetFenXiResult(paramMap);
			resultList2=anLiService.excuteGetAnLi(paramMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//在后台代码中更新session数据
		session.setAttribute("session_anli", resultList2.get(0));
		
		
		if(resultList!=null){
			session.setAttribute("fenxi", resultList.get(0));
		}else{
			
		}
		if(markBTStep==null){
			mv.setViewName("right3");
		}else {
			mv.setViewName("fenxizenduan");
		}
		return mv;
	}
}
