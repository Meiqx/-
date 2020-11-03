package cn.tedu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;



import cn.tedu.entity.Salary;
import cn.tedu.utils.DBUtils;
import cn.tedu.utils.DateUtils;


public class AddStipendDao {
	
	public List<Salary> addStipend(Salary sal){
		ArrayList<Salary> list =new ArrayList<>();
		try (Connection conn = DBUtils.getConn();) {
			String sql="insert into stipend values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,sal.getId());
			ps.setString(2,sal.getName());
			ps.setDouble(3,sal.getBasic());
			ps.setDouble(4,sal.getEat());
			ps.setDouble(5,sal.getHouse());
			ps.setDouble(6,sal.getDuty());
			ps.setDouble(7,sal.getScot());
			ps.setDouble(8,sal.getPunishment());
			ps.setDouble(9,sal.getOther());
			ps.setDate(10, DateUtils.changeDate(sal.getGranttime()));
			ps.setDouble(11,sal.getTotalize());
			ps.executeUpdate();
			System.out.println("保存数据成功!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}
