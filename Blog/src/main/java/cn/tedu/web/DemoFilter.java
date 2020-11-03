package cn.tedu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {				
	}
	@Override
	public void destroy() {				
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("开始");
		//放行后续链条
		chain.doFilter(request, response);
		//response.setContentType("text/html;charset=utf-8");
		//PrintWriter pw = response.getWriter();
		//pw.print("哈哈");
		/**
		 * response.getWriter().print("呵呵");
		 */
		System.out.println("结束");
	}
}
