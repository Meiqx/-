package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.UserDao;

public class RegServlet extends HttpServlet {
       
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//如果请求方式为Post 参数中有中文时添加以下代码
 		request.setCharacterEncoding("utf-8");
 		//获取传递过来的数据
 		String userName = request.getParameter("name");
 		String passWord = request.getParameter("pwd");
 		String email = request.getParameter("email");
 		//创建dao把数据保存
 		UserDao dao = new UserDao();
 		dao.save(userName, passWord, email);
 		//重定向到登录页面
 		response.sendRedirect(request.getContextPath()+"/blog/login.html");
 	}

}
