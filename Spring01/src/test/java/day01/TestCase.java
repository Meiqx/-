package day01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * JUnit ���԰���
 * 
 * 1.���԰��������ǹ�����
 * 2.���Է��������� ����, �޲�,�޷���ֵ �ķ���
 * 3.���Է����ϱ�ע@test
 * @author JAVA
 *
 */
public class TestCase {
	ClassPathXmlApplicationContext ctx;
	@Before//��...֮ǰ,�ڲ��԰���ִ��֮ǰִ��
		public void init() {
		System.out.println("Before");
		 ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@After//��...֮��,�ڲ��԰���ִ��֮��ִ��
		public void destroy() {
		System.out.println("After");
		//close()����:�ر�Spring����,�ͷŶ�����Դ
		ctx.close();
	}
	
	@Test
	public void testHello() {
		System.out.println("Hello World");
	}
	
	@Test
	public void testKitty() {
		System.out.println("Hello Kitty");
	}
	
	@Test
	public void testDemoBean() {
		/**
		 * ����IOC
		 */
		DemoBean bean = (DemoBean)ctx.getBean("demo");
		System.out.println(bean);
	}
	
	@Test
	public void testGetBean() {
		/**
		 * Spring �ṩ�����ص�getBean����
		 * ����������Ա�������ת��
		 */		
		DemoBean bean = ctx.getBean("demo",DemoBean.class);
		System.out.println(bean);
	}
}
