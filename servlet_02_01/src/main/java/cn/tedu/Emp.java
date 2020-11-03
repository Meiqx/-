package cn.tedu;

public class Emp {
	private int empno;
	private String name;
	private double sal;
	private double comm;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public Emp(int empno, String name, double sal, double comm) {
		super();
		this.empno = empno;
		this.name = name;
		this.sal = sal;
		this.comm = comm;
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", name=" + name + ", sal=" + sal + ", comm=" + comm + "]";
	}
	
	
}
