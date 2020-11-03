package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.tedu.utils.DBUtils;

public class UserDao {
	public void save(String userName,String passWord,String email) {
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "insert into user values(null,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, userName);
			ps.setString(3,passWord);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean login(String userName,String passWord) {
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select count(*) from user where userName=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int count = rs.getInt(1);
				if(count>0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}
}
