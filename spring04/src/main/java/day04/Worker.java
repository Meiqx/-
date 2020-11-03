package day04;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("qiang")
@Lazy()
public class Worker implements Serializable{
	
	private String name = "光头强";
	//Spring 在启动期间扫描Spring容器中的所有组件
	//如果有组件的类型与Tool类型兼容就注入组件
	//如果有两个以上类型兼容的组件,就匹配组件的
	//id名称是否与变量名tool 一致,如果一致就注入组件,没有匹配成功就报错
	
	//@Autowired	
	private Tool tool;
	
	@Autowired
	//@Resource
	private void setTool(Tool tool) {
		System.out.println("setTool");
		this.tool = tool;
	}
	
	public void worker() {
		System.out.println(name+"使用"+tool+"砍树");
	}
}
