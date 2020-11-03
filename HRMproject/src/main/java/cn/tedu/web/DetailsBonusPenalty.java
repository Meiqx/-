package cn.tedu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.Context;

import cn.tedu.dao.BonusPenaltyDao;
import cn.tedu.entity.BonusPenalty;
import cn.tedu.utils.ThUtils;

/**
 * Servlet implementation class DetailsBonusPenalty
 */
public class DetailsBonusPenalty extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		
		response.setContentType("text/html;charset=utf-8");
		//列表开始
		BonusPenaltyDao dao = new BonusPenaltyDao();
		List<BonusPenalty> list = dao.listAllBP();
		Context context = new Context();
		context.setVariable("list", list);
		//列表结束
		
		BonusPenalty bp = dao.detailBP(id);
		context.setVariable("detail", bp);
		
		ThUtils.write("DetailBonusPenalty", response, context);
	}

}
