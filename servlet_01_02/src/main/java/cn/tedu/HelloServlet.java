package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置响应数据和字符集
		resp.setContentType("text/html;charset=utf-8");
		//获取输出对象
		PrintWriter pw = resp.getWriter();
		//输出对象
		pw.print("<h1>该吃饭了!</h>");
		//关闭资源
		pw.close();
	}

}
