package day03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.hamcrest.Condition.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase2 {
ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
	}
	@After
	public void destroy() {
		ctx.close();
	}	
	@Test
	public void testWorker() {
		/**
		 * 测试按照类型自动出入
		 */
		Worker worker = ctx.getBean("worker",Worker.class);
		worker.work();
	}
	
	@Test
	public void testDs() {
		/**
		 * 测试DBCP
		 * BasicDateSource的父类型是java.sql.DataSource
		 */
		DataSource ds = ctx.getBean("ds",DataSource.class);
		System.out.println(ds);
		String sql = "select 'Hello World!' as str";
		try(Connection conn = ds.getConnection()){
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);
			while(rs.next()) {
				String s = rs.getString("str");
				System.out.println(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	@Test
	public void testJDBC() {
		/**
		 * 测试读取util:property 标签
		 * 读取 jdbc.properties文件
		 */
		Properties jdbc = ctx.getBean("jdbc",Properties.class);
		System.out.println(jdbc);		
	}
	
	@Test
	public void testTestBean(){ 
		/**
		 * 测试表达式
		 */
		TestBean bean = ctx.getBean("test",TestBean.class);
		System.out.println(bean);
	}
	
	@Test
	public void testExampleBean() {
		/**
		 * 测试@Component 注解
		 */
		ExampleBean bean = ctx.getBean("exampleBean",ExampleBean.class);
		System.out.println(bean);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
