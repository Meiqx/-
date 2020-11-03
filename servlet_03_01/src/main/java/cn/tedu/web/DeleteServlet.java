package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.EmpDao;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empno = request.getParameter("empno");
		//创建操作数据库的对象
		EmpDao dao = new EmpDao();
		dao.delete(empno);
		//让浏览器重定向到列表页面
		//request.getContextPath()获取工程的根路径
		//重定向实现原理:以下代码会给浏览器返回一个302
		//状态码和一个路径,浏览器接收后会立即向指定的路径再次发出请求
		response.sendRedirect(request.getContextPath()+"/ListServlet");
	}


}
