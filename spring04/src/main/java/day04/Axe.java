package day04;

import java.io.Serializable;

import org.springframework.stereotype.Component;


@Component   //默认类名axe
public class Axe implements Tool,Serializable{
	private String name = "开天符";

	@Override
	public String toString() {
		return name;
	}
	
}
