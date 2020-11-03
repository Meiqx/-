package cn.tedu.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 权限过滤器,实现防盗链功能
 * @author JAVA
 *
 */
public class RightFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//将父类型request转换为子类型req,这样可以使用更多的 API 方法!
		HttpServletRequest req = (HttpServletRequest)request; 
		HttpServletResponse res = (HttpServletResponse)response;
		//检查登录情况
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("userName");
		System.out.println("当前用户:"+username);
		if(username==null) {
			System.out.println("没有登陆");
			response.setContentType("text/html;charset=utf-8");
			res.getWriter().print("<script>alert('你在想屁吃');</script>");
		}else {
			System.out.println("放行:继续执行链条");
			chain.doFilter(req, res);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
