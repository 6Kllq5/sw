package sw.ctrl;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sw.service.UserService;
import swutil.RequestTool;

@Controller
@RequestMapping("UserCtrl")
public class UserCtrl {
	@Resource(name="UserService")
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@ResponseBody
	@RequestMapping("userCtrl")
	public Map userCtrl(HttpServletRequest request){
		Map resultMap=new HashMap();
		Map paraMap=new HashMap();
		paraMap=RequestTool.getParameterMap(request);
		String method=(String) paraMap.get("method");
		if(method.equals("login")){
			resultMap=login(paraMap);
			
		}else if(method.equals("registe")){
			resultMap=registe(paraMap);
		}
		return resultMap;
	}
	
	//登录
	public Map login(Map paraMap){
		Map resultMap =new HashMap();
		Map tempMap=new HashMap();
		try {
			tempMap=userService.login(paraMap);
			if(tempMap.size()==0){
				resultMap.put("statu", 0);
				resultMap.put("message","登录失败");
			}else{
				resultMap.put("statu", 1);
				resultMap.put("message","登录成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMap.put("user", tempMap);
		return resultMap;
	}
	
	//注册
	public Map registe(Map paraMap){
		Map resultMap =new HashMap();
		return resultMap;
	}
}
