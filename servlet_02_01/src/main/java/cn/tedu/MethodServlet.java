package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MethodServlet
 */
public class MethodServlet extends HttpServlet {
   	/**
   	 * get提交方式
   	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						//获取参数
		String name = request.getParameter("name");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print("执行了doGet方法"+name);
		pw.close();
	}

	/**
	 * post提交方式
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//如果post请求参数中有 中文 则需要添加以下代码
		request.setCharacterEncoding("utf-8");
		//获取参数
		String name = request.getParameter("name");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print("执行了doPost方法"+name);
		pw.close();
	}

}
