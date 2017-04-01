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
import sw.service.AddJiHuaService;
import sw.service.PingGuSaveService;
import sw.service.UpdateAnLiStateService;
import swutil.UUIDUtil;

@Controller
@RequestMapping("addPingGuCtrl")
public class AddPingGuCtrl{
	@Resource(name="pingGuSaveService")
	private PingGuSaveService pingGuSaveService;
	public void setPingGuSaveService(PingGuSaveService pingGuSaveService) {
		this.pingGuSaveService = pingGuSaveService;
	}
	@Resource(name="updateAnLiStateService")
	private UpdateAnLiStateService updateAnLiStateService;
	public void setUpdateAnLiStateService(UpdateAnLiStateService updateAnLiStateService) {
		this.updateAnLiStateService = updateAnLiStateService;
	}
	@RequestMapping("addPingGu")
	@ResponseBody
	public Map save(HttpServletRequest req){
		ModelAndView mv=new ModelAndView();
		Map paramMap=new HashMap<>();
		String pinggu_id=UUIDUtil.getRandom();
		String daoda_mubiao= req.getParameter("daoda_mubiao");
		String fangshi_dedang= req.getParameter("fangshi_dedang");
		String pingding_dengji= req.getParameter("pingding_dengji");
		String gengjing_fuwu=req.getParameter("gengjing_fuwu");
		String chengxiao_jielun= req.getParameter("chengxiao_jielun");
		String fk_userid=req.getParameter("fk_userid");
		String fk_anli_id=req.getParameter("fk_anli_id");
		Map updateParamMap=new HashMap();
		updateParamMap.put("state", "7");
		updateParamMap.put("anli_id", fk_anli_id);
		paramMap.put("pinggu_id", pinggu_id);
		paramMap.put("daoda_mubiao", daoda_mubiao);
		paramMap.put("fangshi_dedang", fangshi_dedang);
		paramMap.put("gengjing_fuwu", gengjing_fuwu);
		paramMap.put("pingding_dengji", pingding_dengji);
		paramMap.put("chengxiao_jielun", chengxiao_jielun);
		paramMap.put("fk_userid", fk_userid);
		paramMap.put("fk_anli_id", fk_anli_id);
		int resultInt=0;
		Map resultMap=new HashMap<>();
		try {
			resultInt=pingGuSaveService.executSave(paramMap);
			updateAnLiStateService.excuteUpdateAnLiState(updateParamMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMap.put("result", resultInt);
		return resultMap;
	}
	
}
