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

import sw.service.DeleteFileService;
import sw.service.GetAllZhiKLiaoService;
import sw.service.GetAnLiService;

@Controller

@RequestMapping("deleteFileCtrl")
public class DeleteFileCtrl {
	
	@Resource(name="getAllZhiKLiaoService")
	private GetAllZhiKLiaoService getAllZhiKLiaoService;
	public void setGetAllZhiKLiaoService(GetAllZhiKLiaoService getAllZhiKLiaoService) {
		this.getAllZhiKLiaoService = getAllZhiKLiaoService;
	}
	
	@Resource(name="deleteFileService")
	private DeleteFileService deleteFileService;
	
	
	public void setDeleteFileService(DeleteFileService deleteFileService) {
		this.deleteFileService = deleteFileService;
	}

	@RequestMapping("deleteFile")
	public ModelAndView deleteFile(HttpServletRequest request,HttpSession session){
		ModelAndView mv=new ModelAndView();
		String fk_userid=request.getParameter("fk_userid");
		String fk_anli_id=request.getParameter("fk_anli_id");
		String wenjian_id=request.getParameter("wenjian_id");
		Map paramMap=new HashMap();
		paramMap.put("fk_userid", fk_userid);
		paramMap.put("fk_anli_id", fk_anli_id);
		paramMap.put("wenjian_id", wenjian_id);
		List resultList=new ArrayList();
		try {
			deleteFileService.excuteDeleteFile(paramMap);
			resultList=getAllZhiKLiaoService.excuteGetAllZhiKLiaoService(paramMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("list", resultList);
		mv.setViewName("soujiziliao");
		return mv;
	}
}
