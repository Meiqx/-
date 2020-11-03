package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.BonusPenaltyDao;
import cn.tedu.entity.BonusPenalty;

/**
 * Servlet implementation class W_UpdateBonusPenaltyServlet
 */
public class UpdateBonusPenaltyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.valueOf(request.getParameter("id"));
		String username = request.getParameter("username");
		String job = request.getParameter("job");
		String occurTime = request.getParameter("occurTime");
		String reason = request.getParameter("reason");
		int price = Integer.valueOf(request.getParameter("price"));
		String details = request.getParameter("details");
		String register = request.getParameter("register");
		BonusPenalty bp = new BonusPenalty(username, job, occurTime, reason, price, details, register);
		BonusPenaltyDao dao = new BonusPenaltyDao();
		dao.updateBP(id,bp);
		response.sendRedirect(request.getContextPath()+"/ListBonusPenalty");
	}

}
