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
		//����Cookie��HTTPЭ��ͷ�н��д���,��Ҫ�����ĺ������ַ�����URL����
		Cookie c1 = new Cookie("m1",URLEncoder.encode("Hello,World","UTF-8"));
		Cookie c2 = new Cookie("m2",URLEncoder.encode("�������!","UTF-8"));
		//���ñ���ʱ��,�����д�򱣴�����������ڴ���
		//������ر�ʱ���,�����������ʱ���򱣴浽������,
		//ʱ�䵽�����,�������ʱ��Ϊ0������ɾ��;
		c2.setMaxAge(60*60*24*30);//����һ����
		//ͨ��response����cookie�·��������(�ͻ���);
		response.addCookie(c1);
		response.addCookie(c2);
		//��ʾЩ������Ϣ
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("ok");
	}
}
