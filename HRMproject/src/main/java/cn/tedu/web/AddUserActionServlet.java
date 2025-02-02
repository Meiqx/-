package cn.tedu.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.Users;
import cn.tedu.utils.DateUtils;

/**
 * Servlet implementation class AddUserActionServlet
 */
public class AddUserActionServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("utf-8");
		
		//获取页面传递过来的参数
		String username = request.getParameter("username");//用户名
		String password = request.getParameter("password");//密码
		int sex = Integer.valueOf(request.getParameter("sex"));//性别，0是男，1是女
		int isAdmin = Integer.valueOf(request.getParameter("isadmin"));//是否是管理员
		String birthdayStr = request.getParameter("birthday");//获取生日
		String content = request.getParameter("ygjs");//员工介绍
		
		//将获取的参数传入User实体类对象中并实例化
		Users user=null;
		try {
			user = new Users(0,username,password,sex,DateUtils.getDate(birthdayStr),DateUtils.getCreationTime(),isAdmin,content);
			System.out.println("user"+user);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//将user对象存入数据库中，调用UserDao中的save(User user) 方法
		
		UserDao dao = new UserDao();
		dao.save(user);
		
		response.sendRedirect(request.getContextPath()+"/ShowUserServlet");
		
		
	}
}
