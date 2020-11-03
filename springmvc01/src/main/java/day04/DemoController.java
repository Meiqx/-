package day04;
/**
 * 
 * Spring�����������
 * 
 * @Controller��������ǰ
 * 
 * @RequestMapping��@ResponseBody�����ڷ���ǰ
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
	 * ��һ���������п��Դ������û�����
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
		map.put("message","����");
		return "hello";
	}
}
