package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.utils.ThUtils;

/**
 * Servlet implementation class Demo02Servlet
 */
public class Demo02Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "今天是星期一";
		Context context = new Context();
		context.setVariable("name", msg);
		//通过模板引擎工具把数据装载到页面中
		ThUtils.write("demo01", response, context);
	

	}
}
