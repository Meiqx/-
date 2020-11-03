package cn.tedu.hrm.entity;
/**
 * 公司员工薪资表salary
 */
 
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.tedu.hrm.util.DateUtils;


public class Salary implements Serializable {
	private int id;
	private String name;
	private double basic;	//基本薪资
	private double eat;		//饭补
	private double house;	//房补
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date granttime;	//工资发放时间
	private double duty;  	//全勤奖
	private double scot;	//赋税˰
	private double punishment;	//罚款
	private double other;		//额外补助
	private double totalize;	//总计
	
	
	public Salary() {
		super();
	}
	public Salary(int id, String name, double basic, double eat, double house, Date granttime, double duty, double scot,
			double punishment, double other, double totalize) {
		super();
		this.id = id;
		this.name = name;
		this.basic = basic;
		this.eat = eat;
		this.house = house;
		this.granttime = granttime;
		this.duty = duty;
		this.scot = scot;
		this.punishment = punishment;
		this.other = other;
		this.totalize = totalize;
	}
	@Override
	public String toString() {
		return "Salary [id=" + id + ", name=" + name + ", basic=" + basic + ", eat=" + eat + ", house=" + house
				+ ", granttime=" + granttime + ", duty=" + duty + ", scot=" + scot + ", punishment=" + punishment
				+ ", other=" + other + ", totalize=" + totalize + "]";
	}
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
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public double getEat() {
		return eat;
	}
	public void setEat(double eat) {
		this.eat = eat;
	}
	public double getHouse() {
		return house;
	}
	public void setHouse(double house) {
		this.house = house;
	}
	
//	将发薪日期转换为字符串形式
	public String getGranttime() {
		return DateUtils.getDateString(this.granttime);
	}
	public void setGranttime(Date granttime) {
		this.granttime = granttime;
	}
	public double getDuty() {
		return duty;
	}
	public void setDuty(double duty) {
		this.duty = duty;
	}
	public double getScot() {
		return scot;
	}
	public void setScot(double scot) {
		this.scot = scot;
	}
	public double getPunishment() {
		return punishment;
	}
	public void setPunishment(double punishment) {
		this.punishment = punishment;
	}
	public double getOther() {
		return other;
	}
	public void setOther(double other) {
		this.other = other;
	}
	public double getTotalize() {
		return totalize;
	}
	public void setTotalize(double totalize) {
		this.totalize = totalize;
	}
	
	
	
	
	
	
}
