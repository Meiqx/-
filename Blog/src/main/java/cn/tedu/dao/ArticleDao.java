package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.entity.Article;
import cn.tedu.entity.Tag;
import cn.tedu.utils.DBUtils;

public class ArticleDao {
	public List<Article> getHomeList(){
		ArrayList<Article> list = new ArrayList<Article>();
		//获取连接
		try(Connection conn = DBUtils.getConn()){
			String sql = "select a.oId,a.title,a.abstract,a.commentCount,a.viewCount,"
					+ "a.putTop,a.created,a.updated,a.imgName,u.userName "
					+ "from article a join user u "
					+ "on a.authorId=u.oId "
					+ "order by a.putTop desc,a.created desc "
					+ "limit 0,8";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				int oId = rs.getInt(1);
				String title = rs.getString(2);
				String abs = rs.getString(3);
				int commentCount = rs.getInt(4);
				int viewCount = rs.getInt(5);
				int putTop = rs.getInt(6);
				long created = rs.getLong(7);
				long updated = rs.getLong(8);
				String imgName = rs.getString(9);
				String userName = rs.getString(10);
				Article a = new Article(oId,title,abs,commentCount,viewCount,putTop,created,updated,imgName,userName);

				//查询当前文章对应的标签信息
				TagDao dao = new TagDao(); 
				List<Tag> tags =dao.getTagsByArticleId(oId); 
				//把查询到的标签和文章建立关系 a.setTags(tags);
				a.setTags(tags);


				list.add(a);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	//	public List<Article> getNewList() {
	//		ArrayList<Article> list = new ArrayList<>();
	//		//获取连接
	//		try (Connection conn = DBUtils.getConn()) {
	//			String sql = "select oId,title from article order by created desc limit 0,5";
	//			System.out.println("最新文章"+sql);
	//			Statement stat = conn.createStatement();
	//			ResultSet rs = stat.executeQuery(sql);
	//			while(rs.next()) {
	//				int oId = rs.getInt(1);
	//				String title = rs.getString(2);
	//				//把参数封装到实体对象中,并添加到集合中
	//				list.add(new Article(oId,title));
	//			}
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//
	//		return list;
	//	}
	//
	//	public List<Article> getCommentCount() {
	//		ArrayList<Article> list = new ArrayList<>();
	//		//获取连接
	//		try (Connection conn = DBUtils.getConn()) {
	//			String sql = "select oId,title from article order by commentCount desc limit 0,5";
	//			System.out.println("评论最多:"+sql);
	//			Statement stat = conn.createStatement();
	//			ResultSet rs = stat.executeQuery(sql);
	//			while(rs.next()) {
	//				int oId = rs.getInt(1);
	//				String title = rs.getString(2);
	//				list.add(new Article(oId,title));
	//			}
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//		return list;
	//	}
	//
	//	public List<Article> getViewCount() {
	//		ArrayList<Article> list = new ArrayList<>();
	//		//获取连接
	//		try (Connection conn = DBUtils.getConn()) {
	//			String sql = "select oId,title from article order by viewCount desc limit 0,5";
	//			System.out.println("浏览最多:"+sql);
	//			Statement stat = conn.createStatement();
	//			ResultSet rs = stat.executeQuery(sql);
	//			while(rs.next()) {
	//				int oId = rs.getInt(1);
	//				String title = rs.getString(2);
	//				list.add(new Article(oId,title));
	//			}
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//		return list;
	//	}
	//把上面三个方法合并成一个
	public List<Article> getRightList(String columeName){
		ArrayList<Article> list = new ArrayList<Article>();
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select oId,title from article order by "+columeName+" desc limit 0,5";
			System.out.println("浏览最多:"+sql);
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				int oId = rs.getInt(1);
				String title = rs.getString(2);
				list.add(new Article(oId,title));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}			
		return list;		

	}

	public List<Article> findAll() {
		ArrayList<Article> list = new ArrayList<Article>();
		//获取连接
		try(Connection conn = DBUtils.getConn()){
			String sql = "select a.oId,a.title,a.abstract,a.commentCount,a.viewCount,"
					+ "a.putTop,a.created,a.updated,a.imgName,u.userName "
					+ "from article a join user u "
					+ "on a.authorId=u.oId "
					+ "order by a.created desc";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				int oId = rs.getInt(1);
				String title = rs.getString(2);
				String abs = rs.getString(3);
				int commentCount = rs.getInt(4);
				int viewCount = rs.getInt(5);
				int putTop = rs.getInt(6);
				long created = rs.getLong(7);
				long updated = rs.getLong(8);
				String imgName = rs.getString(9);
				String userName = rs.getString(10);
				Article a = new Article(oId,title,abs,commentCount,viewCount,putTop,created,updated,imgName,userName);

				//查询当前文章对应的标签信息
				TagDao dao = new TagDao(); 
				List<Tag> tags =dao.getTagsByArticleId(oId); 
				//把查询到的标签和文章建立关系 a.setTags(tags);
				a.setTags(tags);
				list.add(a);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Article> findByKeyWord(String keyword) {
		ArrayList<Article> list = new ArrayList<Article>();
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select a.oId,a.title,a.abstract,a.commentCount,a.viewCount,a.putTop,a.created,a.updated,a.imgName,u.userName from article a join user u on a.authorId=u.oId where a.title like ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int oId = rs.getInt(1);
				String title = rs.getString(2);
				String abs = rs.getString(3);
				int commentCount = rs.getInt(4);
				int viewCount = rs.getInt(5);
				int putTop = rs.getInt(6);
				long created = rs.getLong(7);
				long updated = rs.getLong(8);
				String imgName = rs.getString(9);
				String userName = rs.getString(10);
				Article a = new Article(oId,title,abs,commentCount,viewCount,putTop,created,updated,imgName,userName);
				//查询当前文章对应的标签信息
				TagDao dao = new TagDao(); 
				List<Tag> tags =dao.getTagsByArticleId(oId); 
				//把查询到的标签和文章建立关系 a.setTags(tags);
				a.setTags(tags);
				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public Article findById(String id) {
		
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "select a.oId,a.title,a.abstract,a.commentCount,a.viewCount,a.putTop,a.created,a.updated,a.imgName,u.userName,a.content from article a join user u on a.authorId=u.oId where a.oId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.valueOf(id));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int oId = rs.getInt(1);
				String title = rs.getString(2);
				String abs = rs.getString(3);
				int commentCount = rs.getInt(4);
				int viewCount = rs.getInt(5);
				int putTop = rs.getInt(6);
				long created = rs.getLong(7);
				long updated = rs.getLong(8);
				String imgName = rs.getString(9);
				String userName = rs.getString(10);
				String content = rs.getString(11);
				Article a = new Article(oId,title,abs,commentCount,viewCount,putTop,created,updated,imgName,content,userName);
				//查询当前文章对应的信息标签
				TagDao dao = new TagDao();
				List<Tag> tags = dao.getTagsByArticleId(oId);
				a.setTags(tags);
				return a;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(Article a) {	
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			String sql = "insert into article values(null,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,a.getTitle());//文章标题
			ps.setString(2,a.getAbs());//摘要
			ps.setInt(3,1);//作者ID暂时先写死
			ps.setInt(4,0);//评论量
			ps.setInt(5,0);//浏览量
			ps.setString(6,a.getContent());//正文
			ps.setInt(7,a.getPutTop());//是否置顶
			ps.setLong(8,a.getCreated());//创建时间
			ps.setLong(9,a.getUpdated());//修改时间
			ps.setString(10,a.getImgName());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
