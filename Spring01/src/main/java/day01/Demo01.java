package day01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01 {

	public static void main(String[] args) {
		/**
		 * ����Spring IOC ����
		 */
		//��ʼ��Spring IOC ����
		//Spring ����������ʱ���ȡxml�����ļ�
		//���Ҹ��������ļ�����DemoBean����
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//��Spring�л�ñ�����Ķ���
		DemoBean bean = (DemoBean)ctx.getBean("demo");
		//�������Ƿ񴴽��ɹ�
		System.out.println(bean);
		//println�������Զ�����toString
	}

}
