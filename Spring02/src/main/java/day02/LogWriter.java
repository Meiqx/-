package day02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
/**
 * LogWriter ������������
 * 1.��������
 * 2.����init����(�����ʼ������)
 * 3.����ʹ��print
 * 4.����֮ǰִ��close(),���ٷ���,������Դ
 * 5.����(�Զ�)
 * @author JAVA
 *
 */
public class LogWriter implements Serializable{
	
	private PrintWriter out;//һ���������͵�ֵΪnullʱ,���������Ժͷ���ʱ,����ֿ�ָ���쳣(���:���ñ���֮ǰ����ֵ/�ж�Ϊnullʱ������)
	
	public void init() throws IOException{
		out = new PrintWriter(new FileOutputStream("demo.log",true));
		System.out.println("LogWriter init!");
	}
	
	public void print(String msg) {
		out.println(msg);
		System.out.println("LogWriter print!");
	}
	
	public void close() {
		out.close();
		System.out.println("LogWriter close!");
	}
	
	public static void main(String[] args) throws IOException {
		LogWriter log = new LogWriter();
		log.init();//��ʼ������
		log.print("hahahhahha");
		log.print("hahahhahha");
		log.print("hahahhahha");
		log.close();//�ر�PrintWriter��
	}
}
