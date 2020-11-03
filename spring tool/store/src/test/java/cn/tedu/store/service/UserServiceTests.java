package cn.tedu.store.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	IUserService service;
	
	@Autowired
	UserMapper userMapper;
	
	
	@Test
	public void reg() {
		try {
			User user = new User();
			user.setUsername("罗小黑");
			user.setPassword("1234");
			user.setAvatar("头像");
			user.setEmail("1234");
			service.reg(user);
		}catch(ServiceException e) {
			System.err.println(e.getClass());
		}
	}
	
	@Test
	public void login() {
		try {
			System.out.println("开始运行"+service);
			User user = service.login("root", "1234");
			System.err.println(user);
		}catch(ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
		
		
	}
	
	@Test
	public void a() {
		try {
			System.out.println("开始运行"+service);
			Integer uid = 17;
			String username = "旺财";
			String oldPassword = "1234";
			String newPassword = "123";
			service.changePassword(username, oldPassword, newPassword,uid);
			System.err.println("修改成功");
		}catch(ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}		
	}
	
	@Test
	public void findByUid() {
		try {
			Integer uid = 14;
			User user = service.getUserByUid(uid);
			System.err.println(user);
		}catch(ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void changeUserInfo() {
		try {
			Integer uid = 14;
			String username = "php";
			User user = new User();
			user.setEmail("@136");
			user.setPhone("156");
			user.setGender(0);
			service.changeInfo(uid, username, user);
			System.err.println("修改成功");
		}catch(ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void changeAvatar() {
		Integer uid = 18;
		String avatar = "1.jpg";
		String modifiedUser = "root";
		Date modifiedTime = new Date();
		System.err.println(uid+avatar+modifiedUser+modifiedTime);
		Integer rows = userMapper.updateAvatar(uid, avatar, modifiedUser, modifiedTime);
		System.err.println("修改成功-----"+rows);
	}
	
	@Test
	public void changeAvatarOfService() {
		try {
			Integer uid = 14;
			String username = "超级管理员";
			String avater="这是头像";
			service.changeAvatar(uid, username, avater);
			System.err.println("修改成功");
		}catch(ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
}
