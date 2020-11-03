package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data数据Access访问Object对象
 * @author JAVA
 *
 */
public class EmpDao {

	public List<Emp> findAll(){
		ArrayList<Emp> emps = new ArrayList<>();
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select empno,ename,sal,comm from emp";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				double sal = rs.getDouble("sal");
				double comm =rs.getDouble("comm");
				//把数据封装到对象中
				Emp e = new Emp(empno,ename,sal,comm);
				//把数据添加到集合中
				emps.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emps;
	}
}
