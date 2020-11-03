package day02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
/**
 * LogWriter 理想生命周期
 * 1.创建对象
 * 2.调用init方法(对象初始化方法)
 * 3.反复使用print
 * 4.销毁之前执行close(),销毁方法,回收资源
 * 5.销毁(自动)
 * @author JAVA
 *
 */
public class LogWriter implements Serializable{
	
	private PrintWriter out;//一个引用类型的值为null时,访问其属性和方法时,会出现空指针异常(解决:调用变量之前赋初值/判断为null时不调用)
	
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
		log.init();//初始化变量
		log.print("hahahhahha");
		log.print("hahahhahha");
		log.print("hahahhahha");
		log.close();//关闭PrintWriter流
	}
}
