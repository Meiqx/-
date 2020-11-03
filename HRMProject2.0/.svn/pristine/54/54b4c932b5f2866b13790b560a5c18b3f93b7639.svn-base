package cn.tedu.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.entity.Users;


public interface UserMapper {
	
	/**
	 * 处理登录的方法
	 * @param username
	 * @param password
	 * @return
	 */
	Integer login(
			@Param("username")String username,
			@Param("password")String password);
	
	/**
	 * 用户信息录入的方法
	 * @param user
	 * @return
	 */
	Integer insert(Users user);
	
	/**
	 * 查找所有用户信息
	 * @return
	 */
	List<Users> findAll();

	/**
	 * 通过id显示要修改的用户信息
	 * @param id
	 * @return
	 */
	Users findUserById(int id);

	/**
	 * 编辑用户信息
	 * @param user
	 */
	void editUser(Users user);

	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUserById(int id);

	Integer equalByUsername(String username);

	Integer equalByPWD(String password);
}
