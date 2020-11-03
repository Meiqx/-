package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.ArticleDao;
import cn.tedu.entity.Article;
import cn.tedu.utils.ThUtils;

/**
 * Servlet implementation class ArticleServlet
 */
public class ArticleServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取传递过来的文章id
		String id = request.getParameter("id");
		//创建文章Dao通过id查询文章对象
		ArticleDao dao = new ArticleDao();
		Article a = dao.findById(id);
		//把查询到的文章对象传递到页面中
		Context context = new Context();
		context.setVariable("a", a);
		ThUtils.write("article2", response, context);
	}



}
