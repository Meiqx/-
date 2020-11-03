package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;
import dao.UserDao;

/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//先获得资源请求路径,
		String uri = request.getRequestURI();
		System.out.println("uir="+uri);
		//获得应用名
		String contextPath = request.getContextPath();
		System.out.println("contextPath="+contextPath);
		//将请求路径的应用名去掉
		String path = uri.substring(contextPath.length());
		System.out.println("path="+path);
		//依据请求路径,调用对应的模型来处理.
		if("/list.do".equals(path)) {
			UserDao dao = new UserDao();
			List<User> users = dao.findAll();
			//将数据绑定到request
			request.setAttribute("users", users);
			//获得转发器对象
			RequestDispatcher rd = request.getRequestDispatcher("listUsers3.jsp");
			//转发
			rd.forward(request, response);
		}
	}

}
