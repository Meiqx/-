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
			//把登录成功的状态保存到session中
			HttpSession session = request.getSession();
			//把当前登录成功的用户名保存到session当中
			session.setAttribute("userName", userName);
			
			
			//登录成功,获取记住密码
			String rem = request.getParameter("rem");
			//只要是rem存在就是需要记住密码
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
