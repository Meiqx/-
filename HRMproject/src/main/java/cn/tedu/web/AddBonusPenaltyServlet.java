package cn.tedu.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.BonusPenaltyDao;
import cn.tedu.entity.BonusPenalty;

public class AddBonusPenaltyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置接收字符集
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String job = request.getParameter("job");
		String occurTime = request.getParameter("occurTime");
		String reason = request.getParameter("reason");
		int price = Integer.valueOf(request.getParameter("price"));
		String details = request.getParameter("details");
		String register = request.getParameter("register");
		BonusPenaltyDao dao = new BonusPenaltyDao();
		//查询员工是否存在  存在就录入 否则重新相应登记页面
		if(dao.findName(username)) {
			BonusPenalty bp = new BonusPenalty(username, job, occurTime, reason, price, details, register);
			dao.addBonusPenalty(bp);	
			response.sendRedirect(request.getContextPath()+"/ListBonusPenalty");			
		}else {
			response.sendRedirect(request.getContextPath()+"/BonusPenaltyRegister");
		}
	}

}
