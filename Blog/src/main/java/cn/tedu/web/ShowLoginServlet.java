package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.Context;

import cn.tedu.utils.ThUtils;

public class ShowLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��session�в�ѯ�Ƿ�ż������û���
		//����˵����¼�ɹ���
		//����Ҫ�ٴε�¼,ֱ����ʾҳ��
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("userName");
		
		if(name!=null) {
			//˵����¼�ɹ� ֱ����ʾҳ��
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
			return;
		}
		String userName = "";
		String passWord = "";
		//��ȡCookie ���������֮ǰ������û���������
		//ȡ�����ݵ�ҳ����
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie: cookies ) {
				if(cookie.getName().equals("userName")) {
					userName = cookie.getValue();
				}else if(cookie.getName().equals("passWord")) {
					passWord = cookie.getValue();
				}
			}
		}
		
		Context context = new Context();
		context.setVariable("userName",userName);
		context.setVariable("passWord",passWord);
		ThUtils.write("login", response, context);
	}
	
}
