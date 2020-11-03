package cn.tedu.hrm.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BonusPenalty implements Serializable{
	
	private int id;
	private String username;
	private String job;
	private String occurtime;
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date occurTime;
	private String reason;
	private int price;
	private String details;
	private String register;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date registerTime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getOccurtime() {
		return occurtime;
	}
	public void setOccurtime(String occurtime) {
		this.occurtime = occurtime;
	}
	public Date getOccurTime() {
		return occurTime;
	}
	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.occurtime = sdf.format(occurTime);
		System.out.println("setOccurTime(Date occurTime)");
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
		
	}
	@Override
	public String toString() {
		return "BonusPenalty [id=" + id + ", username=" + username + ", job=" + job + ", occurtime=" + occurtime
				+ ", occurTime=" + occurTime + ", reason=" + reason + ", price=" + price + ", details=" + details
				+ ", register=" + register + ", registerTime=" + registerTime + "]";
	}

	
	
	
}
