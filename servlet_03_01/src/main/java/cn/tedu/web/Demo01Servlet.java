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
		String name = "٤��";
		//����ģ���������
		TemplateEngine te = new TemplateEngine();
		//����������
		ClassLoaderTemplateResolver r = new ClassLoaderTemplateResolver();
		//�����ַ���
		r.setCharacterEncoding("utf-8");
		//�ý�����������������
		te.setTemplateResolver(r);
		//�����������ݵĶ���
		Context c = new Context();
		//����Ҫװ�ص�ҳ������ݽ���c
		c.setVariable("name", name);
		
		//�����ݼ��ص�ҳ���еõ��µ�html
		String html = te.process("demo01.html",c);
		//�ѵõ�����html����������
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(html);
		pw.close();
		
	}

	
}
