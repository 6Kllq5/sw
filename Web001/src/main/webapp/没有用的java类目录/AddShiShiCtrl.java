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
import sw.service.ShiShiSaveService;
import sw.service.UpdateAnLiStateService;
import swutil.UUIDUtil;

@Controller
@RequestMapping("addShiShiCtrl")
public class AddShiShiCtrl{
	@Resource(name="shiShiSaveService")
	private ShiShiSaveService ShiShiSaveService;
	public void setShiShiSaveService(ShiShiSaveService shiShiSaveService) {
		ShiShiSaveService = shiShiSaveService;
	}
	
	@Resource(name="updateAnLiStateService")
	private UpdateAnLiStateService updateAnLiStateService;
	
	public void setUpdateAnLiStateService(UpdateAnLiStateService updateAnLiStateService) {
		this.updateAnLiStateService = updateAnLiStateService;
	}
	
	@RequestMapping("addShiShi")
	@ResponseBody
	public Map save(HttpServletRequest req){
		Map paramMap=new HashMap<>();
		
		String chuzhi_id=UUIDUtil.getRandom();
		String zhengduan_shijian= req.getParameter("zhengduan_shijian");
		String zhixing_miaoshu= req.getParameter("zhixing_miaoshu");
		String beizhu= req.getParameter("beizhu");
		String fk_userid=req.getParameter("fk_userid");
		String fk_anli_id=req.getParameter("fk_anli_id");
		//获取是否跳转判定标示
		String isJump=req.getParameter("isJump");
		
		Map updateParamMap=new HashMap();
		updateParamMap.put("state", "6");
		updateParamMap.put("anli_id", fk_anli_id);
		
		paramMap.put("chuzhi_id", chuzhi_id);
		paramMap.put("zhengduan_shijian", zhengduan_shijian);
		paramMap.put("zhixing_miaoshu", zhixing_miaoshu);
		paramMap.put("beizhu", beizhu);
		paramMap.put("fk_userid", fk_userid);
		paramMap.put("fk_anli_id", fk_anli_id);
		try {
			ShiShiSaveService.executSave(paramMap);
			updateAnLiStateService.excuteUpdateAnLiState(updateParamMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map resultMap=new HashMap();
		resultMap.put("isJump", isJump);
		return resultMap;
	}
}