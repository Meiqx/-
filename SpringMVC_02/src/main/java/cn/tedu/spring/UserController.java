package cn.tedu.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 转发与重定向的区别
 * 无论是转发还是重定向,都可以让客户端看到某个页面.
 * 
 * 转发 :是一种服务器内部的行为,大致的处理流程是"控制器接收到请求,进行处理,得到某些数据,
 * 再将某些数据交给模板,这些数据将被模板中的表达式所解读,得到带数据的HTML页面,最终该HTML页面
 * 被响应到客户端"
 * 
 * 重定向  :是当服务器处理完客户端的请求之后,告诉客户端"还需要发送第2次请求到新的位置",然后,由客户端发出第二次请求,看到新的页面
 * 
 * 所以,转发时,客户端其实只发出了1次请求,服务器端内部的多个组件之间可以传递数据,转发的数据是封装在请求对象中(Request对象)的;
 * 重定向是客户端发出1次请求后,服务器处理完后响应了302响应码
 * @author JAVA
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	@RequestMapping("login.do")
	public String handleuser() {
		return "login";
	}
	
	@RequestMapping("handle_login.do")
	public String handleLogin(User user,ModelMap modelMap,HttpSession session) {
		System.out.println(user);
		
		//判断用户登录
		if("root".equals(user.getUsername())) {
			if("1234".equals(user.getPassword())) {
				//TODO 处理登录成功
				//处理登录成功
				session.setAttribute("username", user.getUsername());
				
				return "redirect:../hello.do";
			}else{
				//密码错误
				//request.setAttribute("errorMessage", "密码错误");
				modelMap.addAttribute("errorMessage", "{M}密码错误");
				return "error";
			}			
		}else {
			//用户名错误
			//request.setAttribute("errorMessage", "用户名错误");
			modelMap.addAttribute("errorMessage", "{M}用户名错误");
			return "error";
		}
	}
	
	@RequestMapping("user_info.do")
	public String userShow(HttpSession session) {
//		if(session.getAttribute("username")==null) {
//			return "redirect:login.do";
//		}
		return "user_info";
	}
	
	
	
}
