package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NameServlet
 */
public class NameServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ��������ݹ����Ĳ���
		String name = req.getParameter("name");
		
		//������Ӧ����
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ�������
		PrintWriter pw = resp.getWriter();
		//�������
		pw.print(name+"�����!");
		pw.close();
	}

}
