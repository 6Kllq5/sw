package sw.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sw.service.UpdateShiShiService;
import swutil.UUIDUtil;

@Controller
@RequestMapping("updateShiShiCtrl")
public class UpdateShiShiCtrl {
	
	@Resource(name="updateShiShiService")
	private UpdateShiShiService updateShiShiService;
	 
	public void setUpdateShiShiService(UpdateShiShiService updateShiShiService) {
		this.updateShiShiService = updateShiShiService;
	}

	@ResponseBody
	@RequestMapping("updateShiShi")
	public Map updateShiShi(HttpServletRequest req){
		Map paramMap=new HashMap<>();
		String zhengduan_shijian= req.getParameter("zhengduan_shijian");
		String zhixing_miaoshu= req.getParameter("zhixing_miaoshu");
		String beizhu= req.getParameter("beizhu");
		String fk_userid=req.getParameter("fk_userid");
		String fk_anli_id=req.getParameter("fk_anli_id");
		//获取是否跳转判定标示
		String isJump=req.getParameter("isJump");
		
		
		paramMap.put("zhengduan_shijian", zhengduan_shijian);
		paramMap.put("zhixing_miaoshu", zhixing_miaoshu);
		paramMap.put("beizhu", beizhu);
		paramMap.put("fk_userid", fk_userid);
		paramMap.put("fk_anli_id", fk_anli_id);
		try {
			updateShiShiService.excuteUpdateShiShi(paramMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map resultMap=new HashMap();
		resultMap.put("isJump", isJump);
		return resultMap;
		
	}
}
