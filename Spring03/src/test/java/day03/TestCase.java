package day03;

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
	public void close() {
		ctx.close();
	}	
	
	
	@Test
	public void TestDemoBean() {
		/**
		 * ���Լ���,�����ע��
		 */
		DemoBean bean = ctx.getBean("demo",DemoBean.class);
		System.out.println(bean);
	}
	
	@Test
	public void worker() {
		/**
		 * ����DI����
		 */
		Worker w = ctx.getBean("worker",Worker.class);
		w.work();
	}
	
	@Test
	public void testWorker() {
		Worker w = ctx.getBean("worker1",Worker.class);
		w.work();
	}
}
