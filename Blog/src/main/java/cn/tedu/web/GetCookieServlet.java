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
		//��ȡCookie
		Cookie[] cookies = request.getCookies();
		//Ϊ�˱���nullָ���쳣��������ж�
		if(cookies!=null) {
			//����ÿ��Cookie
			for(Cookie cookie : cookies) {
				//ȡ��cookie�еļ�ֵ
				System.out.println(cookie.getName()+":"+URLDecoder.decode(cookie.getValue(),"utf-8"));
			}
		}
		//��ʾЩ������Ϣ
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("ok");
	}

}
