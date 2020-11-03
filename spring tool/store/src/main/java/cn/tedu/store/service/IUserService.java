package cn.tedu.store.service;

import cn.tedu.store.entity.User;

/**
 * 实现注册功能
 * @author JAVA
 *
 */
public interface IUserService {
	/**
	 * 获取用户提交的用户数据
	 * @param user
	 * @return
	 */
	void reg(User user);
	
	/**
	  *登录验证
	 * @param user
	 * @return
	 */
	User login(String username,String password);
	
	
	/**
	 * 修改密码
	 * @param username
	 * @param oldPassword
	 * @param newPassword
	 * @param uid
	 */
	void changePassword(String username,String oldPassword,String newPassword,Integer uid);
	
	User getUserByUid(Integer uid);
	
	/**
	 * 修改个人信息
	 */
	void changeInfo(Integer uid,String username,User user);
	
	void changeAvatar(Integer uid,String username,String avatar);
}
