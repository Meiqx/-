package cn.tedu.web;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.tedu.dao.AddStipendDao;
import cn.tedu.entity.Salary;
import cn.tedu.utils.DateUtils;


public class AddStipendServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取页面传递过来的参数
		String name=request.getParameter("name");
		Double basic=Double.valueOf(request.getParameter("basic"));
		Double eat=Double.valueOf(request.getParameter("eat"));   
		Double house=Double.valueOf(request.getParameter("house"));
		String granttime=request.getParameter("granttime");
		Double duty=Double.valueOf(request.getParameter("duty"));
		Double scot=Double.valueOf(request.getParameter("scot"));
		Double punishment=Double.valueOf(request.getParameter("punishment"));
		Double other=Double.valueOf(request.getParameter("other"));
		Double totalize=Double.valueOf(request.getParameter("totalize"));
		
		Salary sal = null;
		try {
			sal = new Salary(0, name, basic, eat, house, DateUtils.getDate(granttime), duty, scot, punishment, other, totalize);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		AddStipendDao asd=new AddStipendDao();
		asd.addStipend(sal);
		
		
		response.sendRedirect(request.getContextPath()+"/StipendServlet");
	}

}
