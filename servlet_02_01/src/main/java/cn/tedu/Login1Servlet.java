package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login1Servlet
 */
public class Login1Servlet extends HttpServlet {
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//��ȡ����
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select count(*) from user where username=? and password=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int count = rs.getInt(1);
				if(count>0) {
					print("��¼�ɹ�",response);
				}else {
					print("��¼ʧ��",response);
				}
			}
			
		} catch (Exception e) {
			print("��������æ",response);
			e.printStackTrace();
		}
	}

	private void print(String string, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(string);
		pw.close();
		
	}
}
