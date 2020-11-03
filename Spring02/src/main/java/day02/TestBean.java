package day02;

import java.io.Serializable;

public class TestBean implements Serializable{
	private String name="test";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
