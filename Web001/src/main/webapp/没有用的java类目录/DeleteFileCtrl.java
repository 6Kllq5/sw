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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sw.service.DeleteFileService;
import sw.service.GetAllZhiLiaoService;
import sw.service.GetAnLiService;
import swutil.RequestTool;

@Controller

@RequestMapping("deleteFileCtrl")
public class DeleteFileCtrl {
	
	@Resource(name="deleteFileService")
	private DeleteFileService deleteFileService;
	
	public void setDeleteFileService(DeleteFileService deleteFileService) {
		this.deleteFileService = deleteFileService;
	}
	@ResponseBody
	@RequestMapping("deleteFile")
	public Map deleteFile(HttpServletRequest request,HttpSession session){
		Map resultMap=new HashMap();
		Map paraMap=new HashMap();
		int resultInt=0;
		paraMap=RequestTool.getParameterMap(request);
		try {
			resultInt=deleteFileService.excuteDeleteFile(paraMap);
			if(resultInt==0){
				resultMap.put("statu",0);
				resultMap.put("message","删除失败");
			}else{
				resultMap.put("statu", 1);
				resultMap.put("message", "删除成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
}
