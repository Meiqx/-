package cn.tedu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.entity.Link;
import cn.tedu.utils.DBUtils;

public class LinkDao {
	public List<Link> findAll(){
		ArrayList<Link> list = new ArrayList<Link>();
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select title,address from link";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				String title = rs.getString(1);
				String address = rs.getString(2);
				list.add(new Link(title,address));
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
