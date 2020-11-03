package cn.tedu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//由于Cookie在HTTP协议头中进行传输,需要对中文和特殊字符进行URL编译
		Cookie c1 = new Cookie("m1",URLEncoder.encode("Hello,World","UTF-8"));
		Cookie c2 = new Cookie("m2",URLEncoder.encode("你好世界!","UTF-8"));
		//设置保存时间,如果不写则保存在浏览器的内存中
		//浏览器关闭时清除,如果是设置了时间则保存到磁盘中,
		//时间到后清除,如果设置时间为0则立即删除;
		c2.setMaxAge(60*60*24*30);//保存一个月
		//通过response对象将cookie下发到浏览器(客户端);
		response.addCookie(c1);
		response.addCookie(c2);
		//显示些回馈信息
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("ok");
	}
}
