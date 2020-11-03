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
		//��ȡ���ݹ���������id
		String id = request.getParameter("id");
		//��������Daoͨ��id��ѯ���¶���
		ArticleDao dao = new ArticleDao();
		Article a = dao.findById(id);
		//�Ѳ�ѯ�������¶��󴫵ݵ�ҳ����
		Context context = new Context();
		context.setVariable("a", a);
		ThUtils.write("article2", response, context);
	}



}
