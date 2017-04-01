package sw.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sw.service.UpdateAnLiService;
import swutil.UUIDUtil;

@Controller
@RequestMapping(value="updateAnLiCtrl")
public class UpdateAnLiCtrl {
	@Resource(name= "updateAnLiService")
	private UpdateAnLiService updateAnLiService;

	public void setUpdateAnLiService(UpdateAnLiService updateAnLiService) {
		this.updateAnLiService = updateAnLiService;
	}
	@ResponseBody
	@RequestMapping("updateAnLi")
	public  Map updateAnLi(HttpServletRequest req){
		String anli_id=req.getParameter("anli_id");//案例id随机生成的
		String anli_no=req.getParameter("anli_no");//案例编号，是浏览器端随机生成
		String anli_name=req.getParameter("anli_name");
		String anli_date=req.getParameter("anli_date");
		String anzhu_name=req.getParameter("anzhu_name");
		String anzhu_gender=req.getParameter("anzhu_gender");
		String anzhu_birthday=req.getParameter("anzhu_birthday");
		String anzhu_phoneno=req.getParameter("anzhu_phoneno");
		String anzhu_guanxi=req.getParameter("anzhu_guanxi");
		String lianxiren_name=req.getParameter("lianxiren_name");
		String lianxiren_phoneno=req.getParameter("lianxiren_phoneno");
		String wenti_shengli=req.getParameter("wenti_shengli");
		String wenti_xinli=req.getParameter("wenti_xinli");
		String wenti_shehui=req.getParameter("wenti_shehui");
		String wenti_jiating=req.getParameter("wenti_jiating");
		String wenti_qita=req.getParameter("wenti_qita");
		String qiuzhu_jigou=req.getParameter("qiuzhu_jigou");
		String zhuanjie_jigou=req.getParameter("zhuanjie_jigou");
		String bujiean_miaoshu=req.getParameter("bujiean_miaoshu");
		String fk_userid=req.getParameter("fk_userid");
		String fk_username=req.getParameter("fk_username");
		//state
		String state =req.getParameter("state");
		//jumpUrl
		String isJump=req.getParameter("isJump");
		
		Map paramMap=new HashMap();//用于保存的数据
		Map resultMap=new HashMap();
		//返回前台数据
		paramMap.put("anli_id", anli_id);
		paramMap.put("anli_no", anli_no);
		paramMap.put("anli_name", anli_name);
		paramMap.put("anli_date", anli_date);
		paramMap.put("anzhu_name", anzhu_name);
		paramMap.put("anzhu_gender", anzhu_gender);
		paramMap.put("anzhu_birthday", anzhu_birthday);
		paramMap.put("anzhu_phoneno", anzhu_phoneno);
		paramMap.put("anzhu_guanxi", anzhu_guanxi); 
		paramMap.put("lianxiren_name", lianxiren_name);
		paramMap.put("lianxiren_phoneno", lianxiren_phoneno);
		paramMap.put("wenti_shengli", wenti_shengli);
		paramMap.put("wenti_xinli", wenti_xinli);
		paramMap.put("wenti_shehui", wenti_shehui);
		paramMap.put("wenti_jiating", wenti_jiating);
		paramMap.put("wenti_qita", wenti_qita);
		paramMap.put("qiuzhu_jigou", qiuzhu_jigou);
		paramMap.put("zhuanjie_jigou", zhuanjie_jigou);
		paramMap.put("bujiean_miaoshu", bujiean_miaoshu);
		paramMap.put("state", state);
		paramMap.put("fk_userid", fk_userid);
		paramMap.put("fk_username", fk_username);
		try {
			//保必须要做
			updateAnLiService.excuteUpdateAnLi(paramMap);
			//不用判断，点击保存，相当于保存state 0
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMap.put("state", state);
		resultMap.put("anli_id", anli_id);
		resultMap.put("isJump", isJump);
		return resultMap;
	}
}
