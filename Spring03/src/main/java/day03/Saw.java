package day03;

import java.io.Serializable;

public class Saw implements Tool,Serializable{
	private String name = "º®±ù¾â";
	@Override
	public String toString() {
		return name;
	}
}
