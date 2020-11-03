package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LikeServlet
 */
public class LikeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取浏览器提交参数
		String name1 = req.getParameter("name1");
		String name2 = req.getParameter("name2");
		//设置响应类型 
		resp.setContentType("text/html;charset=utf-8");
		//获取输出对象
		PrintWriter pw = resp.getWriter();
		//输出数据
		pw.print("我叫"+name1+",喜欢"+name2);
		pw.close();
	}

}
