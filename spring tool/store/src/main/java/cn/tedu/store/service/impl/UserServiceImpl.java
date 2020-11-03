package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;

/**
 * 处理用户相关功能的业务层实现类
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;


	/**
	 * 执行加密
	 * @param password 原始密码
	 * @param salt 盐值
	 * @return 加密后的结果
	 */
	private String getMd5Password(String password, String salt) {
		// 加密标准：将盐拼在原始密码的左右两侧，循环加密3次
		for (int i = 0; i < 3; i++) {
			password = DigestUtils.md5DigestAsHex(
					(salt + password + salt).getBytes()).toUpperCase();
		}
		return password;
	}

	@Override
	public void reg(User user) {
		// 从参数user中获取username
		String username = user.getUsername();
		// 根据username查询用户数据：User result = userMapper.findByUsername(username)
		User result = userMapper.findByUsername(username);
		// 判断查询结果是否不为null
		if (result != null) {
			// 抛出异常：throw new UsernameDuplicateException();
			throw new UsernameDuplicateException("您注册的用户名("+username+")已被占用");
		}

		// 补全数据-加密后的密码、盐值
		// 1. 生成盐值
		String salt = UUID.randomUUID().toString().toUpperCase();
		// 2. 取出用户提交的原始密码
		String password = user.getPassword();
		// 3. 执行加密
		String md5Password = getMd5Password(password, salt);
		// 4. 将盐值和加密后的密码补全到user对象中
		user.setSalt(salt);
		user.setPassword(md5Password);

		// 补全数据-isDelete：0
		user.setIsDelete(0);
		// 补全数据-4项日志
		Date now = new Date();
		user.setCreatedUser(username);
		user.setCreatedTime(now);
		user.setModifiedUser(username);
		user.setModifiedTime(now);

		// 执行插入用户数据，获取返回值：Integer rows = userMapper.insert(user)
		Integer rows = userMapper.insert(user);
		// 判断返回的受影响行数是否不为1
		if (rows != 1) {
			// 抛出异常：throw new InsertException();
			throw new InsertException("插入数据时出现位置错误,请联系系统管理员");
		}
	}



	/**
	 * 登录验证
	 */
	public  User login(String username,String password) {
		User result = userMapper.findByUsername(username);

		if(result==null) {	 
			throw new UserNotFoundException("用户名不存在");
		}

		if(result.getIsDelete()==1) {
			throw new UserNotFoundException("用户名不存在");
		}

		String salt = result.getSalt();//获取查询到的盐值
		String md5Password = getMd5Password(password, salt);//进行加密然后比较

		if(!result.getPassword().equals(md5Password)) {
			throw new PasswordNotMatchException("密码错误");
		}

		User user = new User();
		user.setUid(result.getUid());
		user.setUsername(result.getUsername());
		user.setAvatar(result.getAvatar());


		return user;
	}

	/**
	 * 修改密码
	 * @param uid
	 * @param password
	 * @return
	 */
	public void changePassword(String username,String oldPassword,String newPassword,Integer uid){
		User result = userMapper.findByUid(uid);

		if(result.getIsDelete()==1) {
			throw new UserNotFoundException("该用户信息已删除");
		}
		String salt = result.getSalt();
		String oldMd5Password = getMd5Password(oldPassword,salt);

		if(!result.getPassword().equals(oldMd5Password)) {
			throw new PasswordNotMatchException("原密码错误,请重新输入");
		}

		String newMd5Password = getMd5Password(newPassword, salt);
		Integer rows = userMapper.updatePasswordByUid(newMd5Password, username, new Date(),uid);
		System.err.println(rows);
		if(rows!=1) {
			throw new UpdateException("更新密码时出现位置错误,请联系系统管理员");
		}

	}

	/**
	 * 查看要修改的用户信息
	 */
	@Override
	public User getUserByUid(Integer uid) {
		User result = userMapper.findByUid(uid);
		if(result==null) {
			throw new UserNotFoundException("用户数据不存在，不能进行操作");
		}
		if(result.getIsDelete()==1) {
			throw new UserNotFoundException("用户数据不存在，不能进行操作");
		}
		User user = new User();
		user.setUsername(result.getUsername());
		user.setEmail(result.getEmail());
		user.setGender(result.getGender());
		user.setPhone(result.getPhone());

		return user;
	}

	/**
	 * 修改用户信息
	 */
	public void	changeInfo(Integer uid,String username,User user) {
		User result = userMapper.findByUid(uid);
		if(result==null) {
			throw new UserNotFoundException("用户数据不存在，不能进行操作");
		}
		if(result.getIsDelete()==1) {
			throw new UserNotFoundException("用户数据不存在，不能进行操作");
		}
		
		user.setUid(uid);
		
		user.setModifiedUser(username);
		
		user.setModifiedTime(new Date());

		Integer rows = userMapper.updateUserInfoByUid(user);
		if(rows!=1) {
			throw new UpdateException("更新数据时发生未知错误，请联系系统管理员");
		}

	}

	/**
	 * 修改用户头像
	 */
	public void changeAvatar(Integer uid,String username,String avatar) {
		User result = userMapper.findByUid(uid);
		if(result==null) {
			throw new UserNotFoundException("用户数据不存在，不能进行操作");
		}
		if(result.getIsDelete()==1) {
			throw new UserNotFoundException("用户数据不存在，不能进行操作");
		}
		
		Integer rows = userMapper.updateAvatar(uid, avatar, username, new Date());
		
		if(rows!=1) {
			throw new UpdateException("更新用户头像时发生未知错误，请联系系统管理员");
		}
		
	}
	
	
	












}
