package day02;

import java.io.Serializable;

import org.springframework.core.style.ToStringCreator;

public class Worker implements Serializable {
	private String name = "吴刚";
	private Axe axe;
	/*
	 * 工人依赖斧子砍树
	 */
	public void work() {
		System.out.println(name+"使用"+axe+"砍树");
	}
	//bean 属性方法 ,bean属性
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
