package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.ArticleDao;
import cn.tedu.entity.Article;


public class SendActionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String abs = request.getParameter("abs");
		String content = request.getParameter("content");
		String imgName = request.getParameter("imgName");
		String putTop = request.getParameter("putTop");
		int isTop = putTop==null?0:1;
		//把上面参数封装到对象由便于传递到Dao中
		Article a = new Article(0, title, abs, 0, 0, isTop, System.currentTimeMillis(), 
								System.currentTimeMillis(), imgName, content,null);
		//创建Dao把文章对象传递进去保存
		ArticleDao dao = new ArticleDao();
		dao.save(a);
		//重定位
		response.sendRedirect(request.getContextPath()+"/ListServlet");
	}

	

}
