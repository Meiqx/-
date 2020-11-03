package cn.tedu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.EmpDao;
import cn.tedu.entity.Emp;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建dao对象
		EmpDao dao = new EmpDao();
		//查询所有员工
		List<Emp> emps = dao.findAll();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print("<table border='1'>");
		pw.print("<tr><th>编号</th><th>姓名</th><th>工资</th><th>工作</th><th>操作</th></tr>");
		for (Emp emp : emps) {
			pw.print("<tr><td>"+emp.getEmpno()+"</td><td>"+emp.getEname()+"</td><td>"+emp.getSal()+"</td><td>"+emp.getJob()+"</td><td><a href='DeleteServlet?empno="+emp.getEmpno()+"'>删除</a></td></tr>");
		}
		pw.print("</table>");
		pw.close();
	}

	

}
