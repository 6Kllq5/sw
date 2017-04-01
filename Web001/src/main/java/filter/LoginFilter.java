package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class LoginFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//请求的url
	    String uri = request.getRequestURI();  
        //如果是以登录页面结尾的就不要过滤
	    if(uri.endsWith("/denglu.jsp")||uri.endsWith("/loginCtrl/login")||uri.endsWith("/socialwork/")){//登录页面不过滤
	    	 filterChain.doFilter(request, response);  
	    }else{
	    	Object obj=request.getSession().getAttribute("userMap");
	    	//判断为空进行过滤
	    	if(obj==null){
	    		  request.setCharacterEncoding("UTF-8");  
                  response.setCharacterEncoding("UTF-8");  
                  PrintWriter out = response.getWriter();  
                  StringBuilder builder = new StringBuilder();  
                  builder.append("<script type=\"text/javascript\">");  
                  builder.append("window.top.location.href='");  
                  builder.append("denglu.jsp");  
                  builder.append("';");  
                  builder.append("</script>");  
                  out.print(builder.toString());  
	    	}else{
	    		 filterChain.doFilter(request, response);  
	    	}
	    }
    }  
}
