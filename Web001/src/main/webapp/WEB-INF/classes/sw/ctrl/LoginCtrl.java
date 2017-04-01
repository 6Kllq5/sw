package sw.ctrl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sw.service.LoginService;
import swutil.MD5Util;

@Controller
@RequestMapping("loginCtrl")
public class LoginCtrl{
	
	@Resource(name="loginService")
	private LoginService loginService;
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req,HttpSession session){
		ModelAndView mv=new ModelAndView();
		
		String username= req.getParameter("loginname");//获取用户名
		String password= req.getParameter("password");//获取密码
		//转成md5 32位
		//password= MD5Util.string2MD5("password");
		Map paramMap=new HashMap();
		List resultList=new ArrayList();
		paramMap.put("loginname", username);
		paramMap.put("password", password);
		try {
			resultList=(List) (loginService.executSelectOne(paramMap));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//用户登录成功之后存放在session
		//跳转页面
		if(resultList!=null){
			session.setAttribute("userMap", resultList.get(0));
			mv.setViewName("index");
		}else{
			mv.setViewName("login");
		}
		return mv;
	}
}