package cn.tedu.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Ȩ�޹�����,ʵ�ַ���������
 * @author JAVA
 *
 */
public class RightFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//��������requestת��Ϊ������req,��������ʹ�ø���� API ����!
		HttpServletRequest req = (HttpServletRequest)request; 
		HttpServletResponse res = (HttpServletResponse)response;
		//����¼���
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("userName");
		System.out.println("��ǰ�û�:"+username);
		if(username==null) {
			System.out.println("û�е�½");
			response.setContentType("text/html;charset=utf-8");
			res.getWriter().print("<script>alert('������ƨ��');</script>");
		}else {
			System.out.println("����:����ִ������");
			chain.doFilter(req, res);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
