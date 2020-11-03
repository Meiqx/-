package cn.tedu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.entity.Users;
import cn.tedu.mybatis.UserMapper;
import cn.tedu.utils.JsonResult;

/**
 * 用户管理模块控制器 2019-10-13完成
 * @author 李玉林
 *
 */
@Controller
public class UserController {
	
	//自动装配生成UserMapper
	@Autowired
	UserMapper userMapper;
	
	//处理登录方法,使用AJAX技术验证，当用户名或密码错误时候提示
	@RequestMapping("LoginServlet")
	@ResponseBody
	public JsonResult login(String username,String password,HttpSession session){
		int count = userMapper.login(username, password);
		int equalName = userMapper.equalByUsername(username);
		int equalPWD = userMapper.equalByPWD(password);
		
		JsonResult jsonResult = new JsonResult();
		
		//多层if嵌套，有时间要研究下少几个else是否影响程序运行
		if(equalName>0) {
			if(equalPWD>0) {
				session.setAttribute("username", username);
				jsonResult.setState(1);//用户名和密码都正确
			}else {
				jsonResult.setState(3);//用户名正确，但密码错误
				jsonResult.setMessage("密码错误");
			}
		}else {//这个else不能少！
			jsonResult.setState(2);//用户名错误
			jsonResult.setMessage("用户名错误");
			
		}
		return jsonResult;
		
	}
	/**
	 * 显示首页
	 * @return
	 */
	@RequestMapping("home")
	public String showHome() {
		
		return "home";
	}
	
	/**
	 * 显示用户列表
	 * @return
	 */
	@RequestMapping("ShowUserServlet")
	public String showUsers(ModelMap modelMap) {
		List<Users> users = userMapper.findAll();
		System.out.println("查找到"+users);
		modelMap.put("users", users);
		return "showUser";
	}
	
	
	
	/**
	 * 
	 * 显示录入用户信息页面
	 */
	@RequestMapping("AddUserServlet")
	public String addUser() {
		return "addUser";	
	}
	
	/**
	 * 添加用户信息service方法
	 * @param user
	 * @return
	 */
	@RequestMapping("AddUserActionServlet")
	public String addUserAction(Users user) {
		user.setCreatetime(new Date());
		userMapper.insert(user);
		return "redirect:ShowUserServlet";
	}
	
	/**
	 * 显示编辑用户信息页面
	 */
	@RequestMapping("EditUserServlet")
	public String showEditUser(String id,ModelMap modelMap) {
		
		Users user = userMapper.findUserById(Integer.valueOf(id));
		modelMap.put("user",user);
		return "editUser";
		
	}
	
	/**
	 * 实际实现用户信息修改的功能
	 * 
	 */
	@RequestMapping("EditUserActionServlet")
	public String handle_EditUser(Users user) {
		userMapper.editUser(user);
		return "redirect:ShowUserServlet";
	}
	
	/**
	 * 实现删除功能
	 */
	@RequestMapping("DeleteUserServlet")
	public String handle_deleteUser(String id) {
		userMapper.deleteUserById(Integer.valueOf(id));
		return "redirect:ShowUserServlet";
	}
	
	/**
	 * 实现登出功能
	 */
	@RequestMapping("LogOutServlet")
	public String loginOut(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:/login.html";
	}
}
