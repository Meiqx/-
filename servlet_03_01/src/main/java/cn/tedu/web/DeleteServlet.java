package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.EmpDao;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empno = request.getParameter("empno");
		//�����������ݿ�Ķ���
		EmpDao dao = new EmpDao();
		dao.delete(empno);
		//��������ض����б�ҳ��
		//request.getContextPath()��ȡ���̵ĸ�·��
		//�ض���ʵ��ԭ��:���´��������������һ��302
		//״̬���һ��·��,��������պ��������ָ����·���ٴη�������
		response.sendRedirect(request.getContextPath()+"/ListServlet");
	}


}
