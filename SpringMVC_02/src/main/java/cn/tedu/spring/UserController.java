package cn.tedu.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * ת�����ض��������
 * ������ת�������ض���,�������ÿͻ��˿���ĳ��ҳ��.
 * 
 * ת�� :��һ�ַ������ڲ�����Ϊ,���µĴ���������"���������յ�����,���д���,�õ�ĳЩ����,
 * �ٽ�ĳЩ���ݽ���ģ��,��Щ���ݽ���ģ���еı��ʽ�����,�õ������ݵ�HTMLҳ��,���ո�HTMLҳ��
 * ����Ӧ���ͻ���"
 * 
 * �ض���  :�ǵ�������������ͻ��˵�����֮��,���߿ͻ���"����Ҫ���͵�2�������µ�λ��",Ȼ��,�ɿͻ��˷����ڶ�������,�����µ�ҳ��
 * 
 * ����,ת��ʱ,�ͻ�����ʵֻ������1������,���������ڲ��Ķ�����֮����Դ�������,ת���������Ƿ�װ�����������(Request����)��;
 * �ض����ǿͻ��˷���1�������,���������������Ӧ��302��Ӧ��
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
		
		//�ж��û���¼
		if("root".equals(user.getUsername())) {
			if("1234".equals(user.getPassword())) {
				//TODO �����¼�ɹ�
				//�����¼�ɹ�
				session.setAttribute("username", user.getUsername());
				
				return "redirect:../hello.do";
			}else{
				//�������
				//request.setAttribute("errorMessage", "�������");
				modelMap.addAttribute("errorMessage", "{M}�������");
				return "error";
			}			
		}else {
			//�û�������
			//request.setAttribute("errorMessage", "�û�������");
			modelMap.addAttribute("errorMessage", "{M}�û�������");
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
