package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.BonusPenaltyDao;

/**
 * Servlet implementation class W_DeleteBonusPenaltyServlet
 */
public class DeleteBonusPenaltyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		BonusPenaltyDao dao = new BonusPenaltyDao();
		dao.DeleteBP(id);
		response.sendRedirect(request.getContextPath()+"/ListBonusPenalty");
	}
}
