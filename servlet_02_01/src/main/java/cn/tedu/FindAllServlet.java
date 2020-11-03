package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindAllServlet
 */
public class FindAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * request.setCharacterEncoding("utf-8"); //获取连接 try (Connection conn =
		 * DBUtils.getConn()) { String sql = "select empno,ename,sal,comm from emp";
		 * 
		 * Statement stat = conn.createStatement(); ResultSet rs =
		 * stat.executeQuery(sql); //得到输出对象开始输出数据
		 * response.setContentType("text/html;charset=utf-8"); PrintWriter pw =
		 * response.getWriter(); pw.print("<table border='1'>"); //输出表头
		 * pw.print("<tr><th>编号</th><th>姓名</th><th>工资</th><th>奖金</th></tr>");
		 * 
		 * while(rs.next()) { int empno = rs.getInt("empno"); String ename =
		 * rs.getString("ename"); double sal = rs.getDouble("sal"); double comm =
		 * rs.getDouble("comm");
		 * pw.print("<tr><td>"+empno+"</td><td>"+ename+"</td><td>"+sal+"</td><td>"+comm+
		 * "</td></tr>"); } pw.print("</table>"); pw.close();
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
		//把访问数据库的代码拆到Dao对象中之后的写法
		EmpDao dao = new EmpDao();
		List<Emp> emps = dao.findAll();
		//把查询到的数据传递到页面中
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print("<table border='1'>");
		pw.print("<tr><th>编号</th><th>姓名</th><th>工资</th><th>奖金</th></tr>");
		for (Emp emp : emps) {
			pw.print("<tr><td>"+emp.getEmpno()+"</td><td>"+emp.getName()+"</td><td>"+emp.getSal()+"</td><td>"+emp.getComm()+"</td></tr>");
		}
		pw.print("</table>");
		pw.close();
	}
	


}
