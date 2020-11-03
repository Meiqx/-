package cn.tedu.entity;

import java.util.Date;

public class Job {
	private int id;		
	private String name;	
	private int sex;	
	private int age;	
	private String job;	
	private String specialty;	//所学专业
	private String experience; 	//工作经验
	private String studyeffort;	//学历
	private String school;		//毕业院校
	private String tel;		//联系电话
	private String email;	//Email地址		
	private Date createtime;	//创建时间	
	private String content;		//详细经历
	private int isstock;	//是否入库
	
	private String sexStr; //性别(页面显示)
	private String isstockStr;
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getStudyeffort() {
		return studyeffort;
	}
	public void setStudyeffort(String studyeffort) {
		this.studyeffort = studyeffort;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsstock() {
		return isstock;
	}
	public void setIsstock(int isstock) {
		this.isstock = isstock;
	}
	public String getSexStr() {
		return sexStr;
	}
	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}
	public String getIsstockStr() {
		return isstockStr;
	}
	public void setIsstockStr(String isstockStr) {
		this.isstockStr = isstockStr;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", job=" + job + ", specialty="
				+ specialty + ", experience=" + experience + ", studyeffort=" + studyeffort + ", school=" + school
				+ ", tel=" + tel + ", email=" + email + ", createtime=" + createtime + ", content=" + content
				+ ", isstock=" + isstock + "]";
	}
	
	
}
