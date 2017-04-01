package sw.ctrl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sw.service.LoginService;
import sw.service.UpdateAnLiStateService;
import swutil.UUIDUtil;
import sw.service.AddJiHuaService;

@Controller
@RequestMapping("addJiHuaCtrl")
public class AddJiHuaCtrl{
	@Resource(name="addJiHuaService")
	private AddJiHuaService addJiHuaService;

	public void setJiHuaSaveService(AddJiHuaService addJiHuaService) {
		addJiHuaService = addJiHuaService;
	}
	//用于更新state
	@Resource(name="updateAnLiStateService")
	private UpdateAnLiStateService updateAnLiStateService;
	
	public void setUpdateAnLiStateService(UpdateAnLiStateService updateAnLiStateService) {
		this.updateAnLiStateService = updateAnLiStateService;
	}
	
	@ResponseBody
	@RequestMapping("addJiHua")
	public Map save(HttpServletRequest req){
		ModelAndView mv=new ModelAndView();
		Map paramMap=new HashMap<>();
		
		String jihua_id=UUIDUtil.getRandom();
		String jihua_moxing= req.getParameter("jihua_moxing");
		String jihua_shijian= req.getParameter("jihua_shijian");
		String jihua_neirong= req.getParameter("jihua_neirong");
		String jihua_beizhu= req.getParameter("jihua_beizhu");
		String fk_userid=req.getParameter("fk_userid");
		String fk_anli_id=req.getParameter("fk_anli_id");
		
		Map updateParamMap=new HashMap();
		updateParamMap.put("state", "5");
		updateParamMap.put("anli_id", fk_anli_id);
		//获取是否跳转判定标示
		String isJump=req.getParameter("isJump");
		paramMap.put("jihua_id", jihua_id);
		paramMap.put("jihua_moxing", jihua_moxing);
		paramMap.put("jihua_shijian", jihua_shijian);
		paramMap.put("jihua_neirong", jihua_neirong);
		paramMap.put("jihua_beizhu", jihua_beizhu);
		
		paramMap.put("fk_userid", fk_userid);
		paramMap.put("fk_anli_id", fk_anli_id);
		
		
		Map resultMap=new HashMap<>();
		resultMap.put("isJump", isJump);
		try {
			addJiHuaService.executSave(paramMap);
			//用于更新
			updateAnLiStateService.excuteUpdateAnLiState(updateParamMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
}

