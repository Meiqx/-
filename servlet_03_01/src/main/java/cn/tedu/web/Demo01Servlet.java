package cn.tedu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Servlet implementation class Demo01Servlet
 */
public class Demo01Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "伽罗";
		//创建模板引擎对象
		TemplateEngine te = new TemplateEngine();
		//创建解析器
		ClassLoaderTemplateResolver r = new ClassLoaderTemplateResolver();
		//设置字符集
		r.setCharacterEncoding("utf-8");
		//让解析器和引擎对象关联
		te.setTemplateResolver(r);
		//创建传递数据的对象
		Context c = new Context();
		//把需要装载到页面的数据交给c
		c.setVariable("name", name);
		
		//把数据加载到页面中得到新的html
		String html = te.process("demo01.html",c);
		//把得到的新html输出给浏览器
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(html);
		pw.close();
		
	}

	
}
