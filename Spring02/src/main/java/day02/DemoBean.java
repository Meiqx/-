package day02;

import java.io.Serializable;
/**
 * ���ж����������ڹ�������Bean����
 * @author JAVA
 *
 */
public class DemoBean implements Serializable{
	public void open() {
		System.out.println("��ʼ��");
	}
	
	public void test() {
		System.out.println("ʹ��DemoBean");
	}
	
	public void close() {
		System.out.println("�ر�");
	}
}
