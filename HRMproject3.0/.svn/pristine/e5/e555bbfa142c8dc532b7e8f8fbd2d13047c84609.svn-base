package cn.tedu.hrm.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.tedu.hrm.util.DateUtils;


/**
 * 应聘人员信息表job
 * @author JAVA
 *
 */
public class Job implements Serializable{
	private Integer id;		
	private String name;	
	private Integer sex;	
	private Integer age;	
	private String job;	
	private String specialty;	//所学专业
	private String experience; 	//工作经验
	private String studyeffort;	//学历
	private String school;		//毕业院校
	private String tel;		//联系电话
	private String email;	//Email地址
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createtime;	//创建时间	
	private String text;		//详细经历
	private Integer isstock;	//是否入库
	
	private String sexStr; //性别(页面显示)
	private String isstockStr;
	private String createtimeStr;

	public String getCreatetimeStr() {
		return DateUtils.getStringDate(createtime);
	}

	public void setCreatetimeStr(String createtimeStr) {
		this.createtimeStr = createtimeStr;
	}

	public String getIsstockStr() {
		if(this.isstock==1) {
			return "是";
		}else {
			return "否";
		}
	}

	public void setIsstockStr(String isstockStr) {
		this.isstockStr = isstockStr;
	}

	public String getSexStr() {
		if(this.sex==1) {
			return "男";
		}else {
			return "女";
		}

	}

	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getIsstock() {
		return isstock;
	}
	public void setIsstock(Integer isstock) {
		this.isstock = isstock;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", job=" + job + ", specialty="
				+ specialty + ", experience=" + experience + ", studyeffort=" + studyeffort + ", school=" + school
				+ ", tel=" + tel + ", email=" + email + ", createtime=" + createtime + ", text=" + text
				+ ", isstock=" + isstock + "]";
	}

	public Job(Integer id, String name, Integer sex, Integer age, String job, String specialty, String experience,
			String studyeffort, String school, String tel, String email, Date createtime, String text, Integer isstock) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.job = job;
		this.specialty = specialty;
		this.experience = experience;
		this.studyeffort = studyeffort;
		this.school = school;
		this.tel = tel;
		this.email = email;
		this.createtime = createtime;
		this.text = text;
		this.isstock = isstock;
	}

	public Job() {
		super();
	}
	
	




}
