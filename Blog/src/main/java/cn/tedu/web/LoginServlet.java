package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.dao.UserDao;


public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("name");
		String passWord = request.getParameter("pwd");
		UserDao dao = new UserDao();
		if(dao.login(userName, passWord)) {
			//�ѵ�¼�ɹ���״̬���浽session��
			HttpSession session = request.getSession();
			//�ѵ�ǰ��¼�ɹ����û������浽session����
			session.setAttribute("userName", userName);
			
			
			//��¼�ɹ�,��ȡ��ס����
			String rem = request.getParameter("rem");
			//ֻҪ��rem���ھ�����Ҫ��ס����
			if(rem!=null) {
				Cookie nameC = new Cookie("userName",userName);
				Cookie pwC = new Cookie("passWord",passWord);
				response.addCookie(nameC);
				response.addCookie(pwC);
			}
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
			
		}else {
			response.sendRedirect(request.getContextPath()+"/login");
		}
		
	}

}
