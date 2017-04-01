package sw.ctrl;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sw.service.GetAllAnLiService;
import swutil.RequestTool;
@Controller 
@RequestMapping(value="getAllAnLiCtrl")
public class GetAllAnLiCtrl {
	@Resource(name="getAllAnLiService")
	private GetAllAnLiService getAllAnLiService;
	
	public void setGetAllAnLiService(GetAllAnLiService getAllAnLiService) {
		this.getAllAnLiService = getAllAnLiService;
	}
	@RequestMapping(value="getAllAnLi")
	@ResponseBody  //处理ajax数据并返回json数据,要求返回json数据格式
	public Map getAllEAnLi(HttpServletRequest request,HttpServletResponse response) {
		Map resultMap =new HashMap();
		Map paraMap=RequestTool.getParameterMap(request);
		/**
		 * 处理必要的int
		 */
		int offset= Integer.parseInt(paraMap.get("offset").toString());//开始
		int rowInOnePage =Integer.parseInt(paraMap.get("rowInOnePage").toString());
		paraMap.remove("offset");
		paraMap.remove("rowInOnePage");
		paraMap.put("offset", offset);
		paraMap.put("rowInOnePage", rowInOnePage);
		try {
			resultMap= getAllAnLiService.excuteGetAllAnLi(paraMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
}
