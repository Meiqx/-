package cn.tedu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.springboot.entity.User;
import cn.tedu.springboot.mapper.UserMapper;
import cn.tedu.springboot.util.JsonResult;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserMapper userMapper;
		
	@PostMapping("reg")
	public JsonResult reg(User user) {
		System.err.println("UserController.reg()");
		System.err.println("\t"+user);
		JsonResult jsonResult = new JsonResult();
		User u = userMapper.findByUsername(user.getUsername());
		if(u==null){			
			userMapper.addnew(user);
			jsonResult.setState(1);
		}else {
			jsonResult.setState(2);
			jsonResult.setMessage("您尝试注册的用户名("+user.getUsername()+")已存在!");
		}
		return jsonResult;
	}
	
}
