package day02;

import java.io.Serializable;

import org.springframework.core.style.ToStringCreator;

public class Worker implements Serializable {
	private String name = "���";
	private Axe axe;
	/*
	 * �����������ӿ���
	 */
	public void work() {
		System.out.println(name+"ʹ��"+axe+"����");
	}
	//bean ���Է��� ,bean����
	public void setAxe(Axe axe) {
		this.axe = axe;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {		
		return name;
	}
	
}
