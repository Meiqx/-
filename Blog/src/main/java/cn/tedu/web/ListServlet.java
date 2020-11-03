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
		//��������dao ��ȡ�������µļ���
		ArticleDao dao = new ArticleDao();
		List<Article> list = dao.findAll();
		System.out.println("����������:"+list.size());

		//�Ѳ�ѯ�������¼��ϴ��ݵ�ҳ����
		Context context = new Context();
		context.setVariable("list", list);
		//�����ݴ��ݵ�ҳ�沢��ʾ

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
		ThUtils.write("list", response, context);
	}



}
