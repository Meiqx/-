package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.EmpDao;
import cn.tedu.entity.Emp;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取传递过来的参数
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String sal = request.getParameter("sal");
		String job = request.getParameter("job");
		//把得到的参数封装到对象中,便于参数传递
		Emp emp = new Emp(Integer.valueOf(empno),ename,Double.valueOf(sal),job);
		//创建操作数据库的对象
		EmpDao dao = new EmpDao();
		dao.insert(emp);
		//让浏览器重定向到列表页面
		//request.getContextPath()获取工程的根路径
		//重定向实现原理:以下代码会给浏览器返回一个302
		//状态码和一个路径,浏览器接收后会立即向指定的路径再次发出请求
		response.sendRedirect(request.getContextPath()+"/ListServlet");
	}

	

}
