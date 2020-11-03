package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.entity.Emp;
import cn.tedu.utils.DBUtils;

public class EmpDao {
	//查询员工表所有信息
	public List<Emp> findAll(){
		ArrayList<Emp> emps = new ArrayList<Emp>();
		
		//获取连接
		try(Connection conn = DBUtils.getConn()){
			String sql = "select empno,ename,sal,job from emp";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				double sal  = rs.getDouble(3);
				String job = rs.getString(4);
				//把查询到的数据封装到
				Emp e = new Emp(empno,ename,sal,job);
				emps.add(e);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return emps;
	}
	//保存员工信息到员工表
	public void insert(Emp emp) {
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "insert into emp(empno,ename,sal,job) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,emp.getEmpno());
			ps.setString(2,emp.getEname());
			ps.setDouble(3,emp.getSal());
			ps.setString(4,emp.getJob());
			//执行sql语句
			ps.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//删除员工信息
	public void delete(String empno) {
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "delete from emp where empno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.valueOf(empno));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
