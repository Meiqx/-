package cn.tedu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.ArticleDao;
import cn.tedu.dao.LinkDao;
import cn.tedu.dao.TagDao;
import cn.tedu.entity.Article;
import cn.tedu.entity.Link;
import cn.tedu.entity.Tag;
import cn.tedu.utils.ThUtils;

public class ListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建文章dao 获取所有文章的集合
		ArticleDao dao = new ArticleDao();
		List<Article> list = dao.findAll();
		System.out.println("总文章数量:"+list.size());

		//把查询到的文章集合传递到页面中
		Context context = new Context();
		context.setVariable("list", list);
		//把数据传递到页面并显示

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
		ThUtils.write("list", response, context);
	}



}
