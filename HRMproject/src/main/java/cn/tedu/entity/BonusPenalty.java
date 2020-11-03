package cn.tedu.entity;

import java.sql.Date;

public class BonusPenalty {
	
	private int id;
	

	private String username;
	private String job;
	private String occurTime;
	private Date happenTime;
	private String reason;
	private int price;
	private String details;
	private String register;
	private String registerTime;
	
	

	//登记奖惩的实例
	public BonusPenalty(String username, String job, String occurTime, String reason, int price, String details,
			String register) {
		super();
		this.username = username;
		this.job = job;
		this.occurTime = occurTime;
		this.reason = reason;
		this.price = price;
		this.details = details;
		this.register = register;
	}
	//列表实例
	public BonusPenalty(int id, String username, String job, String occurTime, String reason) {
		super();
		this.id = id;
		this.username = username;
		this.job = job;
		this.occurTime = occurTime;
		this.reason = reason;
	}	

	//查看的实例
	public BonusPenalty(int id, String username, String job, String occurTime, String reason, int price, String details,
			String register) {
		super();
		this.id = id;
		this.username = username;
		this.job = job;
		this.occurTime = occurTime;
		this.reason = reason;
		this.price = price;
		this.details = details;
		this.register = register;
	}

	//详情实例
	public BonusPenalty(String username, String job, Date happenTime, String reason, int price, String details,
			String register, String registerTime) {
		super();
		this.username = username;
		this.job = job;
		this.happenTime = happenTime;
		this.reason = reason;
		this.price = price;
		this.details = details;
		this.register = register;
		this.registerTime = registerTime;
	}	
	
	
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
	public String getOccurTime() {
		return occurTime;
	}
	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
	}
	public Date getHappenTime() {
		return happenTime;
	}
	public void setHappenTime(Date happenTime) {
		this.happenTime = happenTime;
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
	
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	@Override
	public String toString() {
		return "BonusPenalty [id=" + id + ", username=" + username + ", job=" + job + ", occurTime=" + occurTime
				+ ", happenTime=" + happenTime + ", reason=" + reason + ", price=" + price + ", details=" + details
				+ ", register=" + register + ", registerTime=" + registerTime + "]";
	}

	






}
