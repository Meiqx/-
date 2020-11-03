package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThUtils {
	private static TemplateEngine te;
	//ģ�������ʼ������ д��static���汣ִֻ֤��һ��
	static {
		te = new TemplateEngine();
		//����������
		ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		//�����ַ���
		resolver.setCharacterEncoding("utf-8");
		//���ú�׺
		resolver.setSuffix(".html");
		//ģ������ͽ���������
		te.setTemplateResolver(resolver);
	}
	public static void write(String path,HttpServletResponse response,Context context) throws IOException {
		//��ҳ������ݽ���ģ���������
		String html = te.process(path, context);
		//������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(html);
		pw.close();
		
	}
}
