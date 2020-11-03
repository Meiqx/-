package cn.tedu.entity;

public class Emp {
	private int empno;
	private String ename;
	private double sal;
	private String job;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public Emp(int empno, String ename, double sal, String job) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.job = job;
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", job=" + job + "]";
	}
	
	
}
