package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MethodServlet
 */
public class MethodServlet extends HttpServlet {
   	/**
   	 * get�ύ��ʽ
   	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						//��ȡ����
		String name = request.getParameter("name");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print("ִ����doGet����"+name);
		pw.close();
	}

	/**
	 * post�ύ��ʽ
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���post����������� ���� ����Ҫ������´���
		request.setCharacterEncoding("utf-8");
		//��ȡ����
		String name = request.getParameter("name");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print("ִ����doPost����"+name);
		pw.close();
	}

}
