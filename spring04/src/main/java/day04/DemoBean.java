package day04;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("demoBean")
public class DemoBean implements Serializable{
	@PostConstruct//在创建对象以后执行方法
	public void open() {
		System.out.println("open");
	}
	@PreDestroy//关闭容器,销毁对象的时候执行的方法
	public void destroy() {
		System.out.println("destory");
	}
	
	public void work() {
		System.out.println("work");
	}
}
