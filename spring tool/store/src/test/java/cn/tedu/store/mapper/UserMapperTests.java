package cn.tedu.store.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
	
	@Autowired
	UserMapper userMapper;
	UserServiceImpl us;
	
	@Test
	public void reg() {
		User user = new User();
		user.setUsername("springmvc");
		user.setPassword("1234");
		user.setAvatar("头像");
		user.setEmail("邮箱");
		user.setIsDelete(0);
		user.setGender(0);
		user.setPhone("电话号码");
		Integer rows = userMapper.insert(user);
		System.err.println(rows);
	}
	@Test
	public void findByUsername() {
		String name = "张三";
		User user = userMapper.findByUsername(name);
		System.err.println(user);
	}
	
	@Test
	public void login() {
		String name = "梅全心";
		String password = "1234";
		User result = userMapper.findByUsername(name);	
		
		User user = us.login(name, password);
		System.err.println(result);
		System.err.println(user);
		
	}
}
