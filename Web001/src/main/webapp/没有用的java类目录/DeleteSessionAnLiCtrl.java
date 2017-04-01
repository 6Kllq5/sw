package sw.ctrl;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="deleteSessionAnLiCtrl")
public class DeleteSessionAnLiCtrl {
	@ResponseBody
	@RequestMapping("deleteSessionAnLi")
	public Map removeSessionAnLi(HttpSession httpSession){
		Map resultMap=new HashMap();
		if(	httpSession.getAttribute("session_anli")!=null){
			httpSession.removeAttribute("session_anli");
			resultMap.put("delete", 1);
		}else{
			resultMap.put("delete", 0);
		}
		return resultMap;
	}
}
