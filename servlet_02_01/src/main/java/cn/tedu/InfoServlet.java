package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
public class InfoServlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取浏览器提交的数据
		String name = req.getParameter("name");
		String pwd = req.getParameter("password");
		String gender = req.getParameter("gander");
		//获取传递过来的多个同名参数
		String[] hobby = req.getParameterValues("hobby");
		String city = req.getParameter("city");
		//设置响应字符集
		resp.setContentType("text/html;charset=utf-8");
		//获取输出对象
		PrintWriter pw = resp.getWriter();
		
		pw.print("用户名:"+name+"<br>");
		pw.print("密码:"+pwd+"<br>");
		pw.print("性别:"+gender+"<br>");
		pw.print("爱好:"+Arrays.deepToString(hobby)+"<br>");
		pw.print("城市:"+city);
		pw.close();
		
	}

}
