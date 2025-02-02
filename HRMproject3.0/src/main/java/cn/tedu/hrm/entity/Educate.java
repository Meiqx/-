package cn.tedu.hrm.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 公司员工培训信息类educate
 * @author JAVA
 *
 */
public class Educate implements Serializable{
	private	int id;
	private String name;
	private String purpose;  //培训目的
	private Date begintime;  //培训开始时间
	private Date endtime;   //培训结束时间
	private String datum;    //培训材料
	private String teacher;   //培训讲师
	private String student;   //培训人员
	private Date createtime;  //创建时间
	private int educate;   //培训是否完成
	private String  effect;  //培训效果
	private String summarize;  //总结

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Date getBegintime() {
		return begintime;
	}
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getEducate() {
		return educate;
	}
	public void setEducate(int eduvate) {
		this.educate = eduvate;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getSummarize() {
		return summarize;
	}
	public void setSummarize(String summarize) {
		this.summarize = summarize;
	}
	@Override
	public String toString() {
		return "Educate [id=" + id + ", name=" + name + ", purpose=" + purpose + ", begintime=" + begintime
				+ ", endtime=" + endtime + ", datum=" + datum + ", teacher=" + teacher + ", student=" + student
				+ ", createtime=" + createtime + ", educate=" + educate + ", effect=" + effect + ", summarize="
				+ summarize + "]";
	}
	public Educate(int id, String name, String purpose, Date begintime, Date endtime, String datum, String teacher,
			String student, Date createtime, int educate, String effect, String summarize) {
		super();
		this.id = id;
		this.name = name;
		this.purpose = purpose;
		this.begintime = begintime;
		this.endtime = endtime;
		this.datum = datum;
		this.teacher = teacher;
		this.student = student;
		this.createtime = createtime;
		this.educate = educate;
		this.effect = effect;
		this.summarize = summarize;
	}
	
	
	
}
