package cn.tedu.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.ArticleDao;
import cn.tedu.entity.Article;
import cn.tedu.utils.ThUtils;

/**
 * Servlet implementation class SeachServlet
 */
public class SearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取传递过来的参数
		String keyword = request.getParameter("keyword");
		//创建dao查询文章通过关键字
		ArticleDao dao = new ArticleDao();
		ArrayList<Article> list = dao.findByKeyWord(keyword);
		
		Context context = new Context();
		context.setVariable("list",list);
		
		ThUtils.write("list", response, context);
	}

}
