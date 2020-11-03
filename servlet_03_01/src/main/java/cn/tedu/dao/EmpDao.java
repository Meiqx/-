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
	//��ѯԱ����������Ϣ
	public List<Emp> findAll(){
		ArrayList<Emp> emps = new ArrayList<Emp>();
		
		//��ȡ����
		try(Connection conn = DBUtils.getConn()){
			String sql = "select empno,ename,sal,job from emp";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				double sal  = rs.getDouble(3);
				String job = rs.getString(4);
				//�Ѳ�ѯ�������ݷ�װ��
				Emp e = new Emp(empno,ename,sal,job);
				emps.add(e);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return emps;
	}
	//����Ա����Ϣ��Ա����
	public void insert(Emp emp) {
		//��ȡ����
		try (Connection conn = DBUtils.getConn()) {
			String sql = "insert into emp(empno,ename,sal,job) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,emp.getEmpno());
			ps.setString(2,emp.getEname());
			ps.setDouble(3,emp.getSal());
			ps.setString(4,emp.getJob());
			//ִ��sql���
			ps.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//ɾ��Ա����Ϣ
	public void delete(String empno) {
		//��ȡ����
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
