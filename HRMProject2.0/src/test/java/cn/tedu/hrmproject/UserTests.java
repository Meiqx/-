package cn.tedu.hrmproject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.entity.Users;
import cn.tedu.mybatis.UserMapper;

public class UserTests {

	SqlSessionFactoryBean ds;
	ClassPathXmlApplicationContext ac;
	UserMapper userMapper;
	@Before
	public void doBefore() {//初始化容器对象和一个向上造型的接口
		ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		
		//myBatis为UserMapper接口生成了一个代理对象
		userMapper= ac.getBean("userMapper",UserMapper.class);
		
	}
	
	@After
	public void doAfter() {
		ac.close();
	}
	
	@Test//测试数据库连接
	public void getConnection() throws SQLException {
		BasicDataSource dataSource = ac.getBean("dataSource",BasicDataSource.class);
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}
	
	@Test
	public void login() {
		
		int count = userMapper.login("李玉林", "123");
		System.out.println(count);
	}
	
	@Test
	public void findAll() {
		List<Users> list = userMapper.findAll();
		System.out.println("查找到"+list);
		for (Users users : list) {
			System.err.println(users);
		}
		System.out.println(list.size());
	}
	
	@Test
	public void findUserById() {
		Users user = userMapper.findUserById(2);
		System.out.println(user);
		
	}
	@Test
	public void deleteUserById() {
		
		userMapper.deleteUserById(13);
		System.out.println("删除成功");
		
	}
}
