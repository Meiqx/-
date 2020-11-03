package cn.tedu.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Article {
	private int oId; //主键
	private String title;//标题
	private String abs; //摘要
	private int commentCount;//评论数量
	private int viewCount;//浏览量
	private int putTop;//是否置顶
	private long created; //创建时间戳
	private long updated; //修改时间戳
	private String imgName; //图片名
	private String content;//正文
	private String createdStr;
	private String updatedStr;
 
	
	
	public void setUpdatedStr(String updatedStr) {
		this.updatedStr = updatedStr;
	}
	public Article(int oId, String title) {
		super();
		this.oId = oId;
		this.title = title;
	}
	public String getCreatedStr() {
		//创建日期格式对象 
		SimpleDateFormat f = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm");
		//把时间戳转成时间对象
		Date d = new Date(this.created);
		//把时间对象转成指定格式的字符串
		return " "+f.format(d);
	}
	public String getUpdatedStr() {
		//创建日期格式对象 
		SimpleDateFormat f = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm");
		//把时间戳转成时间对象
		Date d = new Date(this.updated);
		//把时间对象转成指定格式的字符串
		return " "+f.format(d);
	}
	
	public void setCreatedStr(String createdStr) {
		this.createdStr = createdStr;
	}
	private String userName;//用户名
	
	private List<Tag> tags;//文章所关联的标签信息
	
	
	
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	
	
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbs() {
		return abs;
	}
	public void setAbs(String abs) {
		this.abs = abs;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getPutTop() {
		return putTop;
	}
	public void setPutTop(int putTop) {
		this.putTop = putTop;
	}
	public long getCreated() {
		return created;
	}
	public void setCreated(long created) {
		this.created = created;
	}
	public long getUpdated() {
		return updated;
	}
	public void setUpdated(long updated) {
		this.updated = updated;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Article [oId=" + oId + ", title=" + title + ", abs=" + abs + ", commentCount=" + commentCount
				+ ", viewCount=" + viewCount + ", putTop=" + putTop + ", created=" + created + ", updated=" + updated
				+ ", imgName=" + imgName + ", userName=" + userName + "]";
	}
	public Article(int oId, String title, String abs, int commentCount, int viewCount, int putTop, long created,
			long updated, String imgName, String userName) {
		super();
		this.oId = oId;
		this.title = title;
		this.abs = abs;
		this.commentCount = commentCount;
		this.viewCount = viewCount;
		this.putTop = putTop;
		this.created = created;
		this.updated = updated;
		this.imgName = imgName;
		this.userName = userName;
	}
	public Article(int oId, String title, String abs, int commentCount, int viewCount, int putTop, long created,
			long updated, String imgName, String content, String userName) {
		super();
		this.oId = oId;
		this.title = title;
		this.abs = abs;
		this.commentCount = commentCount;
		this.viewCount = viewCount;
		this.putTop = putTop;
		this.created = created;
		this.updated = updated;
		this.imgName = imgName;
		this.content = content;
		this.userName = userName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
