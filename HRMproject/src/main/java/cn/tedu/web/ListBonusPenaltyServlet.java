package cn.tedu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.BonusPenaltyDao;
import cn.tedu.entity.BonusPenalty;
import cn.tedu.utils.ThUtils;

/**
 * Servlet implementation class W_ListBonusPenaltyServlet
 */
public class ListBonusPenaltyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BonusPenaltyDao dao = new BonusPenaltyDao();
		List<BonusPenalty> list = dao.listAllBP();
		Context context = new Context();
		context.setVariable("list", list);
		
		ThUtils.write("ListBonusPenalty",response, context);
	}

}
