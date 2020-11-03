package cn.tedu.springboot;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.springboot.entity.User;
import cn.tedu.springboot.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void getConnection() throws SQLException {
		Connection conn = dataSource.getConnection();
		System.err.println(conn);
	}
	
	@Autowired
	private UserMapper userMapper;
	@Test
	public void a() {
		User user = new User();
		user.setUsername("uuu");
		user.setPassword("15131");
		
		Integer rows = userMapper.addnew(user);
		System.err.println("rows="+rows);
	}
	
	@Test
	public void b() {
		String username = "珊迪";
		User user = userMapper.findByUsername(username);
		System.err.println("User="+user);
	}

}
