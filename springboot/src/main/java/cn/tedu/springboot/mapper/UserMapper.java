package cn.tedu.springboot.mapper;

import cn.tedu.springboot.entity.User;

public interface UserMapper {
	Integer addnew(User user);
	User findByUsername(String username);
}
