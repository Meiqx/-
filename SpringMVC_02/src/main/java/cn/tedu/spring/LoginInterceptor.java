package cn.tedu.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 每个拦截器都必须在Spring中配置才能使用
 * @author JAVA
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("LoginInterceptor.preHandler");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("username")==null) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/user/login.do");
			return false;
		}
		//return false; //阻止
		return true;//放行
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoginInterceptor.postHandler");

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoginInterceptor.afterHandler");

	}

}
