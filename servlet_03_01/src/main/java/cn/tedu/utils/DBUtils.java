package cn.tedu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static BasicDataSource ds;//创建全局变量,使得静态块和静态方法内可以调用
	//连接池放入静态块�?,在每次调用该类时自动加载,并且只执行一次,节省资源
	static{
		Properties p = new Properties();       //获取类加载器                以流的形式获取资源
		InputStream ips = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			p.load(ips);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String driver = p.getProperty("driver");
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		//创建数据库连接池对象
		ds = new BasicDataSource();
		//设置数据库连接信�?
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		//设置初始连接数量
		ds.setInitialSize(3);
		//设置�?大连接数�?
		ds.setMaxActive(5);
	}
	public static Connection getConn() throws Exception {		
		//从连接池中获取连�? 抛异�?
		Connection conn = ds.getConnection();

		return conn;
	}
}
