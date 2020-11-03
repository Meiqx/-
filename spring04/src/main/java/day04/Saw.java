package day04;

import java.io.Serializable;

import org.springframework.stereotype.Component;

//@Component("tool")
public class Saw implements Tool,Serializable{
	private String name = "µç¾â";

	@Override
	public String toString() {
		return name;
	}	
	
}
