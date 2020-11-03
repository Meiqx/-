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
		//调用EmpDao
		EmpDao dao = new EmpDao();		
		//调用里面的findall方法得到装着Emp对象的集合
		List<Emp> emps = dao.findAll();
		//把集合放到context里面
		Context context = new Context();
		
		context.setVariable("emps", emps);
		//调用ThUtils工具类把数据加载到页面中
		ThUtils.write("list", response, context);
		
	}

	

}
