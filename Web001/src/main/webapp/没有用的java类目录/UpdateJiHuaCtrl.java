package sw.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sw.service.UpdateJiHuaService;
import swutil.UUIDUtil;

@Controller
@RequestMapping("updateJiHuaCtrl")
public class UpdateJiHuaCtrl {
	@Resource(name="updateJiHuaService")
	private UpdateJiHuaService updateJiHuaService;
	public void setUpdateJiHuaService(UpdateJiHuaService updateJiHuaService) {
		this.updateJiHuaService = updateJiHuaService;
	}
	@ResponseBody
	@RequestMapping("updateJiHua")
	public Map updateJiHua(HttpServletRequest req,HttpSession session){
		Map paramMap=new HashMap<>();
		String jihua_moxing= req.getParameter("jihua_moxing");
		String jihua_shijian= req.getParameter("jihua_shijian");
		String jihua_neirong= req.getParameter("jihua_neirong");
		String jihua_beizhu= req.getParameter("jihua_beizhu");
		String fk_userid=req.getParameter("fk_userid");
		String fk_anli_id=req.getParameter("fk_anli_id");
		
		//获取是否跳转判定标示
		String isJump=req.getParameter("isJump");
		paramMap.put("jihua_moxing", jihua_moxing);
		paramMap.put("jihua_shijian", jihua_shijian);
		paramMap.put("jihua_neirong", jihua_neirong);
		paramMap.put("jihua_beizhu", jihua_beizhu);
		paramMap.put("fk_userid", fk_userid);
		paramMap.put("fk_anli_id", fk_anli_id);
		
		Map resultMap=new HashMap();
		resultMap.put("isJump", isJump);
		try {
			updateJiHuaService.excuteUpdateJiHua(paramMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
	
}
