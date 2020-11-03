package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.EmpDao;
import cn.tedu.entity.Emp;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//��ȡ���ݹ����Ĳ���
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String sal = request.getParameter("sal");
		String job = request.getParameter("job");
		//�ѵõ��Ĳ�����װ��������,���ڲ�������
		Emp emp = new Emp(Integer.valueOf(empno),ename,Double.valueOf(sal),job);
		//�����������ݿ�Ķ���
		EmpDao dao = new EmpDao();
		dao.insert(emp);
		//��������ض����б�ҳ��
		//request.getContextPath()��ȡ���̵ĸ�·��
		//�ض���ʵ��ԭ��:���´��������������һ��302
		//״̬���һ��·��,��������պ��������ָ����·���ٴη�������
		response.sendRedirect(request.getContextPath()+"/ListServlet");
	}

	

}
