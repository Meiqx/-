package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LikeServlet
 */
public class LikeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ������ύ����
		String name1 = req.getParameter("name1");
		String name2 = req.getParameter("name2");
		//������Ӧ���� 
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ�������
		PrintWriter pw = resp.getWriter();
		//�������
		pw.print("�ҽ�"+name1+",ϲ��"+name2);
		pw.close();
	}

}
