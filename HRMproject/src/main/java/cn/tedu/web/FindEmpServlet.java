package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.BonusPenaltyDao;
import cn.tedu.utils.ThUtils;

public class FindEmpServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		BonusPenaltyDao dao = new BonusPenaltyDao();
		boolean isExist = dao.findName(username);
		Context context = new Context();
	
		context.setVariable("isExist", isExist?"存在":"不存在");
		context.setVariable("username", username);
		response.setContentType("text/html;charset=utf-8");
		ThUtils.write("BonusPenaltyRegister", response, context);

		
	}

}
