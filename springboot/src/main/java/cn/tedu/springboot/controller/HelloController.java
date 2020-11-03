package cn.tedu.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//相当于@RestController+@ResponseBody,即:添加该注解后,当前类就是控制器类,
//并且,当前类中所有请求的方法都是响应正文,相当于每个处理请求的方法之前都添加了@ResponseBody
public class HelloController {
	@RequestMapping("hello")
	@GetMapping("hello")//相当于@RequestMapping(method=RequestMethod.GET)
	public String showHello() {
		return "hello,<h1>SpringBoot</h1>";
	}
}
