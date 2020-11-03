package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.entity.Tag;
import cn.tedu.utils.DBUtils;

public class TagDao {
	public List<Tag> getTagsByArticleId(int articleId){
		ArrayList<Tag> tags = new ArrayList<Tag>();
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select t.oId,t.referenceCount,t.title "
					+ "from tag t join tag_article ta "
					+ "on t.oId=ta.tag_oId "
					+ "where ta.article_oId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, articleId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int oId = rs.getInt(1);
				int referenceCount = rs.getInt(2);
				String title = rs.getString(3);
				tags.add(new Tag(oId,referenceCount,title));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tags;
	}

	public List<Tag> getHomeTags() {
		ArrayList<Tag> list = new ArrayList<Tag>();
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select oId,referenceCount,title from tag order by referenceCount desc limit 0,5";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				int oId = rs.getInt(1);
				int referenceCount = rs.getInt(2);
				String title = rs.getString(3);
				list.add(new Tag(oId, referenceCount,title));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
