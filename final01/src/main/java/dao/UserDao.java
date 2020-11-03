package dao;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
	public List<User> findAll(){
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setId(1);
		user.setUsername("张三");
		user.setPassword("fhmf");
		user.setEmail("1231@64.com");
		
		users.add(user);
		
		User user2 = new User();
		user2.setId(2);
		user2.setUsername("李四");
		user2.setPassword("12fc");
		user2.setEmail("356dgd@qq.com");
		
		users.add(user2);
		
		User user3 = new User();
		user3.setId(3);
		user3.setUsername("王五");
		user3.setPassword("1e,234");
		user3.setEmail("sgs@163.com");
		
		users.add(user3);
		
		User user4 = new User();
		user4.setId(4);
		user4.setUsername("赵六");
		user4.setPassword("1k,e34");
		user4.setEmail("sgs@163.com");
		
		users.add(user4);
		
		return users;
	}
}
