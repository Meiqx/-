package cn.tedu.entity;

public class Tag {
	private int oId;
	private int referenceCount;//关联文章数量
	private String title;//标签标题
	
	
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public int getReferenceCount() {
		return referenceCount;
	}
	public void setReferenceCount(int referenceCount) {
		this.referenceCount = referenceCount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override	
	public String toString() {
		return "Tag [oId=" + oId + ", referenceCount=" + referenceCount + ", title=" + title + "]";
	}
	public Tag(int oId, int referenceCount, String title) {
		super();
		this.oId = oId;
		this.referenceCount = referenceCount;
		this.title = title;
	}
	
	
}
