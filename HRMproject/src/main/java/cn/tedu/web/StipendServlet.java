package cn.tedu.web;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.Context;

import cn.tedu.dao.StipendDao;
import cn.tedu.entity.Salary;
import cn.tedu.utils.ThUtils;

public class StipendServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面传递过来的参数
			
		StipendDao s=new StipendDao();
		List<Salary> list=s.getSalary();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		Context context = new Context();
		context.setVariable("sallist", list);
		context.setVariable("username", username);
		ThUtils.write("getsalary", response, context); 
		
		
		
		
	}

	

}
