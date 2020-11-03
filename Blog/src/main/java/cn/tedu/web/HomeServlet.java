package cn.tedu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.Context;

import cn.tedu.dao.ArticleDao;
import cn.tedu.dao.LinkDao;
import cn.tedu.dao.TagDao;
import cn.tedu.entity.Article;
import cn.tedu.entity.Link;
import cn.tedu.entity.Tag;
import cn.tedu.utils.ThUtils;


public class HomeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		String name = (String)s.getAttribute("userName");
		if(name == null) {
			//没有登录 ,重定向到登录页面
			response.sendRedirect(request.getContextPath()+"/login");
			//不执行以后代码
			return;
		}
		
		//查询首页的文章列表
		ArticleDao dao = new ArticleDao();
		List<Article> list = dao.getHomeList();
		//把第一篇文章传递到页面中
		Context context = new Context();
		context.setVariable("first", list.get(0));
		//把2,3,4篇文章对象传递到页面中
		context.setVariable("second", list.subList(1, 4));
		//5-8
		context.setVariable("normal", list.subList(4,list.size()));
		//获取最新文章列表
		List<Article> newList = dao.getRightList("created");
		System.out.println("最新文章集合:"+newList.size());
		//把最新文章集合传递到页面
		context.setVariable("newList", newList);
		
		//获取评论最热
		List<Article> commentCount = dao.getRightList("commentCount");
		System.out.println("评论最多文章集合:"+commentCount.size());
		context.setVariable("commentCount", commentCount);
		
		//获取浏览最多
		List<Article> viewCount = dao.getRightList("viewCount");
		System.out.println("浏览最多文章集合:"+viewCount.size());
		context.setVariable("viewCount", viewCount);
		
		//查询标签
		TagDao tagDao = new TagDao();
		List<Tag> tags = tagDao.getHomeTags();
		//把查询到的标签集合传递到页面当中
		context.setVariable("tags", tags);
		
		//查询链接
		LinkDao linkDao = new LinkDao();
		List<Link> links = linkDao.findAll();
		context.setVariable("links", links);
		
		ThUtils.write("index", response, context);
	}
}





