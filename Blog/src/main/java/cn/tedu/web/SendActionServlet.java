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
		//�����������װ�������ɱ��ڴ��ݵ�Dao��
		Article a = new Article(0, title, abs, 0, 0, isTop, System.currentTimeMillis(), 
								System.currentTimeMillis(), imgName, content,null);
		//����Dao�����¶��󴫵ݽ�ȥ����
		ArticleDao dao = new ArticleDao();
		dao.save(a);
		//�ض�λ
		response.sendRedirect(request.getContextPath()+"/ListServlet");
	}

	

}
