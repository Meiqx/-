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
							//��ȡ����
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//��ȡ����
		try(Connection conn = DBUtils.getConn()){
			String sql = "insert into user values(null,?,?)";
			//����sqlִ�ж���
			PreparedStatement ps = conn.prepareStatement(sql);
			//�滻
			ps.setString(1, name);
			ps.setString(2, password);
			//ִ��sql
			ps.executeUpdate();
			//������Ӧ����
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print("ע��ɹ�");
			pw.close();
		}catch(Exception e) {
			//������Ӧ����
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print("��������æ");
			pw.close();
			e.printStackTrace();
		}
		
	}

}
