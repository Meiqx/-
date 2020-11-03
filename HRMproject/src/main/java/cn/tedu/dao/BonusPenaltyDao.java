package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.tedu.entity.BonusPenalty;
import cn.tedu.utils.DBUtils;
import cn.tedu.utils.DateUtils;

public class BonusPenaltyDao {
	
	//查看此人是否存在
	public boolean findName(String username) {
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select count(*) from user where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while(rs.next()) {
				count = rs.getInt(1);
				if(count>0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	//奖惩登记功能
	public void addBonusPenalty(BonusPenalty bp) {
		try (Connection conn = DBUtils.getConn()) {
			Date date = new Date();

			String sql = "insert into bonus_penalty values(null,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bp.getUsername());
			ps.setString(2, bp.getJob());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date occurTime = sdf.parse(bp.getOccurTime());

			ps.setDate(3, new java.sql.Date(occurTime.getTime()));
			ps.setString(4, bp.getReason());
			ps.setInt(5, bp.getPrice());
			ps.setString(6, bp.getDetails());
			ps.setString(7, bp.getRegister());
			ps.setTimestamp(8, new java.sql.Timestamp(date.getTime()));
			ps.executeUpdate();

		}catch (Exception e) { 
			e.printStackTrace();
		}

	}
	//列出所有奖惩
	public List<BonusPenalty> listAllBP(){
		try (Connection conn = DBUtils.getConn()) {
			ArrayList<BonusPenalty> list = new ArrayList<BonusPenalty>();
			String sql = "select id,username,job,occurtime,reason from bonus_penalty";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String job = rs.getString(3);
				Date date = rs.getDate(4);
				String occurTime = DateUtils.getDateString(date);
				String reason = rs.getString(5);
				BonusPenalty bp = new BonusPenalty(id, username, job, occurTime, reason);
				list.add(bp);
			}
			return list;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}

	//奖惩内容回显
	public BonusPenalty detailBP(int id) {
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select * from bonus_penalty where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String username = rs.getString("username");
				String job = rs.getString("job");
				Date occurDate = rs.getDate("occurtime");
				java.sql.Date happenTime = new java.sql.Date(occurDate.getTime());
				String reason = rs.getString("reason");
				int price = rs.getInt("price");
				String details = rs.getString("details");
				String register = rs.getString("register");
				Date registerDate = rs.getDate("registertime");
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String registerTime = sdf2.format(registerDate);
				BonusPenalty bp = new BonusPenalty(username, job, happenTime, reason, price, details, register, registerTime);
				return bp;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void DeleteBP(int id) {
		try (Connection conn = DBUtils.getConn()) {
			String sql = "delete from bonus_penalty where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//更新奖惩
	public void updateBP(int id, BonusPenalty bp) {
		try (Connection conn = DBUtils.getConn()) {
			Date date = new Date();

			String sql = "update bonus_penalty set job=?,occurtime=?,reason=?,price=?,details=?,register=?,registertime=? where id=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bp.getJob());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date occurTime = sdf.parse(bp.getOccurTime());

			ps.setDate(2, new java.sql.Date(occurTime.getTime()));
			ps.setString(3, bp.getReason());
			ps.setInt(4, bp.getPrice());
			ps.setString(5, bp.getDetails());
			ps.setString(6, bp.getRegister());
			ps.setTimestamp(7, new java.sql.Timestamp(date.getTime()));
			ps.setInt(8, id);
			ps.executeUpdate();

		}catch (Exception e) { 
			e.printStackTrace();
		}
		
	}

}
