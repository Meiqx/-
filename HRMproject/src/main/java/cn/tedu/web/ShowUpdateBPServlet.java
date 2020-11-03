package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.BonusPenaltyDao;
import cn.tedu.entity.BonusPenalty;
import cn.tedu.utils.ThUtils;

/**
 * Servlet implementation class W_UpdateBonusPenaltyServlet
 */
public class ShowUpdateBPServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		//设置响应字符集
		resp.setContentType("text/html;charset=utf-8");
		
		BonusPenaltyDao dao = new BonusPenaltyDao();
		BonusPenalty bp = dao.detailBP(id);
		Context context = new Context();
		context.setVariable("Updateid", id);
		context.setVariable("update", bp);
		
		ThUtils.write("UpdateBonusPenalty", resp, context);
	}
}
