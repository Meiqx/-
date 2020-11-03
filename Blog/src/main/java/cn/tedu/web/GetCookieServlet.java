package cn.tedu.web;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetCookieServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取Cookie
		Cookie[] cookies = request.getCookies();
		//为了避免null指针异常操作添加判断
		if(cookies!=null) {
			//遍历每个Cookie
			for(Cookie cookie : cookies) {
				//取出cookie中的键值
				System.out.println(cookie.getName()+":"+URLDecoder.decode(cookie.getValue(),"utf-8"));
			}
		}
		//显示些回馈信息
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("ok");
	}

}
