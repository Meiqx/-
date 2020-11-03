package cn.tedu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.entity.Emp;
import cn.tedu.utils.DBUtils;

public class EmpDao {
	public List<Emp> findAll(){
		ArrayList<Emp> emps = new ArrayList<Emp>();
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select empno,ename,sal,job from emp";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				double sal = rs.getDouble(3);
				String job = rs.getString(4);
				Emp e = new Emp(empno,ename,sal,job);
				emps.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emps;
	}
}
