package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������Ӧ���ݺ��ַ���
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ�������
		PrintWriter pw = resp.getWriter();
		//�������
		pw.print("<h1>�óԷ���!</h>");
		//�ر���Դ
		pw.close();
	}

}
