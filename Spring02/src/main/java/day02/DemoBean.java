package day02;

import java.io.Serializable;
/**
 * 带有对象生命周期管理方法的Bean类型
 * @author JAVA
 *
 */
public class DemoBean implements Serializable{
	public void open() {
		System.out.println("初始化");
	}
	
	public void test() {
		System.out.println("使用DemoBean");
	}
	
	public void close() {
		System.out.println("关闭");
	}
}
