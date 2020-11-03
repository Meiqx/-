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
			//û�е�¼ ,�ض��򵽵�¼ҳ��
			response.sendRedirect(request.getContextPath()+"/login");
			//��ִ���Ժ����
			return;
		}
		
		//��ѯ��ҳ�������б�
		ArticleDao dao = new ArticleDao();
		List<Article> list = dao.getHomeList();
		//�ѵ�һƪ���´��ݵ�ҳ����
		Context context = new Context();
		context.setVariable("first", list.get(0));
		//��2,3,4ƪ���¶��󴫵ݵ�ҳ����
		context.setVariable("second", list.subList(1, 4));
		//5-8
		context.setVariable("normal", list.subList(4,list.size()));
		//��ȡ���������б�
		List<Article> newList = dao.getRightList("created");
		System.out.println("�������¼���:"+newList.size());
		//���������¼��ϴ��ݵ�ҳ��
		context.setVariable("newList", newList);
		
		//��ȡ��������
		List<Article> commentCount = dao.getRightList("commentCount");
		System.out.println("����������¼���:"+commentCount.size());
		context.setVariable("commentCount", commentCount);
		
		//��ȡ������
		List<Article> viewCount = dao.getRightList("viewCount");
		System.out.println("���������¼���:"+viewCount.size());
		context.setVariable("viewCount", viewCount);
		
		//��ѯ��ǩ
		TagDao tagDao = new TagDao();
		List<Tag> tags = tagDao.getHomeTags();
		//�Ѳ�ѯ���ı�ǩ���ϴ��ݵ�ҳ�浱��
		context.setVariable("tags", tags);
		
		//��ѯ����
		LinkDao linkDao = new LinkDao();
		List<Link> links = linkDao.findAll();
		context.setVariable("links", links);
		
		ThUtils.write("index", response, context);
	}
}





