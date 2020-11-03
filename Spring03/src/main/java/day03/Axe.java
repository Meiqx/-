package day03;

import java.io.Serializable;

public class Axe implements Tool,Serializable{
	private String name = "ÇàÁúÙÈÔÂµ¶";
	
	@Override
	public String toString() {		
		return name;
	}
}
