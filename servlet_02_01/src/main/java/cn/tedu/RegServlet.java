package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
							//获取数据
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//获取连接
		try(Connection conn = DBUtils.getConn()){
			String sql = "insert into user values(null,?,?)";
			//创建sql执行对象
			PreparedStatement ps = conn.prepareStatement(sql);
			//替换
			ps.setString(1, name);
			ps.setString(2, password);
			//执行sql
			ps.executeUpdate();
			//设置响应类型
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print("注册成功");
			pw.close();
		}catch(Exception e) {
			//设置响应类型
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print("服务器繁忙");
			pw.close();
			e.printStackTrace();
		}
		
	}

}
