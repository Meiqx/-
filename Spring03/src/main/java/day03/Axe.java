package day03;

import java.io.Serializable;

public class Axe implements Tool,Serializable{
	private String name = "�������µ�";
	
	@Override
	public String toString() {		
		return name;
	}
}
