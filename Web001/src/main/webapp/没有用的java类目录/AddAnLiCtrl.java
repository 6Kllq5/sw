package sw.ctrl;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import sw.service.AddAnLiService;
import sw.service.UpdateAnLiService;
import swutil.RequestTool;
import swutil.UUIDUtil;
@Controller
@RequestMapping(value="addAnLiCtrl")
public class AddAnLiCtrl {
	@Resource(name="addAnLiService")
	private AddAnLiService addAnLiService;
	public void setAddAnLiService(AddAnLiService addAnLiService) {
		this.addAnLiService = addAnLiService;
	}
	@Resource(name="updateAnLiService")
	private UpdateAnLiService updateAnLiService;
	public void setUpdateAnLiService(UpdateAnLiService updateAnLiService) {
		this.updateAnLiService = updateAnLiService;
	}
	@RequestMapping("/addAnLi")
	@ResponseBody
	public Map addAnLi(HttpServletRequest req,HttpSession session){
		Map paraMap=RequestTool.getParameterMap(req);
		Map resultMap=new HashMap();
		int resultInt=0;
		//修改一个案例
		try {
			if(paraMap.get("anli_id")!=""||paraMap.get("anli_id")!=null){
				resultInt=updateAnLiService.excuteUpdateAnLi(paraMap);
				if(resultInt==0){
					resultMap.put("status", 0);
					resultMap.put("message","修改失败");
				}else{
					resultMap.put("status", 1);
					resultMap.put("message","修改成功");
				}
			} 
			else{
				//增加一个案例
				paraMap.put("anli_id", UUIDUtil.getRandom().toString());
				resultInt=addAnLiService.excuteAddAnLi(paraMap);
				if(resultInt==0){
					resultMap.put("status", 0);
					resultMap.put("message","添加失败");
				}else{
					resultMap.put("status", 1);
					resultMap.put("message","添加成功");
				}
			}
			resultMap.put("anli_id",resultMap.get("anli_id"));
			resultMap.put("state",resultMap.get("state"));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
}
