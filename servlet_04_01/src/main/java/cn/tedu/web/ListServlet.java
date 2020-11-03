package cn.tedu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.EmpDao;
import cn.tedu.entity.Emp;
import cn.tedu.utils.ThUtils;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����EmpDao
		EmpDao dao = new EmpDao();		
		//���������findall�����õ�װ��Emp����ļ���
		List<Emp> emps = dao.findAll();
		//�Ѽ��Ϸŵ�context����
		Context context = new Context();
		
		context.setVariable("emps", emps);
		//����ThUtils����������ݼ��ص�ҳ����
		ThUtils.write("list", response, context);
		
	}

	

}
