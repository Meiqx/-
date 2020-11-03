package cn.tedu.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.entity.User;
import cn.tedu.utils.ThUtils;


public class Demo01Servlet extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Context context = new Context();
		context.setVariable("msg", "�������ڶ�");
		context.setVariable("msg2", "<h1>����������</h>");
		//����� 500 ��
		User u = new User("���",500,"����");
		context.setVariable("user", u);
		
		User u1 = new User("�����",30,"��");
		User u2 = new User("˾��ܲ",25,"��");
		User u3 = new User("����",68,"Ů");
		User u4 = new User("����",25,"��");
		//�����Ҫ�Ѷ������װ�ص�ҳ����
		//�Ѷ�����ӵ�һ����������
		ArrayList<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);		
		context.setVariable("users", users);
		
		//�����ݼ��ص�ҳ����
		ThUtils.write("demo01", response, context);
	}

	
}
