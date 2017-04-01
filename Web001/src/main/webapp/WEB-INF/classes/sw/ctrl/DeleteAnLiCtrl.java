package sw.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sw.service.DeleteAnLiService;
import sw.service.GetAllAnLiService;
import swutil.RequestTool;
import swutil.TurnPage;

@Controller
@RequestMapping("deleteAnLiCtrl")
public class DeleteAnLiCtrl {
	@Resource(name="deleteAnLiService")
	private DeleteAnLiService deleteAnLiService;
	public void setDeleteAnLiService(DeleteAnLiService deleteAnLiService) {
		this.deleteAnLiService = deleteAnLiService;
	}
	@Resource(name="getAllAnLiService")
	private GetAllAnLiService getAllAnLiService;
	public void setGetAllAnLiService(GetAllAnLiService getAllAnLiService) {
		this.getAllAnLiService = getAllAnLiService;
	}
	
	@RequestMapping("deleteAnLi")
	public ModelAndView deleteAnLi(@ModelAttribute("turnPage") TurnPage turnPage,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		//获取传过来的state，判断要获取的是那种
		Map paraMap=RequestTool.getParameterMap(request);
		//判断是不是按照条件查找的，转为整数
		if(paraMap.get("maxstate")!=null && paraMap.get("minstate")!=null){
			int maxstate=Integer.parseInt(paraMap.get("maxstate").toString());
			int minstate=Integer.parseInt(paraMap.get("minstate").toString());
			paraMap.remove("minstate");
			paraMap.remove("maxstate");
			paraMap.put("minstate",minstate);
			paraMap.put("maxstate", maxstate);
		}
		paraMap.put("turnPage", turnPage);
		try {
			deleteAnLiService.excuteDeleteAnLi(paraMap);
			Map resultMap=getAllAnLiService.excuteGetAllAnLi(paraMap);
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
