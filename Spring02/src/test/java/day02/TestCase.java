package day02;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	ClassPathXmlApplicationContext ctx;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");		
	}
	@After
	public  void destroy() {
		ctx.close();
	}
	@Test
	public void testAlias() {
		/**
		 * ���� ΪBean�����������
		 */
		TestBean bean1 = ctx.getBean("test",TestBean.class);
		TestBean bean2 = ctx.getBean("demo",TestBean.class);
		
		System.out.println(bean1);
		System.out.println(bean2);
		System.out.println(bean1==bean2);
	}
	
	@Test
	public void testScope() {
		/**
		 * ����:����scope����,�������Beanʵ��
		 */
		//�������:��ε���getBean("test");
		//���ͬһ����
		TestBean b1 = ctx.getBean("test",TestBean.class);
		TestBean b2 = ctx.getBean("test",TestBean.class);
		System.out.println(b1 == b2);
		
		TestBean b3 = ctx.getBean("test2",TestBean.class);
		TestBean b4 = ctx.getBean("test2",TestBean.class);
		System.out.println(b3 == b4);
	}
	@Test
	public void testInitDestroy() {
		/*
		 * ���Զ����������ڹ�����
		 */
		LogWriter log = ctx.getBean("log",LogWriter.class);
		log.print("��ð�!");
		log.print("��ز���,������Ϊۻ��");		
	}
	
	@Test
	public void testDestroy() {
		/**
		 * ����scope=prototype�Ժ�,destroy-method�Ͳ�ִ����
		 */
		DemoBean b5 = ctx.getBean("demoBean",DemoBean.class);
		b5.test();
		//b5.close();
	}
	
	@Test
	public void work() {
		Worker w = ctx.getBean("qiang",Worker.class);
		w.work();
	}
	
	@Test
	public void example() {
		ExampleBean e = ctx.getBean("example",ExampleBean.class);
		System.out.println(e);
	}
	
}
