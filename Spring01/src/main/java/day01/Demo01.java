package day01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01 {

	public static void main(String[] args) {
		/**
		 * 测试Spring IOC 功能
		 */
		//初始化Spring IOC 容器
		//Spring 容器在启动时会读取xml配置文件
		//并且根据配置文件创建DemoBean对象
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从Spring中获得被管理的对象
		DemoBean bean = (DemoBean)ctx.getBean("demo");
		//检查对象是否创建成功
		System.out.println(bean);
		//println方法会自动调用toString
	}

}
