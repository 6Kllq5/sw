package sw.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sw.service.UpdatePingGuService;
import swutil.UUIDUtil;

@Controller
@RequestMapping("updatePingGuCtrl")
public class UpdatePingGuCtrl {
	@Resource(name="")
	private UpdatePingGuService updatePingGuService;

	public void setUpdatePingGuService(UpdatePingGuService updatePingGuService) {
		this.updatePingGuService = updatePingGuService;
	}
	@ResponseBody
	@RequestMapping("updatePingGu")
	public Map updatePingGu(HttpServletRequest req){
		ModelAndView mv=new ModelAndView();
		Map paramMap=new HashMap<>();
		String daoda_mubiao= req.getParameter("daoda_mubiao");
		String fangshi_dedang= req.getParameter("fangshi_dedang");
		String pingding_dengji= req.getParameter("pingding_dengji");
		String gengjing_fuwu=req.getParameter("gengjing_fuwu");
		String chengxiao_jielun= req.getParameter("chengxiao_jielun");
		String fk_userid=req.getParameter("fk_userid");
		String fk_anli_id=req.getParameter("fk_anli_id");
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
			updatePingGuService.excuteUpdatePingGu(paramMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMap.put("result", resultInt);
		return resultMap;
		
	}
	
	
}
