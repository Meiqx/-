package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NameAgeServlet
 */
public class NameAgeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ��������ݹ����Ĳ���
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		//������Ӧ����
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ�������
		PrintWriter pw = resp.getWriter();
		//�������
		pw.print("�ҽ�:"+name+"����"+age+"��");
		pw.close();
	}

}
