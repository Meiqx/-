package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AIServlet
 */
public class AIServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String info = req.getParameter("info");
		info = info.replace("Âð","");
		info = info.replace("ÎÒ","ÎÒÒ²");
		info = info.replace("?","!");

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		pw.print(info);
		pw.close();
		
		
	}

}
