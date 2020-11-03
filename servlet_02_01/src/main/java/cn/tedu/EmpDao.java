package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data����Access����Object����
 * @author JAVA
 *
 */
public class EmpDao {

	public List<Emp> findAll(){
		ArrayList<Emp> emps = new ArrayList<>();
		//��ȡ����
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select empno,ename,sal,comm from emp";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				double sal = rs.getDouble("sal");
				double comm =rs.getDouble("comm");
				//�����ݷ�װ��������
				Emp e = new Emp(empno,ename,sal,comm);
				//��������ӵ�������
				emps.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emps;
	}
}
