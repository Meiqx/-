package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.utils.ThUtils;


public class SendServlet extends HttpServlet {
	//405状态码 当Servlet中没有指定请求的响应方法时,会出现405状态码
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ThUtils.write("send", response, new Context());
	}

	

}
