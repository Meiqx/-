package day04;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("demoBean")
public class DemoBean implements Serializable{
	@PostConstruct//�ڴ��������Ժ�ִ�з���
	public void open() {
		System.out.println("open");
	}
	@PreDestroy//�ر�����,���ٶ����ʱ��ִ�еķ���
	public void destroy() {
		System.out.println("destory");
	}
	
	public void work() {
		System.out.println("work");
	}
}
