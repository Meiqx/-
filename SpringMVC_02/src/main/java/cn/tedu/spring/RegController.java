package cn.tedu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegController {
	@RequestMapping("reg.do")
	public String reg() {

		return "reg";
	}

	@RequestMapping("handle_reg.do")
	public String handleReg(User user,ModelMap modelMap){
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String email = request.getParameter("email");
//		String birth = request.getParameter("birth");
		
		System.out.println(user);
		/*
		 * System.out.println("password="+password); System.out.println("email="+email);
		 * System.out.println("birth="+birth);
		 */
		if("admin".equals(user.getUsername())) {
			//用户名已存在
			modelMap.addAttribute("errorMessage","用户名已存在");
			return "error";
		}else {
			return "redirect:user/login.do";
		}		

	}
}
