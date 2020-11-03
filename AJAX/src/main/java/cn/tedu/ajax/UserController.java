package cn.tedu.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@RequestMapping("hello.do")
	@ResponseBody
	public String showHello() {
		return "hello. ajax!!!";
	}
	
	@RequestMapping("info.do")
	@ResponseBody
	public User showUserInfo() {
		User user = new User();
		user.setName("David");
		user.setAge(26);
		user.setPhone("13800138026");
		user.setEmail("david@tedu.cn");
		return user;
	}

	@RequestMapping("handle_login.do")
	@ResponseBody
	public JsonResult handleLogin(String username, String password) {
		// 假设root/1234是正确的用户名和密码
		JsonResult jsonResult = new JsonResult();
		
		if ("root".equals(username)) {
			if ("1234".equals(password)) {
				// 1-OK
				jsonResult.setState(1);
			} else {
				// 3-密码错
				jsonResult.setState(3);
			}
		} else {
			// 2-用户名错
			jsonResult.setState(2);
		}
		return jsonResult;
	}
	
}





