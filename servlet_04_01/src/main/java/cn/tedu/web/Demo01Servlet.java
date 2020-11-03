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
		context.setVariable("msg", "今天星期二");
		context.setVariable("msg2", "<h1>明天星期三</h>");
		//孙悟空 500 公
		User u = new User("悟空",500,"公的");
		context.setVariable("user", u);
		
		User u1 = new User("诸葛亮",30,"男");
		User u2 = new User("司马懿",25,"男");
		User u3 = new User("貂蝉",68,"女");
		User u4 = new User("吕布",25,"男");
		//如果需要把多个对象装载到页面中
		//把对象添加到一个集合里面
		ArrayList<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);		
		context.setVariable("users", users);
		
		//把数据加载到页面中
		ThUtils.write("demo01", response, context);
	}

	
}
