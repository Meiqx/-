package day04;
/**
 * 
 * Spring声明控制组件
 * 
 * @Controller声明在类前
 * 
 * @RequestMapping和@ResponseBody声明在方法前
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	
	@RequestMapping("/hello.do")
	@ResponseBody
	public String hello() {		
		System.out.println("Hello world");
		return "hello world";
	}
	
	/**
	 * 在一个控制器中可以处理多个用户请求
	 * @return
	 */
	@RequestMapping("/test.do")
	@ResponseBody
	public String test() {
		System.out.println("test");
		return "test";
	}
	
	@RequestMapping("/msg.do")
	public String msg(ModelMap map) {
		map.put("message","您好");
		return "hello";
	}
}
