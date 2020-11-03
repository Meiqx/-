package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NameServlet
 */
public class NameServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取浏览器传递过来的参数
		String name = req.getParameter("name");
		
		//设置响应类型
		resp.setContentType("text/html;charset=utf-8");
		//获取输出对象
		PrintWriter pw = resp.getWriter();
		//输出数据
		pw.print(name+"下午好!");
		pw.close();
	}

}
