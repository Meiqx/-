package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DemoBean bean = (DemoBean)ctx.getBean("demo");
		System.out.println(bean);
	}
}
