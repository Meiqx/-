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


public class ShowStipendServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Context context=new Context();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		context.setVariable("username", username);
		
		ThUtils.write("addStipend", response, context);
		
		
		
	}

	

}
