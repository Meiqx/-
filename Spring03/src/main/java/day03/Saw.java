package day03;

import java.io.Serializable;

public class Saw implements Tool,Serializable{
	private String name = "������";
	@Override
	public String toString() {
		return name;
	}
}
