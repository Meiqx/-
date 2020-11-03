package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.UserDao;

public class RegServlet extends HttpServlet {
       
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�������ʽΪPost ������������ʱ������´���
 		request.setCharacterEncoding("utf-8");
 		//��ȡ���ݹ���������
 		String userName = request.getParameter("name");
 		String passWord = request.getParameter("pwd");
 		String email = request.getParameter("email");
 		//����dao�����ݱ���
 		UserDao dao = new UserDao();
 		dao.save(userName, passWord, email);
 		//�ض��򵽵�¼ҳ��
 		response.sendRedirect(request.getContextPath()+"/blog/login.html");
 	}

}
