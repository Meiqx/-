package cn.tedu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * �ڿ���������Ӵ�������ķ���,���ڷ��������:
 * 1.Ӧ��ʹ�� public Ȩ��(ʵ����ͨ������Ҳ���Ե���)
 * 2.��ʱʹ�� String ��Ϊ����ֵ����;
 * 3.�������ƿ����Զ���;(����)
 *
 * @author JAVA
 *
 */
@Controller
public class HelloController {
	@RequestMapping("hello.do")
	public String showHello() {
		System.out.println("HelloController.showHello()");
		return "hello";
	}
}
