package cn.tedu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 在控制类中添加处理请求的方法,关于方法的设计:
 * 1.应该使用 public 权限(实际上通过反射也可以调用)
 * 2.暂时使用 String 作为返回值类型;
 * 3.方法名称可以自定义;(动词)
 *
 * @author JAVA
 *
 */
@Controller
public class HelloController {
	@RequestMapping("hello.do")
	public String showHello() {
		System.out.println("HelloController.showHello()");
		return "hello";
	}
}
