package cn.tedu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.tedu.entity.Salary;
import cn.tedu.utils.DBUtils;

public class StipendDao {
	public List<Salary> getSalary(){
		ArrayList<Salary> list=new ArrayList<>();
			//获取连接
			try (Connection conn = DBUtils.getConn();) {
				String sql="select * from stipend";
				Statement stat=conn.createStatement();
				ResultSet rs=stat.executeQuery(sql);
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					double basic=rs.getDouble("basic");
					double eat=rs.getDouble("eat");
					double house=rs.getDouble("house");
					Date granttime=rs.getDate("granttime");
					double duty=rs.getDouble("duty");
					double scot=rs.getDouble("scot");
					double punishment=rs.getDouble("punishment");
					double other=rs.getDouble("other");
					double totalize=rs.getDouble("totalize");	
					Salary sal=new Salary(id, name, basic, eat, house, granttime, duty, scot, punishment, other, totalize);
					list.add(sal);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	return list;
	}
}
