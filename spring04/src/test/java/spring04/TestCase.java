package spring04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day04.DemoBean;
import day04.ExampleBean;
import day04.Worker;

public class TestCase {
	ClassPathXmlApplicationContext ctx ;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
	}
	@After
	public void destroy() {
		ctx.close();
	}
	
	@Test
	public void testQiang() {
		/**
		 * 测试@Autowired
		 */
		Worker w = ctx.getBean("qiang",Worker.class);
		
		w.worker();
	}
	
	@Test
	public void testScope() {
		/**
		 * 测试@Scope
		 * 
		 */
		ExampleBean bean1 = ctx.getBean("exampleBean",ExampleBean.class);
		ExampleBean bean2 = ctx.getBean("exampleBean",ExampleBean.class);
		System.out.println(bean1==bean2);
	}
	
	@Test
	public void testDemoBean() {
		/**
		 * 测试对象生命周期管理测试
		 */
		DemoBean bean = ctx.getBean("demoBean",DemoBean.class);
		bean.work();
	}
	
	
	
	
	
}
