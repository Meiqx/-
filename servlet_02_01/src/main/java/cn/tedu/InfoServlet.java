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
		//��ȡ������ύ������
		String name = req.getParameter("name");
		String pwd = req.getParameter("password");
		String gender = req.getParameter("gander");
		//��ȡ���ݹ����Ķ��ͬ������
		String[] hobby = req.getParameterValues("hobby");
		String city = req.getParameter("city");
		//������Ӧ�ַ���
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ�������
		PrintWriter pw = resp.getWriter();
		
		pw.print("�û���:"+name+"<br>");
		pw.print("����:"+pwd+"<br>");
		pw.print("�Ա�:"+gender+"<br>");
		pw.print("����:"+Arrays.deepToString(hobby)+"<br>");
		pw.print("����:"+city);
		pw.close();
		
	}

}
