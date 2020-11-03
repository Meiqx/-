package day01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * JUnit 测试案例
 * 
 * 1.测试案例必须是公有类
 * 2.测试方法必须是 公有, 无参,无返回值 的方法
 * 3.测试方法上标注@test
 * @author JAVA
 *
 */
public class TestCase {
	ClassPathXmlApplicationContext ctx;
	@Before//在...之前,在测试案例执行之前执行
		public void init() {
		System.out.println("Before");
		 ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@After//在...之后,在测试案例执行之后执行
		public void destroy() {
		System.out.println("After");
		//close()方法:关闭Spring容器,释放对象资源
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
		 * 测试IOC
		 */
		DemoBean bean = (DemoBean)ctx.getBean("demo");
		System.out.println(bean);
	}
	
	@Test
	public void testGetBean() {
		/**
		 * Spring 提供了重载的getBean方法
		 * 这个方法可以避免类型转换
		 */		
		DemoBean bean = ctx.getBean("demo",DemoBean.class);
		System.out.println(bean);
	}
}
