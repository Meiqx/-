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
		 * 测试 为Bean组件声明别名
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
		 * 测试:设置scope属性,创建多个Bean实例
		 */
		//单例情况:多次调用getBean("test");
		//获得同一对象
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
		 * 测试对象生命周期管理方法
		 */
		LogWriter log = ctx.getBean("log",LogWriter.class);
		log.print("你好啊!");
		log.print("天地不仁,以万物为刍狗");		
	}
	
	@Test
	public void testDestroy() {
		/**
		 * 设置scope=prototype以后,destroy-method就不执行了
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
