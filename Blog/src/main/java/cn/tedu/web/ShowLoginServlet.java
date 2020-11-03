package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.Context;

import cn.tedu.utils.ThUtils;

public class ShowLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从session中查询是否偶保存的用户名
		//有则说明登录成功过
		//不需要再次登录,直接显示页面
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("userName");
		
		if(name!=null) {
			//说明登录成功 直接显示页面
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
			return;
		}
		String userName = "";
		String passWord = "";
		//获取Cookie 如果里面有之前保存的用户名和密码
		//取出传递到页面中
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie: cookies ) {
				if(cookie.getName().equals("userName")) {
					userName = cookie.getValue();
				}else if(cookie.getName().equals("passWord")) {
					passWord = cookie.getValue();
				}
			}
		}
		
		Context context = new Context();
		context.setVariable("userName",userName);
		context.setVariable("passWord",passWord);
		ThUtils.write("login", response, context);
	}
	
}
