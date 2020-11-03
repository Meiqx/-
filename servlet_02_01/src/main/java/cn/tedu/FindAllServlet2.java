package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindAllServlet2
 */
public class FindAllServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select empno,ename,sal,comm from emp";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print("<table border='1'>");
			pw.print("<tr><th>编号</th><th>姓名</th><th>工资</th><th>奖金</th></tr>");
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				pw.print("<tr><td>"+empno+"</td><td>"+ename+"</td><td>"+sal+"</td><td>"+comm+"</td></tr>");
			}
			pw.print("</table>");
			pw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
